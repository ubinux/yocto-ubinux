SUMMARY = "Provides cryptographic recipes and primitives to python developers"
HOMEPAGE = "https://cryptography.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0 | BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8c3617db4fb6fae01f1d253ab91511e4 \
                    file://LICENSE.APACHE;md5=4e168cce331e5c827d4c2b68a6200e1b \
                    file://LICENSE.BSD;md5=5ae30ba4123bc4f2fa49aa0b0dce887b \
                   "
LDSHARED += "-pthread"

SRC_URI[sha256sum] = "6d192741113ef5e30d89dcb5b956ef4e1578f304708701b8b73d38e3e1461f34"

SRC_URI += "file://0001-pyproject.toml-remove-benchmark-disable-option.patch \
            file://0001-Fix-include-directory-when-cross-compiling-9129.patch \
            file://check-memfree.py \
            file://run-ptest \
           "

require ${BPN}-crates.inc

inherit pypi python_setuptools3_rust cargo-update-recipe-crates pkgconfig

DEPENDS += " \
    ${PYTHON_PN}-cffi-native \
"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-cffi \
"

RDEPENDS:${PN}:append:class-target = " \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-threading \
"

RDEPENDS:${PN}-ptest += " \
    ${PYTHON_PN}-bcrypt \
    ${PYTHON_PN}-cryptography-vectors (= ${PV}) \
    ${PYTHON_PN}-hypothesis \
    ${PYTHON_PN}-iso8601 \
    ${PYTHON_PN}-pretend \
    ${PYTHON_PN}-psutil \
    ${PYTHON_PN}-pytest \
    ${PYTHON_PN}-unittest-automake-output \
    ${PYTHON_PN}-pytest-subtests \
    ${PYTHON_PN}-pytz \
"

inherit ptest

do_install_ptest() {
    install -D ${WORKDIR}/check-memfree.py ${D}${PTEST_PATH}/
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
    # remove test_x509.py as it needs benchmark and we don't
    # want to introduce the benchmark dependency
    rm -rf ${D}${PTEST_PATH}/tests/bench/test_x509.py
    install -d ${D}${PTEST_PATH}/tests/hazmat
    cp -rf ${S}/tests/hazmat/* ${D}${PTEST_PATH}/tests/hazmat/
    cp -r ${S}/pyproject.toml ${D}${PTEST_PATH}/
}

FILES:${PN}-ptest += " \
    ${PTEST_PATH}/check-memfree.py \
"
FILES:${PN}-dbg += " \
    ${PYTHON_SITEPACKAGES_DIR}/${SRCNAME}/hazmat/bindings/.debug \
"

BBCLASSEXTEND = "native nativesdk"
