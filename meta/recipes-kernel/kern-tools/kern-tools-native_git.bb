SUMMARY = "Tools for managing Yocto Project style branched kernels"
DESCRIPTION = "Powerful set of tools or managing Yocto Linux kernel sources \
and configuration data. You can use these tools to make a single configuration \
change, apply multiple patches, or work with your own kernel sources."
HOMEPAGE = "https://www.yoctoproject.org/"
LICENSE = "GPL-2.0-only & MIT"
LIC_FILES_CHKSUM = "\
	file://tools/kgit;beginline=5;endline=9;md5=9c30e971d435e249624278c3e343e501 \
	file://Kconfiglib/LICENSE.txt;md5=712177a72a3937909543eda3ad1bfb7c \
"

DEPENDS = "git-native"

SRCREV = "2d01f24bc78256c709728eb3f204491bce13e0e5"
PV = "0.3+git${SRCPV}"

inherit native

SRC_URI = "git://git.yoctoproject.org/yocto-kernel-tools.git;branch=master"
S = "${WORKDIR}/git"

do_configure() {
	:
}

do_compile() { 
	:
}

do_install() {
	oe_runmake DESTDIR=${D}${bindir} install
}
