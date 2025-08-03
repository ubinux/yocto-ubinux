SUMMARY = "Setuptools extension for CalVer package versions"
HOMEPAGE = "https://github.com/di/calver"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://github.com/di/calver;branch=master;protocol=https;tag=${PV}"
SRCREV = "3b74bdce35f2814eb2b65db39a133d5c849ddea7"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN}-ptest += " \
    python3-pretend \
"

BBCLASSEXTEND = "native nativesdk"
