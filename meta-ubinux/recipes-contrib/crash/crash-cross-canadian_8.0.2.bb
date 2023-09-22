inherit cross-canadian

SUMMARY = "Kernel analysis utility for live systems, netdump, diskdump, kdump, LKCD or mcore dumpfiles"
DESCRIPTION = "The core analysis suite is a self-contained tool that can be used to\
investigate either live systems, kernel core dumps created from the\
netdump, diskdump and kdump packages from Red Hat Linux, the mcore kernel patch\
offered by Mission Critical Linux, or the LKCD kernel patch."

HOMEPAGE = "http://people.redhat.com/anderson"
SECTION = "devel"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING3;md5=d32239bcb673463ab874e80d47fae504"

PN = "crash-cross-canadian-${TRANSLATED_TARGET_ARCH}"

DEPENDS = "virtual/${HOST_PREFIX}gcc virtual/nativesdk-libc nativesdk-zlib nativesdk-gettext \
           nativesdk-readline virtual/nativesdk-${HOST_PREFIX}compilerlibs\
           nativesdk-coreutils nativesdk-ncurses"

FILESEXTRAPATHS:prepend := "${THISDIR}/crash:"

S = "${WORKDIR}/git"
SRC_URI = "git://github.com/crash-utility/crash.git;branch=master;protocol=https \
           ${GNU_MIRROR}/gdb/gdb-10.2.tar.gz;name=gdb;subdir=git \
           file://7001force_define_architecture.patch \
           file://7003cross_ranlib.patch \
           file://0001-cross_add_configure_option.patch \
           file://donnot-extract-gdb-during-do-compile.patch \
           file://gdb_build_jobs_and_not_write_crash_target.patch \
           file://0001-make-src-string-const-in-strlcpy.patch \
           "
SRCREV = "f1cd581d1c4afa5b8ffdfaa6a3ea9f545fe4ec91"

SRC_URI[gdb.sha256sum] = "b33ad58d687487a821ec8d878daab0f716be60d0936f2e3ac5cf08419ce70350"

UPSTREAM_CHECK_URI = "https://github.com/crash-utility/crash/releases"

#inherit gettext

TARGET_CC_ARCH:append = " ${SELECTED_OPTIMIZATION}"

# crash 7.1.3 and before don't support mips64/riscv64
COMPATIBLE_HOST:riscv64 = "null"
COMPATIBLE_HOST:riscv32 = "null"
COMPATIBLE_HOST:mipsarchn64 = "null"
COMPATIBLE_HOST:mipsarchn32 = "null"


EXTRA_OEMAKE = 'RPMPKG="${PV}" \
                GDB_TARGET="${BUILD_SYS} --target=${TARGET_SYS}" \
                GDB_HOST="${SDK_SYS}" \
                GDB_MAKE_JOBS=" " \
               '
#target=${TARGET_ARCH} 
#EXTRA_OEMAKE:append = "${HOST_CC_ARCH} LDFLAGS='${BUILD_LDFLAGS}'"
EXTRA_OEMAKE:append = " LDFLAGS='${LDFLAGS}'"

do_configure() {
    :
}

do_compile:prepend() {
    case ${TARGET_ARCH} in
        aarch64*)    ARCH=ARM64 ;;
        arm*)        ARCH=ARM ;;
        i*86*)       ARCH=X86 ;;
        x86_64*)     ARCH=X86_64 ;;
        powerpc64*)  ARCH=PPC64 ;;
        powerpc*)    ARCH=PPC ;;
        mips*)       ARCH=MIPS ;;
    esac

    sed -i s/FORCE_DEFINE_ARCH/"${ARCH}"/g ${S}/configure.c
    sed -i -e 's/#define TARGET_CFLAGS_ARM_ON_X86_64.*/#define TARGET_CFLAGS_ARM_ON_X86_64\t\"TARGET_CFLAGS=-D_FILE_OFFSET_BITS=64\"/g' ${S}/configure.c
    sed -i 's/&gt;/>/g' ${S}/Makefile
}

do_compile() {
    oe_runmake ${EXTRA_OEMAKE} RECIPE_SYSROOT=${STAGING_DIR_HOST}${SDKPATHNATIVE}
}

do_install:prepend () {
    install -d ${D}${bindir}
    install -d ${D}/${mandir}/man8
    install -d ${D}${includedir}/crash

    install -m 0644 ${S}/crash.8 ${D}/${mandir}/man8/
    install -m 0644 ${S}/defs.h ${D}${includedir}/crash
}

do_install () {
    install -m 0755 ${S}/crash ${D}/${bindir}

    cross_canadian_bindirlinks
}

RDEPENDS:${PN} += "nativesdk-xz"

ARM_INSTRUCTION_SET = "arm"

BBCLASSEXTEND = ""
