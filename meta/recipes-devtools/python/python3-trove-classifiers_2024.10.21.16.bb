SUMMARY = "Canonical source for classifiers on PyPI (pypi.org)."
HOMEPAGE = "https://github.com/pypa/trove-classifiers"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "17cbd055d67d5e9d9de63293a8732943fabc21574e4c7b74edf112b4928cf5f3"

PYPI_PACKAGE = "trove_classifiers"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += " python3-calver-native"

BBCLASSEXTEND = "native nativesdk"
