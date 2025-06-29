
PATCHES_URI = "\
    file://0001-Allow-using-a-system-installed-libjpeg.patch \
    file://0002-Allow-using-a-system-installed-libpng.patch \
    file://0003-build-fix-build-on-as-needed-toolchains-generic.patch \
    file://0004-don-t-expect-fqpn-for-make.patch \
    file://0005-autoconf-filter-aclocal-copy-too.patch \
    file://0006-autoconf-handle-extra-output.patch \
    file://0007-fix-assembler-flag-handling-in-makefile.patch \
    file://0008-autoconf-fix-shark-build-common.patch \
    file://0009-prevent-debuginfo-in-favour-of-openembedded-package-.patch \
    file://0010-autoconf-remove-shell-variables-from-autoheader.patch \
    file://0013-autoconf-remove-Werror.patch \
    ${HOTSPOT_UB_PATCH} \
    file://2001-jdk-comparison-between-pointer-and-integer.patch \
    file://2002-jdk-Allow-using-a-system-installed-libjpeg.patch \
    file://2003-jdk-Allow-using-a-system-installed-libpng.patch \
    file://2004-jdk-use-correct-include-for-poll.patch \
    file://2005-jdk-use-correct-include-for-signal.patch \
    file://2006-jdk-disable-backtrace-musl-build-fix.patch \
    file://2007-jdk-no-genx11-in-headless.patch \
    file://2008-jdk-no-unused-deps.patch \
    file://2009-jdk-make-use-gcc-instead-of-ld-for-genSocketOptionRe.patch \
    file://0001-FIx-build-errors-with-gcc14.patch \
"
HOTSPOT_UB_PATCH = "\
    file://1001-hotspot-fix-crash-on-JNI_CreateJavaVM.patch \
    file://1002-hotspot-use-correct-include-for-poll.patch \
    file://1003-hotspot-don-t-rely-on-old-SysV-SIGCLD.patch \
    file://1004-hotspot-fix-Wreturn-type-issues-introduced-by-806165.patch \
    file://1005-hotspot-Zero-build-requires-disabled-warnings.patch \
    file://1006-hotspot-Missing-return-statement-in-__sync_val_compa.patch \
    file://1007-hotspot-Turn-on-the-Wreturn-type-warning.patch \
    file://1008-hotspot-handle-format-error-for-GCC-7.patch \
    file://1012-hotspot-enable-Wno-error.patch \
"
HOTSPOT_UB_PATCH:append:class-target = "\
    file://1009-hotspot-fix-adlc-flags.patch \
    file://1010-hotspot-fix-shark-build-common.patch \
    file://1011-hotspot-restrict-to-staging-dir.patch \
"
HOTSPOT_UB_PATCH:prepend:aarch64 = "\
    file://1401-hotspot-aarch64-Add-missing-return-value-to-LIR_Asse.patch \
"
HOTSPOT_UB_PATCH:append:armv7a = " file://1201-hotspot-aarch32-fix-missing-return-values.patch"
HOTSPOT_UB_PATCH:append:armv7ve = " file://1201-hotspot-aarch32-fix-missing-return-values.patch"

PATCHES_URI:append:class-target = "\
    file://1013-hotspot-add-missing-includes-for-shark-build-pt2.patch \
    file://0001-Fix-build-error-with-gcc15.patch  \
"

PATCHES_URI:append:libc-musl = "\
    ${OBSOLETE_ISNANF_PATCH} \
    file://musl-0002-jdk-give-a-much-bigger-buffer-to-getmntent_r.patch \
    file://musl-0003-jdk-fix-libjvm-load-on-musl-set-LD_LIBRARY_PATH.patch \
    file://musl-0004-jdk-remove-sysctl.h-include-musl-build-fix.patch \
    file://musl-0005-hotspot-disable-agent-build-common.patch \
    ${DISABLE_AGENT_BUILD_PT2} \
    file://musl-0006-hotspot-os_linux-remove-glibc-dependencies-common.patch \
    ${REMOVE_GLIBC_DEPENDENCIES_PT2} \
    file://musl-0007-hotspot-os_linux_x86-remove-glibc-dependencies-fpu_c.patch \
    file://musl-0008-jdk-musl-build-fix-use-SIGRTMAX-rather-than-__SIGRTM.patch \
    file://musl-0009-jdk-musl-has-gethostby_r.patch \
"
OBSOLETE_ISNANF_PATCH = "file://musl-0001-hotspot-stop-using-obsolete-isnanf.patch"
OBSOLETE_ISNANF_PATCH:armv7a = ""
OBSOLETE_ISNANF_PATCH:armv7ve = ""
DISABLE_AGENT_BUILD_PT2 = "file://musl-0005-hotspot-disable-agent-build-pt2.patch"
DISABLE_AGENT_BUILD_PT2:armv7a = "file://musl-0005-hotspot-disable-agent-build-pt2-aarch32.patch"
DISABLE_AGENT_BUILD_PT2:armv7ve = "file://musl-0005-hotspot-disable-agent-build-pt2-aarch32.patch"
REMOVE_GLIBC_DEPENDENCIES_PT2 = "file://musl-0006-hotspot-os_linux-remove-glibc-dependencies-pt2.patch"
REMOVE_GLIBC_DEPENDENCIES_PT2:armv7a = "file://musl-0006-hotspot-os_linux-remove-glibc-dependencies-pt2-aarch.patch"
REMOVE_GLIBC_DEPENDENCIES_PT2:armv7ve = "file://musl-0006-hotspot-os_linux-remove-glibc-dependencies-pt2-aarch.patch"

