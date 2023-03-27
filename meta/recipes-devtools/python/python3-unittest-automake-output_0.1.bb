SUMMARY = "Modules to make unittest and pytest look like Automake output, for ptest"
HOMEPAGE = "https://gitlab.com/rossburton/python-unittest-automake-output"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f6f16008d9fb7349f06609329f1ab93b"

SRC_URI = "git://gitlab.com/rossburton/python-unittest-automake-output;protocol=https;branch=main"
SRCREV = "06537edb18f3641c70bce25256f6ecf5f5164ead"

S = "${WORKDIR}/git"

inherit python_flit_core

BBCLASSEXTEND = "native nativesdk"
