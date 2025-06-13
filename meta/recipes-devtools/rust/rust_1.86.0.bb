SUMMARY = "Rust compiler and runtime libaries"
HOMEPAGE = "http://www.rust-lang.org"
SECTION = "devel"
LICENSE = "(MIT | Apache-2.0) & Unicode-3.0"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=11a3899825f4376896e438c8c753f8dc"

inherit rust
inherit cargo_common

DEPENDS += "rust-llvm pkgconfig-native openssl ninja-native"
# native rust uses cargo/rustc from binary snapshots to bootstrap
# but everything else should use our native builds
DEPENDS:append:class-target = " cargo-native rust-native"
DEPENDS:append:class-nativesdk = " cargo-native rust-native"

RDEPENDS:${PN}:append:class-target = " gcc g++ binutils bash"

# Otherwise we'll depend on what we provide
INHIBIT_DEFAULT_RUST_DEPS:class-native = "1"
# We don't need to depend on gcc-native because yocto assumes it exists
PROVIDES:class-native = "virtual/${TARGET_PREFIX}rust"

S = "${RUSTSRC}"

# Use at your own risk, accepted values are stable, beta and nightly
RUST_CHANNEL ?= "stable"
PV .= "${@bb.utils.contains('RUST_CHANNEL', 'stable', '', '-${RUST_CHANNEL}', d)}"

export FORCE_CRATE_HASH = "${BB_TASKHASH}"

RUST_ALTERNATE_EXE_PATH ?= "${STAGING_LIBDIR}/llvm-rust/bin/llvm-config"
RUST_ALTERNATE_EXE_PATH_NATIVE = "${STAGING_LIBDIR_NATIVE}/llvm-rust/bin/llvm-config"

# We don't want to use bitbakes vendoring because the rust sources do their
# own vendoring.
CARGO_DISABLE_BITBAKE_VENDORING = "1"

setup_cargo_environment () {
    # The first step is to build bootstrap and some early stage tools,
    # these are build for the same target as the snapshot, e.g.
    # x86_64-unknown-linux-gnu.
    # Later stages are build for the native target (i.e. target.x86_64-linux)
    cargo_common_do_configure
}

inherit rust-target-config

do_rust_setup_snapshot () {
    for installer in "${UNPACKDIR}/rust-snapshot-components/"*"/install.sh"; do
        "${installer}" --prefix="${WORKDIR}/rust-snapshot" --disable-ldconfig
    done

    # Some versions of rust (e.g. 1.18.0) tries to find cargo in stage0/bin/cargo
    # and fail without it there.
    mkdir -p ${RUSTSRC}/build/${RUST_BUILD_SYS}
    ln -sf ${WORKDIR}/rust-snapshot/ ${RUSTSRC}/build/${RUST_BUILD_SYS}/stage0

    # Need to use uninative's loader if enabled/present since the library paths
    # are used internally by rust and result in symbol mismatches if we don't
    if [ ! -z "${UNINATIVE_LOADER}" -a -e "${UNINATIVE_LOADER}" ]; then
        for bin in cargo rustc rustdoc; do
            patchelf ${WORKDIR}/rust-snapshot/bin/$bin --set-interpreter ${UNINATIVE_LOADER}
        done
    fi
}
addtask rust_setup_snapshot after do_unpack before do_configure
addtask do_test_compile after do_configure do_rust_gen_targets
do_rust_setup_snapshot[dirs] += "${WORKDIR}/rust-snapshot"
do_rust_setup_snapshot[vardepsexclude] += "UNINATIVE_LOADER"
do_rust_setup_snapshot[depends] += "patchelf-native:do_populate_sysroot"

RUSTC_BOOTSTRAP = "${STAGING_BINDIR_NATIVE}/rustc"
CARGO_BOOTSTRAP = "${STAGING_BINDIR_NATIVE}/cargo"
RUSTC_BOOTSTRAP:class-native = "${WORKDIR}/rust-snapshot/bin/rustc"
CARGO_BOOTSTRAP:class-native = "${WORKDIR}/rust-snapshot/bin/cargo"

