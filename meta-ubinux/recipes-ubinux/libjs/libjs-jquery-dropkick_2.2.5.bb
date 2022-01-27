DESCRIPTION = "A JavaScript plugin for creating beautiful, graceful, and painless custom dropdowns."
SECTION = "console/network"
HOMEPAGE = "http://dropkickjs.com"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eee7203bfd605319113865c7d40ef2db"

DEPENDS = "virtual/libc"

SRC_URI = "git://github.com/Robdel12/DropKick.git;branch=master;protocol=https;tag=v${PV}"

PACKAGES = "${PN} ${PN}-doc"
FILES:${PN} = "${datadir}/javascript/jquery-dropkick \
			   ${datadir}/lib/css \
			   ${datadir}/lib/js \
			   ${datadir}/lib \
			   ${datadir}/build/js "
FILES:${PN}-doc += "${datadir}/doc/${PN}"

PR = "r1"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/javascript/jquery-dropkick/
	install -p -m 0644 ${S}/webpack.config.js ${D}${datadir}/javascript/jquery-dropkick/
	install -p -m 0644 ${S}/webpack.css.js ${D}${datadir}/javascript/jquery-dropkick/
	install -p -m 0644 ${S}/karma.conf.js ${D}${datadir}/javascript/jquery-dropkick/

	install -d ${D}${datadir}/javascript/jquery-dropkick/src
	install -p -m 0644 ${S}/src/dropkick.js ${D}${datadir}/javascript/jquery-dropkick/src/
	install -p -m 0644 ${S}/src/utils.js ${D}${datadir}/javascript/jquery-dropkick/src/

	install -d ${D}${datadir}/javascript/jquery-dropkick/dist
	install -p -m 0644 ${S}/dist/dropkick.js ${D}${datadir}/javascript/jquery-dropkick/dist/
	install -p -m 0644 ${S}/dist/dropkick.css ${D}${datadir}/javascript/jquery-dropkick/dist/
	
	install -d ${D}${datadir}/doc/${PN}/
	install -p -m 0644 ${S}/LICENSE ${D}${datadir}/doc/${PN}/


}
