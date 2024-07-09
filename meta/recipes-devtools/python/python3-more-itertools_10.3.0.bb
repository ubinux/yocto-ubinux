SUMMARY = "More routines for operating on iterables, beyond itertools"
HOMEPAGE = "https://github.com/erikrose/more-itertools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3396ea30f9d21389d7857719816f83b5"

SRC_URI[sha256sum] = "e5d93ef411224fbcef366a6e8ddc4c5781bc6359d43412a65dd5964e46111463"

inherit pypi python_flit_core ptest

SRC_URI += " \
	file://run-ptest \
"

RDEPENDS:${PN} += " \
        python3-asyncio \
        "

RDEPENDS:${PN}-ptest += " \
	python3-statistics \
	python3-pytest \
	python3-unittest-automake-output \
        "

do_install_ptest() {
	install -d ${D}${PTEST_PATH}/tests
	cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}

BBCLASSEXTEND = "native nativesdk"