python do_configure() {
    import json
    import configparser

    # toml is rather similar to standard ini like format except it likes values
    # that look more JSON like. So for our purposes simply escaping all values
    # as JSON seem to work fine.

    e = lambda s: json.dumps(s)

    config = configparser.RawConfigParser()

    # [target.ARCH-poky-linux]
    host_section = "target.{}".format(d.getVar('RUST_HOST_SYS'))
    config.add_section(host_section)

    llvm_config_target = d.expand("${RUST_ALTERNATE_EXE_PATH}")
    llvm_config_build = d.expand("${RUST_ALTERNATE_EXE_PATH_NATIVE}")
    config.set(host_section, "llvm-config", e(llvm_config_target))

    config.set(host_section, "cxx", e(d.expand("${RUST_TARGET_CXX}")))
    config.set(host_section, "cc", e(d.expand("${RUST_TARGET_CC}")))
    config.set(host_section, "linker", e(d.expand("${RUST_TARGET_CCLD}")))
    if "musl" in host_section:
        config.set(host_section, "musl-root", e(d.expand("${STAGING_DIR_HOST}${exec_prefix}")))

    # If we don't do this rust-native will compile it's own llvm for BUILD.
    # [target.${BUILD_ARCH}-unknown-linux-gnu]
    build_section = "target.{}".format(d.getVar('RUST_BUILD_SYS'))
    if build_section != host_section:
        config.add_section(build_section)

        config.set(build_section, "llvm-config", e(llvm_config_build))

        config.set(build_section, "cxx", e(d.expand("${RUST_BUILD_CXX}")))
        config.set(build_section, "cc", e(d.expand("${RUST_BUILD_CC}")))
        config.set(build_section, "linker", e(d.expand("${RUST_BUILD_CCLD}")))

    target_section = "target.{}".format(d.getVar('RUST_TARGET_SYS'))
    if target_section != host_section and target_section != build_section:
        config.add_section(target_section)

        config.set(target_section, "llvm-config", e(llvm_config_target))

        config.set(target_section, "cxx", e(d.expand("${RUST_TARGET_CXX}")))
        config.set(target_section, "cc", e(d.expand("${RUST_TARGET_CC}")))
        config.set(target_section, "linker", e(d.expand("${RUST_TARGET_CCLD}")))

    # [llvm]
    config.add_section("llvm")
    config.set("llvm", "static-libstdcpp", e(False))
    config.set("llvm", "download-ci-llvm", e(False))
    if "llvm" in (d.getVar('TC_CXX_RUNTIME') or ""):
        config.set("llvm", "use-libcxx", e(True))

    # [rust]
    config.add_section("rust")
    config.set("rust", "rpath", e(True))
    config.set("rust", "remap-debuginfo", e(True))
    config.set("rust", "download-rustc", e(False))
    config.set("rust", "llvm-tools", e(False))
    config.set("rust", "lld", e(False))
    config.set("rust", "use-lld", e(False))
    config.set("rust", "channel", e(d.expand("${RUST_CHANNEL}")))

    # Whether or not to optimize the compiler and standard library
    config.set("rust", "optimize", e(True))

    # Emits extraneous output from tests to ensure that failures of the test
    # harness are debuggable just from logfiles
    config.set("rust", "verbose-tests", e(True))

    # [build]
    config.add_section("build")
    config.set("build", "submodules", e(False))
    config.set("build", "docs", e(False))

    rustc = d.getVar('RUSTC_BOOTSTRAP')
    config.set("build", "rustc", e(rustc))

    cargo = d.getVar('CARGO_BOOTSTRAP')
    config.set("build", "cargo", e(cargo))

    config.set("build", "extended", e(False))

    config.set("build", "vendor", e(True))

    config.set("build", "target", e([d.getVar("RUST_TARGET_SYS")]))

    config.set("build", "host", e([d.getVar("RUST_HOST_SYS")]))

    # We can't use BUILD_SYS since that is something the rust snapshot knows
    # nothing about when trying to build some stage0 tools (like fabricate)
    config.set("build", "build", e(d.getVar("RUST_BUILD_SYS")))

    # [install]
    config.add_section("install")
    # ./x.py install doesn't have any notion of "destdir"
    # but we can prepend ${D} to all the directories instead
    config.set("install", "prefix",  e(d.getVar("D") + d.getVar("prefix")))
    config.set("install", "bindir",  e(d.getVar("D") + d.getVar("bindir")))
    config.set("install", "libdir",  e(d.getVar("D") + d.getVar("libdir")))
    config.set("install", "datadir", e(d.getVar("D") + d.getVar("datadir")))
    config.set("install", "mandir",  e(d.getVar("D") + d.getVar("mandir")))
    config.set("install", "sysconfdir",  e(d.getVar("D") + d.getVar("sysconfdir")))

    with open("config.toml", "w") as f:
        f.write('change-id = 116881\n\n')
        config.write(f)

    # set up ${WORKDIR}/cargo_home
    bb.build.exec_func("setup_cargo_environment", d)
}

