DESCRIPTION = "Highly customizable custom scrollbar jQuery plugin, featuring vertical/horizontal scrollbars, scrolling momentum, mouse-wheel, keyboard and touch support etc."
SECTION = "console/network"
HOMEPAGE = "http://manos.malihu.gr/jquery-custom-content-scroller/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=fa75702818bab79eacec2c30227fe114"

DEPENDS = "virtual/libc"

SRC_URI = "git://github.com/malihu/malihu-custom-scrollbar-plugin.git;branch=master;protocol=https;tag=${PV}"

S = "${WORKDIR}/git"

PACKAGES = "${PN} ${PN}-doc"
FILES:${PN} += "${datadir}/javascript/jquery-custom-scrollbar"
FILES:${PN}-doc += "${datadir}/doc/${PN}"

do_install() {
	install -d ${D}${datadir}/javascript/jquery-custom-scrollbar
	install -p -m 0644 ${S}/js/uncompressed/jquery.mCustomScrollbar.js ${D}${datadir}/javascript/jquery-custom-scrollbar/
	install -p -m 0644 ${S}/js/minified/jquery.mCustomScrollbar.min.js ${D}${datadir}/javascript/jquery-custom-scrollbar/

	install -d ${D}${datadir}/doc/${PN}
	install -p -m 0644 ${S}/LICENSE.txt ${D}${datadir}/doc/${PN}
}