PATCHES_URI:append:libc-musl:armv7a = " file://1202-hotspot-aarch32-remaining-musl-fixes.patch"
PATCHES_URI:append:libc-musl:armv7ve = " file://1202-hotspot-aarch32-remaining-musl-fixes.patch"
PATCHES_URI:append:libc-musl:aarch64 = " file://1402-hotspot-aarch64-remaining-musl-fixes.patch"

# remove aarch32 & aarch64 mainlined patches
PATCHES_URI:remove:armv7a = "file://2009-jdk-make-use-gcc-instead-of-ld-for-genSocketOptionRe.patch"
PATCHES_URI:remove:armv7ve = "file://2009-jdk-make-use-gcc-instead-of-ld-for-genSocketOptionRe.patch"
PATCHES_URI:remove:aarch64 = "file://2009-jdk-make-use-gcc-instead-of-ld-for-genSocketOptionRe.patch"

# Name of the directory containing the compiled output
BUILD_DIR = "openjdk.build"
BUILD_DIR_ECJ = "openjdk.build-ecj"

# Force arm mode for now
ARM_INSTRUCTION_SET:armv4t = "ARM"

# Enable zero mode for arm based builds, as normal hotspot fails to build
PACKAGECONFIG:append:armv4 = " zero"
PACKAGECONFIG:append:armv5 = " zero"
PACKAGECONFIG:append:armv6 = " zero"

OPENJDK_ARCH_PORT = "jdk8u"
OPENJDK_ARCH_PORT:aarch64 = "aarch64-port"
OPENJDK_ARCH_PORT:armv7a = "aarch32-port"
OPENJDK_ARCH_PORT:armv7ve = "aarch32-port"
OPENJDK_HG_U = "jdk8u"

# the aarch64 port moved, for more information see:
# https://mail.openjdk.java.net/pipermail/aarch64-port-dev/2018-August/006265.html
OPENJDK_HG_U:aarch64 = "jdk8u-shenandoah"

OPENJDK_HG_URL = "https://hg.openjdk.java.net/${OPENJDK_ARCH_PORT}/${OPENJDK_HG_U}"

OPENJDK_FILE = "${OPENJDK_CHANGESET}.tar.bz2"
OPENJDK_FILE_LOCAL = "openjdk8-${PV}-jdk8u-${OPENJDK_FILE}"
OPENJDK_URI = "${OPENJDK_HG_URL}/archive/${OPENJDK_FILE};downloadfilename=${OPENJDK_FILE_LOCAL};name=openjdk"

HOTSPOT_FILE = "${HOTSPOT_CHANGESET}.tar.bz2"
HOTSPOT_FILE_LOCAL = "openjdk8-${PV}-hotspot-${HOTSPOT_FILE}"
HOTSPOT_URI = "${OPENJDK_HG_URL}/hotspot/archive/${HOTSPOT_FILE};downloadfilename=${HOTSPOT_FILE_LOCAL};name=hotspot;unpack=false"

CORBA_FILE = "${CORBA_CHANGESET}.tar.bz2"
CORBA_FILE_LOCAL = "openjdk8-${PV}-corba-${CORBA_FILE}"
CORBA_URI = "${OPENJDK_HG_URL}/corba/archive/${CORBA_FILE};downloadfilename=${CORBA_FILE_LOCAL};name=corba;unpack=false"

JAXP_FILE = "${JAXP_CHANGESET}.tar.bz2"
JAXP_FILE_LOCAL = "openjdk8-${PV}-jaxp-${JAXP_FILE}"
JAXP_URI = "${OPENJDK_HG_URL}/jaxp/archive/${JAXP_FILE};downloadfilename=${JAXP_FILE_LOCAL};name=jaxp;unpack=false"

JAXWS_FILE = "${JAXWS_CHANGESET}.tar.bz2"
JAXWS_FILE_LOCAL = "openjdk8-${PV}-jaxws-${JAXWS_FILE}"
JAXWS_URI = "${OPENJDK_HG_URL}/jaxws/archive/${JAXWS_FILE};downloadfilename=${JAXWS_FILE_LOCAL};name=jaxws;unpack=false"

JDK_FILE = "${JDK_CHANGESET}.tar.bz2"
JDK_FILE_LOCAL = "openjdk8-${PV}-jdk-${JDK_FILE}"
JDK_URI = "${OPENJDK_HG_URL}/jdk/archive/${JDK_FILE};downloadfilename=${JDK_FILE_LOCAL};name=jdk;unpack=false"

LANGTOOLS_FILE = "${LANGTOOLS_CHANGESET}.tar.bz2"
LANGTOOLS_FILE_LOCAL = "openjdk8-${PV}-langtools-${LANGTOOLS_FILE}"
LANGTOOLS_URI = "${OPENJDK_HG_URL}/langtools/archive/${LANGTOOLS_FILE};downloadfilename=${LANGTOOLS_FILE_LOCAL};name=langtools;unpack=false"

NASHORN_FILE = "${NASHORN_CHANGESET}.tar.bz2"
NASHORN_FILE_LOCAL = "openjdk8-${PV}-nashorn-${NASHORN_FILE}"
NASHORN_URI = "${OPENJDK_HG_URL}/nashorn/archive/${NASHORN_FILE};downloadfilename=${NASHORN_FILE_LOCAL};name=nashorn;unpack=false"
