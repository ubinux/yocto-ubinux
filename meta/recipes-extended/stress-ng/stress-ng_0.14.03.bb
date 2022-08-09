SUMMARY = "System load testing utility"
DESCRIPTION = "Deliberately simple workload generator for POSIX systems. It \
imposes a configurable amount of CPU, memory, I/O, and disk stress on the system."
HOMEPAGE = "https://github.com/ColinIanKing/stress-ng#readme"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/ColinIanKing/stress-ng.git;protocol=https;branch=master \
           file://0001-core-helper-remove-include-of-sys-mount.h.patch \
           file://0002-core-shim-remove-include-of-sys-mount.h.patch \
"
SRCREV = "346518caffe5302f9a6d36860459c297c6968aaa"
S = "${WORKDIR}/git"

DEPENDS = "coreutils-native"

PROVIDES = "stress"
RPROVIDES:${PN} = "stress"
RREPLACES:${PN} = "stress"
RCONFLICTS:${PN} = "stress"

inherit bash-completion

do_compile:prepend() {
    mkdir -p configs
    touch configs/HAVE_APPARMOR
}

do_install() {
    oe_runmake DESTDIR=${D} install
    ln -s stress-ng ${D}${bindir}/stress
}