rust_runx () {
    echo "COMPILE ${PN}" "$@"

    # CFLAGS, LDFLAGS, CXXFLAGS, CPPFLAGS are used by rust's build for a
    # wide range of targets (not just TARGET). Yocto's settings for them will
    # be inappropriate, avoid using.
    unset CFLAGS
    unset LDFLAGS
    unset CXXFLAGS
    unset CPPFLAGS

    export RUSTFLAGS="${RUST_DEBUG_REMAP}"

    # Copy the natively built llvm-config into the target so we can run it. Horrible,
    # but works!
    if [ ${RUST_ALTERNATE_EXE_PATH_NATIVE} != ${RUST_ALTERNATE_EXE_PATH} -a ! -f ${RUST_ALTERNATE_EXE_PATH} ]; then
        mkdir -p `dirname ${RUST_ALTERNATE_EXE_PATH}`
        cp ${RUST_ALTERNATE_EXE_PATH_NATIVE} ${RUST_ALTERNATE_EXE_PATH}
        if [ -e ${STAGING_LIBDIR_NATIVE}/libc++.so.1 ]; then
            patchelf --set-rpath \$ORIGIN/../../../../../`basename ${STAGING_DIR_NATIVE}`${libdir_native} ${RUST_ALTERNATE_EXE_PATH}
        else
            patchelf --remove-rpath ${RUST_ALTERNATE_EXE_PATH}
        fi
    fi

    oe_cargo_fix_env

    python3 src/bootstrap/bootstrap.py ${@oe.utils.parallel_make_argument(d, '-j %d')} "$@" --verbose
}
rust_runx[vardepsexclude] += "PARALLEL_MAKE"

require rust-source.inc
require rust-snapshot.inc

INSANE_SKIP:${PN}:class-native = "already-stripped"
FILES:${PN} += "${libdir}/rustlib"
FILES:${PN} += "${libdir}/*.so"
FILES:${PN}-dev = ""

do_compile () {
}

do_test_compile[dirs] = "${B}"
do_test_compile () {
    rust_runx build src/tools/remote-test-server --target "${RUST_TARGET_SYS}"
}

ALLOW_EMPTY:${PN} = "1"

PACKAGES =+ "${PN}-rustdoc ${PN}-tools-clippy ${PN}-tools-rustfmt ${PN}-zsh-completion"
FILES:${PN}-rustdoc = "${bindir}/rustdoc"
FILES:${PN}-tools-clippy = "${bindir}/cargo-clippy ${bindir}/clippy-driver"
FILES:${PN}-tools-rustfmt = "${bindir}/rustfmt"
FILES:${PN}-zsh-completion = "${datadir}/zsh"

RDEPENDS:${PN}-rustdoc = "${PN}"
RDEPENDS:${PN}-tools-clippy = "${PN}"
RDEPENDS:${PN}-tools-rustfmt = "${PN}"

