DESCRIPTION = "A messaging framework for Python"
HOMEPAGE = "http://kombu.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=daea7c168428449fbee05e644df929f4"

SRC_URI[md5sum] = "6a9f0d07ec3f8b784e9358d04a4709c3"
SRC_URI[sha256sum] = "389ba09e03b15b55b1a7371a441c894fd8121d174f5583bbbca032b9ea8c9edd"

inherit setuptools pypi

FILES_${PN}-doc += "${datadir}/${SRCNAME}"

RDEPENDS_${PN} = " \
        python-amqp \
        "
