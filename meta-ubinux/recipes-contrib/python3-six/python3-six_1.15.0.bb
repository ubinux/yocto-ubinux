
SUMMARY = "Python 2 and 3 compatibility utilities"
HOMEPAGE = "https://github.com/benjaminp/six"
AUTHOR = "Benjamin Peterson <benjamin@python.org>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=43cfc9e4ac0e377acfb9b76f56b8415d"

SRC_URI = "https://files.pythonhosted.org/packages/6b/34/415834bfdafca3c5f451532e8a8d9ba89a21c9743a0c59fbd0205c7f9426/six-1.15.0.tar.gz"
SRC_URI[md5sum] = "9f90a0eaa0ea7747fda01ca79d21ebcb"
SRC_URI[sha256sum] = "30639c035cdb23534cd4aa2dd52c3bf48f06e5f4a941509c8bafd8ce11080259"

S = "${WORKDIR}/six-1.15.0"

RDEPENDS_${PN} = ""

inherit setuptools3
