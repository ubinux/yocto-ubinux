require bash.inc

# GPL-2.0-or-later (< 4.0), GPL-3.0-or-later (>= 4.0)
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "${GNU_MIRROR}/bash/${BP}.tar.gz;name=tarball \
           file://mkbuiltins_have_stringize.patch \
           file://build-tests.patch \
           file://test-output.patch \
           file://run-ptest \
           file://run-bash-ptests \
           file://fix-run-builtins.patch \
           file://use_aclocal.patch \
           "

SRC_URI[tarball.sha256sum] = "68d978264253bc933d692f1de195e2e5b463a3984dfb4e5504b076865f16b6dd"

DEBUG_OPTIMIZATION:append:armv4 = " ${@bb.utils.contains('TUNE_CCARGS', '-mthumb', '-fomit-frame-pointer', '', d)}"
DEBUG_OPTIMIZATION:append:armv5 = " ${@bb.utils.contains('TUNE_CCARGS', '-mthumb', '-fomit-frame-pointer', '', d)}"

BBCLASSEXTEND = "nativesdk"
