DESCRIPTION = "the compiling PHP template engine"
SECTION = "console/network"
HOMEPAGE = "https://www.smarty.net/"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c0f216b2120ffc367e20f2b56df51b3"

DEPENDS += "php"

SRC_URI = "git://github.com/smarty-php/smarty.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

SRCREV = "642a97adcc2bf6c1b2458d6afeeb36ae001c1c2f"

do_compile() {
	:
}

do_install() {
        install -d ${D}${datadir}/php/smarty3/libs/
        install -m 0644 ${S}/libs/*.php ${D}${datadir}/php/smarty3/libs/

        install -d ${D}${datadir}/php/smarty3/src/
        cp -rf ${S}/src/* ${D}${datadir}/php/smarty3/src/
}
FILES:${PN} = "${datadir}/php/smarty3/"

CVE_STATUS[CVE-2020-10375] = "cpe-incorrect: The recipe used in the meta-openembedded is a different smarty package compared to the one which has the CVE issue."
