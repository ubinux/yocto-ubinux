SUMMARY = "Templating library for Python"
HOMEPAGE = "http://www.makotemplates.org/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d0995d6f7ba3f186a03118f244e88f57"

PYPI_PACKAGE = "Mako"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "2a0c8ad7f6274271b3bb7467dd37cf9cc6dab4bc19cb69a4ef10669402de698e"

RDEPENDS:${PN} = "${PYTHON_PN}-html \
                  ${PYTHON_PN}-markupsafe \
                  ${PYTHON_PN}-netclient \
                  ${PYTHON_PN}-pygments \
                  ${PYTHON_PN}-threading \
"

BBCLASSEXTEND = "native nativesdk"
