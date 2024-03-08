SUMMARY = "Library for building powerful interactive command lines in Python"
DESCRIPTION = "Measures the displayed width of unicode strings in a terminal"
HOMEPAGE = "https://github.com/jquast/wcwidth"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b15979c39a2543892fca8cd86b4b52cb"

SRC_URI[sha256sum] = "72ea0c06399eb286d978fdedb6923a9eb47e1c486ce63e9b4e64fc18303972b5"

inherit pypi setuptools3 ptest

SRC_URI += " \
        file://run-ptest \
"

RDEPENDS:${PN}-ptest += " \
       python3-pytest \
       python3-unittest-automake-output \
"

do_install_ptest() {
      install -d ${D}${PTEST_PATH}/tests 
      cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
      install -d ${D}${PTEST_PATH}/bin
      cp -rf ${S}/bin/* ${D}${PTEST_PATH}/bin/
}

BBCLASSEXTEND = "native nativesdk"
