DESCRIPTION = "A JavaScript library for internationalization and localization that leverages the official Unicode CLDR JSON data"
SECTION = "console/network"
HOMEPAGE = "http://blog.jquery.com/2015/04/23/announcing-globalize-1-0/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=abb89551be451019e3dcc4c3178fa4f0"


SRC_URI = "https://github.com/globalizejs/globalize/archive/1.4.0.tar.gz"

SRC_URI[md5sum] = "673e8d500f4141223b517f2129827724"
SRC_URI[sha256sum] = "824d39e77eb7b624788708c04ff6ca72380d21323ba203c53dd14b3a67a9f007"

S = "${WORKDIR}/globalize-1.4.0"
PACKAGES = "${PN} ${PN}-doc"
FILES:${PN} = "${datadir}/javascript/jquery-globalize"
FILES:${PN}-doc += "${datadir}/doc/${PN}"

do_install() {
	install -d ${D}${datadir}/javascript/jquery-globalize/
	install -p -m 0644 ${S}/dist/*.js ${D}${datadir}/javascript/jquery-globalize/
	install -p -m 0644 ${S}/dist/globalize/*.js ${D}${datadir}/javascript/jquery-globalize/

	install -d ${D}${datadir}/doc/${PN}/
	install -p -m 0644 ${S}/LICENSE ${D}${datadir}/doc/${PN}/
}
