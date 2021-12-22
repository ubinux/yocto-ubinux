DESCRIPTION = "Highly customizable checkboxes and radio buttons (jQuery & Zepto)"
SECTION = "console/network"
HOMEPAGE = "http://fronteed.com/iCheck"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://icheck.js;md5=404078d7de9f05ed64d364274f790055"

DEPENDS = "virtual/libc"

SRC_URI = "git://github.com/fronteed/icheck.git;protocol=https;branch=1.0.3;tag=${PV}"

PACKAGES = "${PN}"
FILES:${PN} = "${datadir}/javascript/jquery-icheck"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/javascript/jquery-icheck/
	install -p -m 0644 ${S}/icheck.js ${D}${datadir}/javascript/jquery-icheck/
	install -p -m 0644 ${S}/icheck.min.js ${D}${datadir}/javascript/jquery-icheck/

	install -d ${D}${datadir}/javascript/jquery-icheck/skins/
	install -p -m 0644 ${S}/skins/all.css ${D}${datadir}/javascript/jquery-icheck/skins/

	install -d ${D}${datadir}/javascript/jquery-icheck/skins/flat/
	install -p -m 0644 ${S}/skins/flat/* ${D}${datadir}/javascript/jquery-icheck/skins/flat/

	install -d ${D}${datadir}/javascript/jquery-icheck/skins/futurico/
	install -p -m 0644 ${S}/skins/futurico/* ${D}${datadir}/javascript/jquery-icheck/skins/futurico/

	install -d ${D}${datadir}/javascript/jquery-icheck/skins/line/
	install -p -m 0644 ${S}/skins/line/* ${D}${datadir}/javascript/jquery-icheck/skins/line/

	install -d ${D}${datadir}/javascript/jquery-icheck/skins/minimal/
	install -p -m 0644 ${S}/skins/minimal/* ${D}${datadir}/javascript/jquery-icheck/skins/minimal/

	install -d ${D}${datadir}/javascript/jquery-icheck/skins/polaris/
	install -p -m 0644 ${S}/skins/polaris/* ${D}${datadir}/javascript/jquery-icheck/skins/polaris/

	install -d ${D}${datadir}/javascript/jquery-icheck/skins/square/
	install -p -m 0644 ${S}/skins/square/* ${D}${datadir}/javascript/jquery-icheck/skins/square/
}
