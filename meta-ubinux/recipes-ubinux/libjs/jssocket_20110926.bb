DESCRIPTION = "Socket and SSL Socket Class w/ WebSocket"
SECTION = "console/network"
HOMEPAGE = "http://code.google.com/p/jsdoc-toolkit/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://doc/index.html;md5=167444a13884f84f58f0f17349e2e7ab"

DEPENDS = "virtual/libc"

SRC_URI = "git://github.com/nori0428/jssocket.git;protocol=https"
SRCREV = "0a73c417f3841a20fa75dc6d51bf879e72bf01e1"

PACKAGES = "${PN} ${PN}-doc"
FILES:${PN} = "${datadir}/javascript/jssocket"
FILES:${PN}-doc += "${datadir}/doc/${PN}"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/javascript/jssocket/
	install -p -m 0644 ${S}/src/jsSocket.js ${D}${datadir}/javascript/jssocket/

	install -d ${D}${datadir}/doc/${PN}/
	install -p -m 0644 ${S}/README ${D}${datadir}/doc/${PN}/
	install -p -m 0644 ${S}/doc/index.html ${D}${datadir}/doc/${PN}/
}
