SUMMARY = "Utilities for managing LZMA compressed files"
HOMEPAGE = "https://tukaani.org/xz/"
DESCRIPTION = "XZ Utils is free general-purpose data compression software with a high compression ratio. XZ Utils were written for POSIX-like systems, but also work on some not-so-POSIX systems. XZ Utils are the successor to LZMA Utils."
SECTION = "base"

# The source includes bits of PD, GPL-2.0, GPL-3.0, LGPL-2.1-or-later, but the
# only file which is GPL-3.0 is an m4 macro which isn't shipped in any of our
# packages, and the LGPL bits are under lib/, which appears to be used for
# libgnu, which appears to be used for DOS builds. So we're left with
# GPL-2.0-or-later and PD.
LICENSE = "GPL-2.0-or-later & GPL-3.0-with-autoconf-exception & LGPL-2.1-or-later & PD"
LICENSE:${PN} = "GPL-2.0-or-later"
LICENSE:${PN}-dev = "GPL-2.0-or-later"
LICENSE:${PN}-staticdev = "GPL-2.0-or-later"
LICENSE:${PN}-doc = "GPL-2.0-or-later"
LICENSE:${PN}-dbg = "GPL-2.0-or-later"
LICENSE:${PN}-locale = "GPL-2.0-or-later"
LICENSE:liblzma = "PD"

LIC_FILES_CHKSUM = "file://COPYING;md5=d4378ea9d5d1fc9ab0ae10d7948827d9 \
                    file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://COPYING.GPLv3;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://COPYING.LGPLv2.1;md5=4fbd65380cdd255951079008b364516c \
                    file://lib/getopt.c;endline=23;md5=2069b0ee710572c03bb3114e4532cd84 \
                    "

SRC_URI = "https://github.com/tukaani-project/xz/releases/download/v${PV}/xz-${PV}.tar.gz \
           file://run-ptest \
          "
SRC_URI[sha256sum] = "aeba3e03bf8140ddedf62a0a367158340520f6b384f75ca6045ccc6c0d43fd5c"
UPSTREAM_CHECK_REGEX = "xz-(?P<pver>\d+(\.\d+)+)\.tar"

CACHED_CONFIGUREVARS += "gl_cv_posix_shell=/bin/sh"

inherit autotools gettext ptest

PACKAGES =+ "liblzma"

FILES:liblzma = "${libdir}/liblzma*${SOLIBS}"

inherit update-alternatives
ALTERNATIVE_PRIORITY = "100"
ALTERNATIVE:${PN} = "xz xzcat unxz \
                     lzma lzcat unlzma"

BBCLASSEXTEND = "native nativesdk"

RDEPENDS:${PN}-ptest += "bash file"

do_compile_ptest() {
        oe_runmake check TESTS=
}

do_install_ptest () {
    install -d ${D}${PTEST_PATH}/tests
    find ${B}/tests/.libs -type f -executable -exec cp {} ${D}${PTEST_PATH}/tests \;
    cp ${B}/config.h ${D}${PTEST_PATH}
    for i in files xzgrep_expected_output test_files.sh test_scripts.sh test_compress.sh; do
        cp -r ${S}/tests/$i ${D}${PTEST_PATH}/tests
    done
    mkdir -p ${D}${PTEST_PATH}/src/xz
    ln -s ${bindir}/xz ${D}${PTEST_PATH}/src/xz/xz
    mkdir -p ${D}${PTEST_PATH}/src/xzdec
    ln -s ${bindir}/xzdec ${D}${PTEST_PATH}/src/xzdec/xzdec
    mkdir -p ${D}${PTEST_PATH}/src/scripts
    ln -s ${bindir}/xzdiff ${D}${PTEST_PATH}/src/scripts/xzdiff
    ln -s ${bindir}/xzgrep ${D}${PTEST_PATH}/src/scripts/xzgrep
}
