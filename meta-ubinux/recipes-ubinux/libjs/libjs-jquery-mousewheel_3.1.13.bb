SUMMARY = "jQuery Mousewheel Plugin"
DESCRIPTION = "A jQuery plugin that adds cross-browser mouse wheel support."
SECTION = "console/network"
HOMEPAGE = "https://jquery.com/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e4f7c2d5fc49e79dce89c5e67a304591"

DEPENDS = "virtual/libc"

SRC_URI = "git://github.com/jquery/jquery-mousewheel.git;branch=main;protocol=https"

SRCREV = "67289b6b2aa0066d7d78a5807f520387135ffb22"

PACKAGES = "${PN} ${PN}-doc"
FILES:${PN} = "${datadir}/javascript/jquery-mousewheel"
FILES:${PN}-doc += "${datadir}/doc/${PN}"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/javascript/jquery-mousewheel
	install -p -m 0644 ${S}/jquery.mousewheel.js ${D}${datadir}/javascript/jquery-mousewheel/
	install -p -m 0644 ${S}/jquery.mousewheel.min.js ${D}${datadir}/javascript/jquery-mousewheel/

	install -d ${D}${datadir}/doc/${PN}
	install -p -m 0644 ${S}/LICENSE.txt ${D}${datadir}/doc/${PN}

	install -d ${D}${datadir}/doc/${PN}/test
	install -p -m 0644 ${S}/test/index.html ${D}${datadir}/doc/${PN}/test
}
