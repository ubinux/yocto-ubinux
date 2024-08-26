SUMMARY = "A library for applications dealing with netlink sockets"
DESCRIPTION = "The libnl suite is a collection of libraries providing \
APIs to netlink protocol based Linux kernel interfaces. libnl is the core \
library implementing the fundamentals required to use the netlink protocol \
such as socket handling, message construction and parsing, and sending \
and receiving of data."
HOMEPAGE = "https://github.com/thom311/libnl"
SECTION = "libs/network"

PE = "1"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "flex-native bison-native"

SRC_URI = "${GITHUB_BASE_URI}/download/${BPN}${@d.getVar('PV').replace('.','_')}/${BP}.tar.gz \
           file://run-ptest \
           file://0001-tests-cksuite-all-netns.c-disable-route_1.patch \
           "

SRC_URI[sha256sum] = "49b3e2235fdb58f5910bbb3ed0de8143b71ffc220571540502eb6c2471f204f5"

GITHUB_BASE_URI = "https://github.com/thom311/${BPN}/releases"
UPSTREAM_CHECK_REGEX = "releases/tag/libnl(?P<pver>.+)"

inherit autotools pkgconfig ptest github-releases

FILES:${PN} = "${libdir}/libnl-3.so.* \
               ${libdir}/libnl.so.* \
               ${sysconfdir}"
RREPLACES:${PN} = "libnl2"
RCONFLICTS:${PN} = "libnl2"

FILES:${PN}-dev += "${libdir}/libnl/cli/*/*.la"
FILES:${PN}-staticdev += "${libdir}/libnl/cli/*/*.a"

PACKAGES += "${PN}-cli ${PN}-genl ${PN}-idiag ${PN}-nf ${PN}-route ${PN}-xfrm"
FILES:${PN}-cli   = "${libdir}/libnl-cli-3.so.* \
                     ${libdir}/libnl/cli/*/*.so \
                     ${bindir}/genl-ctrl-list \
                     ${bindir}/idiag-socket-details \
                     ${bindir}/nf-* \
                     ${bindir}/nl-*"
FILES:${PN}-genl  = "${libdir}/libnl-genl-3.so.* \
                     ${libdir}/libnl-genl.so.*"
FILES:${PN}-idiag = "${libdir}/libnl-idiag-3.so.*"
FILES:${PN}-nf    = "${libdir}/libnl-nf-3.so.*"
FILES:${PN}-route = "${libdir}/libnl-route-3.so.*"
FILES:${PN}-xfrm  = "${libdir}/libnl-xfrm-3.so.*"
RREPLACES:${PN}-genl = "libnl-genl2"
RCONFLICTS:${PN}-genl = "libnl-genl2"

DEPENDS += "${@bb.utils.contains('PTEST_ENABLED', '1', 'libcheck', '', d)}"
RRECOMMENDS:${PN}-ptest += "kernel-module-dummy kernel-module-bonding"
RDEPENDS:${PN}-ptest += "iproute2-ip"

do_compile_ptest() {
    oe_runmake ./tests/check-all
}

do_install_ptest() {
    ./libtool install install ./tests/check-all ${D}${PTEST_PATH}/
}

BBCLASSEXTEND = "native nativesdk"
