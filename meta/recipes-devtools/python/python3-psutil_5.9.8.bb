SUMMARY = "A cross-platform process and system utilities module for Python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a9c72113a843d0d732a0ac1c200d81b1"
HOMEPAGE = "https://pypi.org/project/psutil/"

SRC_URI[sha256sum] = "6be126e3225486dff286a8fb9a06246a5253f4c7c53b475ea5f5ac934e64194c"

inherit pypi setuptools3

PACKAGES =+ "${PN}-tests"

FILES:${PN}-tests += " \
    ${PYTHON_SITEPACKAGES_DIR}/psutil/test* \
    ${PYTHON_SITEPACKAGES_DIR}/psutil/__pycache__/test* \
"


RDEPENDS:${PN} += " \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-xml \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-ctypes \
    ${PYTHON_PN}-resource \
"

RDEPENDS:${PN}-tests += " \
     ${PN} \
     ${PYTHON_PN} \
     coreutils \
     procps \
     binutils \
     gcc \
     gcc-symlinks \
     libstdc++ \
     libstdc++-dev \
"

INSANE_SKIP:${PN}-tests += "dev-deps"

BBCLASSEXTEND = "native"
