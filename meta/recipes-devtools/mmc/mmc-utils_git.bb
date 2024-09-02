SUMMARY = "Userspace tools for MMC/SD devices"
HOMEPAGE = "https://git.kernel.org/pub/scm/utils/mmc/mmc-utils.git/"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://mmc.c;beginline=1;endline=20;md5=fae32792e20f4d27ade1c5a762d16b7d"

SRCBRANCH ?= "master"
SRCREV = "123fd8b2ac3933be1319486fb1f32236a4a86a7c"

PV = "0.1+git"

SRC_URI = "git://git.kernel.org/pub/scm/utils/mmc/mmc-utils.git;branch=${SRCBRANCH};protocol=https"
UPSTREAM_CHECK_COMMITS = "1"

DEPENDS = "python3-sphinx-native"
EXTRA_OEMAKE = "C="

S = "${WORKDIR}/git"

CFLAGS:append:powerpc64 = " -D__SANE_USERSPACE_TYPES__"
CFLAGS:append:mipsarchn64 = " -D__SANE_USERSPACE_TYPES__"
CFLAGS:append:mipsarchn32 = " -D__SANE_USERSPACE_TYPES__"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 mmc ${D}${bindir}
}
