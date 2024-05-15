SUMMARY = "Plugin and hook calling mechanisms for python"
HOMEPAGE = "https://github.com/pytest-dev/pluggy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1c8206d16fd5cc02fa9b0bb98955e5c2"

SRC_URI[sha256sum] = "2cffa88e94fdc978c4c574f15f9e59b7f4201d439195c3715ca9e2486f1d0cf1"

DEPENDS += "python3-setuptools-scm-native"
RDEPENDS:${PN} += "python3-importlib-metadata \
                   python3-more-itertools \
"

inherit pypi ptest python_setuptools_build_meta

SRC_URI += " \
	file://run-ptest \
"

RDEPENDS:${PN}-ptest += " \
	python3-pytest \
	python3-unittest-automake-output \
"

do_install_ptest() {
	install -d ${D}${PTEST_PATH}/testing
	cp -rf ${S}/testing/* ${D}${PTEST_PATH}/testing/
}

BBCLASSEXTEND = "native nativesdk"
