DESCRIPTION = "croniter provides iteration for datetime object with cron like format"
HOMEPAGE = "https://pypi.python.org/pypi/croniter/0.3.4"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://docs/LICENSE;md5=b8ee59850b882cbf623188489ea748e2"

# Archived version so we have to overwrite what the pypi class will derive
PYPI_SRC_URI = "https://pypi.python.org/packages/source/c/croniter/croniter-${PV}.tar.gz"

SRC_URI[md5sum] = "e4a8987521b144c4c2149d4adde8f55c"
SRC_URI[sha256sum] = "538adeb3a7f7816c3cdec6db974c441620d764c25ff4ed0146ee7296b8a50590"

inherit setuptools pypi

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        python-dateutil \
        "