SUMMARY:${PN}-tools-clippy = "A collection of lints to catch common mistakes and improve your Rust code"
SUMMARY:${PN}-tools-rustfmt = "A tool for formatting Rust code according to style guidelines"

do_install () {
    rust_do_install
}

rust_do_install() {
    rust_runx install
}

rust_do_install:append:class-native () {
    rm -f ${D}${bindir}/cargo
}

rust_do_install:class-nativesdk() {
    export PSEUDO_UNLOAD=1
    rust_runx install
    rust_runx install clippy
    rust_runx install rustfmt
    unset PSEUDO_UNLOAD

    install -d ${D}${bindir}
    for i in cargo-clippy clippy-driver rustfmt; do
        cp build/${RUST_BUILD_SYS}/stage2-tools/${RUST_HOST_SYS}/release/$i ${D}${bindir}
        patchelf --set-rpath "\$ORIGIN/../lib" ${D}${bindir}/$i
    done

    chown root:root ${D}/ -R
    rm ${D}${libdir}/rustlib/uninstall.sh
    rm ${D}${libdir}/rustlib/install.log
    rm ${D}${libdir}/rustlib/manifest*
    rm ${D}${libdir}/rustlib/${RUST_HOST_SYS}/lib/libstd*.so

    ENV_SETUP_DIR=${D}${base_prefix}/environment-setup.d
    mkdir "${ENV_SETUP_DIR}"
    RUST_ENV_SETUP_SH="${ENV_SETUP_DIR}/rust.sh"
    RUST_HOST_TRIPLE=`echo ${RUST_HOST_SYS} | tr '[:lower:]' '[:upper:]' | sed 's/-/_/g'`
    RUST_HOST_CC=`echo ${RUST_HOST_SYS} | sed 's/-/_/g'`
    SDKLOADER=${@bb.utils.contains('SDK_ARCH', 'x86_64', 'ld-linux-x86-64.so.2', '', d)}${@bb.utils.contains('SDK_ARCH', 'i686', 'ld-linux.so.2', '', d)}${@bb.utils.contains('SDK_ARCH', 'aarch64', 'ld-linux-aarch64.so.1', '', d)}${@bb.utils.contains('SDK_ARCH', 'ppc64le', 'ld64.so.2', '', d)}${@bb.utils.contains('SDK_ARCH', 'riscv64', 'ld-linux-riscv64-lp64d.so.1', '', d)}

    cat <<- EOF > "${RUST_ENV_SETUP_SH}"
	export CARGO_TARGET_${RUST_HOST_TRIPLE}_RUNNER="\$OECORE_NATIVE_SYSROOT/lib/${SDKLOADER}"
	export CC_$RUST_HOST_CC="${CCACHE}${HOST_PREFIX}gcc"
	EOF
}

FILES:${PN} += "${base_prefix}/environment-setup.d"

EXTRA_TOOLS ?= "cargo-clippy clippy-driver rustfmt"
rust_do_install:class-target() {
    export PSEUDO_UNLOAD=1
    rust_runx install
    rust_runx install clippy
    rust_runx install rustfmt
    unset PSEUDO_UNLOAD

    install -d ${D}${bindir}
    for i in ${EXTRA_TOOLS}; do
        cp build/${RUST_BUILD_SYS}/stage2-tools/${RUST_HOST_SYS}/release/$i ${D}${bindir}
        patchelf --set-rpath "\$ORIGIN/../lib" ${D}${bindir}/$i
    done

    install -d ${D}${libdir}/rustlib/${RUST_HOST_SYS}
    install -m 0644 ${WORKDIR}/rust-targets/${RUST_HOST_SYS}.json ${D}${libdir}/rustlib/${RUST_HOST_SYS}/target.json

    chown root:root ${D}/ -R
    rm ${D}${libdir}/rustlib/uninstall.sh
    rm ${D}${libdir}/rustlib/install.log
    rm ${D}${libdir}/rustlib/manifest*
    rm ${D}${libdir}/rustlib/${RUST_HOST_SYS}/lib/libstd*.so
}

