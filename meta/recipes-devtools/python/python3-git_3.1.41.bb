SUMMARY = "Python library used to interact with Git repositories"
DESCRIPTION = "GitPython provides object model read and write access to \
a git repository. Access repository information conveniently, alter the \
index directly, handle remotes, or go down to low-level object database \
access with big-files support."
HOMEPAGE = "http://github.com/gitpython-developers/GitPython"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5279a7ab369ba336989dcf2a107e5c8e"

PYPI_PACKAGE = "GitPython"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "ed66e624884f76df22c8e16066d567aaa5a37d5b5fa19db2c6df6f7156db9048"

DEPENDS += " ${PYTHON_PN}-gitdb"

RDEPENDS:${PN} += " \
                   ${PYTHON_PN}-datetime \
                   ${PYTHON_PN}-gitdb \
                   ${PYTHON_PN}-io \
                   ${PYTHON_PN}-logging \
                   ${PYTHON_PN}-math \
                   ${PYTHON_PN}-netclient \
                   ${PYTHON_PN}-stringold \
                   ${PYTHON_PN}-unittest \
                   ${PYTHON_PN}-unixadmin \
                   git \
"

BBCLASSEXTEND = "native nativesdk"
