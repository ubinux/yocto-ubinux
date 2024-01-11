SUMMARY = "Classes Without Boilerplate"
HOMEPAGE = "http://www.attrs.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5e55731824cf9205cfabeab9a0600887"

SRC_URI[sha256sum] = "935dc3b529c262f6cf76e50877d35a4bd3c1de194fd41f47a2b7ae8f19971f30"

inherit pypi ptest python_hatchling

SRC_URI += " \
	file://run-ptest \
"

DEPENDS += " \
    python3-hatch-vcs-native \
    python3-hatch-fancy-pypi-readme-native \
"

RDEPENDS:${PN}+= " \
    python3-compression \
    python3-ctypes \
    python3-crypt \
"

RDEPENDS:${PN}-ptest += " \
    ${PYTHON_PN}-hypothesis \
    ${PYTHON_PN}-pytest \
    ${PYTHON_PN}-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
    install ${S}/conftest.py ${D}${PTEST_PATH}/
}

BBCLASSEXTEND = "native nativesdk"