addtask do_update_snapshot after do_patch
do_update_snapshot[nostamp] = "1"

# Run with `bitbake -c update_snapshot rust` to update `rust-snapshot.inc`
# with the checksums for the rust snapshot associated with this rustc-src
# tarball.
python do_update_snapshot() {
    import json
    import re
    import sys

    from collections import defaultdict

    key_value_pairs = {}
    with open(os.path.join(d.getVar("S"), "src", "stage0")) as f:
        for line in f:
            # Skip empty lines or comments
            if not line.strip() or line.startswith("#"):
                continue
            # Split the line into key and value using '=' as separator
            match = re.match(r'(\S+)\s*=\s*(\S+)', line.strip())
            if match:
                key = match.group(1)
                value = match.group(2)
                key_value_pairs[key] = value
    # Extract the required values from key_value_pairs
    config_dist_server = key_value_pairs.get('dist_server', '')
    compiler_date = key_value_pairs.get('compiler_date', '')
    compiler_version = key_value_pairs.get('compiler_version', '')

    src_uri = defaultdict(list)
    # Assuming checksums_sha256 is now a key-value pair like: checksum_key = checksum_value
    for k, v in key_value_pairs.items():
        # Match the pattern for checksums
        if "dist" in k and "tar.xz" in k:
            m = re.search(f"dist/{compiler_date}/(?P<component>.*)-{compiler_version}-(?P<arch>.*)-unknown-linux-gnu\\.tar\\.xz", k)
            if m:
                component = m.group('component')
                arch = m.group('arch')
                src_uri[arch].append(f"SRC_URI[{component}-snapshot-{arch}.sha256sum] = \"{v}\"")
    # Create the snapshot string with the extracted values
    snapshot = """\
## This is information on the rust-snapshot (binary) used to build our current release.
## snapshot info is taken from rust/src/stage0
## Rust is self-hosting and bootstraps itself with a pre-built previous version of itself.
## The exact (previous) version that has been used is specified in the source tarball.
## The version is replicated here.

SNAPSHOT_VERSION = "%s"

""" % compiler_version
    # Add the checksum components to the snapshot
    for arch, components in src_uri.items():
        snapshot += "\n".join(components) + "\n\n"
    # Add the additional snapshot URIs
    snapshot += """\
SRC_URI += " \\
    ${RUST_DIST_SERVER}/dist/${RUST_STD_SNAPSHOT}.tar.xz;name=rust-std-snapshot-${RUST_BUILD_ARCH};subdir=rust-snapshot-components \\
    ${RUST_DIST_SERVER}/dist/${RUSTC_SNAPSHOT}.tar.xz;name=rustc-snapshot-${RUST_BUILD_ARCH};subdir=rust-snapshot-components \\
    ${RUST_DIST_SERVER}/dist/${CARGO_SNAPSHOT}.tar.xz;name=cargo-snapshot-${RUST_BUILD_ARCH};subdir=rust-snapshot-components \\
"

RUST_DIST_SERVER = "%s"

RUST_STD_SNAPSHOT = "rust-std-${SNAPSHOT_VERSION}-${RUST_BUILD_ARCH}-unknown-linux-gnu"
RUSTC_SNAPSHOT = "rustc-${SNAPSHOT_VERSION}-${RUST_BUILD_ARCH}-unknown-linux-gnu"
CARGO_SNAPSHOT = "cargo-${SNAPSHOT_VERSION}-${RUST_BUILD_ARCH}-unknown-linux-gnu"
""" % config_dist_server
    # Write the updated snapshot information to the rust-snapshot.inc file
    with open(os.path.join(d.getVar("THISDIR"), "rust-snapshot.inc"), "w") as f:
        f.write(snapshot)
}

RUSTLIB_DEP:class-nativesdk = ""

# musl builds include libunwind.a
INSANE_SKIP:${PN} = "staticdev"

BBCLASSEXTEND = "native nativesdk"
