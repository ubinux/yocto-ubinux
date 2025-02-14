SUMMARY = "Utility library to parse, compare, simplify and normalize license expressions"
HOMEPAGE = "https://github.com/nexB/license-expression"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://apache-2.0.LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "6464397f8ed4353cc778999caec43b099f8d8d5b335f282e26a9eb9435522f05"

inherit pypi ptest-python-pytest python_setuptools_build_meta
PYPI_PACKAGE = "license_expression"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-booleanpy \
    python3-core \
    python3-json \
    python3-stringold \
    python3-logging \
"

BBCLASSEXTEND = "native nativesdk"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/src
    cp -rf ${S}/src/* ${D}${PTEST_PATH}/src/
    cp -rf ${S}/setup.cfg ${D}${PTEST_PATH}/
}
