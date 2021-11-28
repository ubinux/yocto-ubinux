
SUMMARY = "ANSII Color formatting for output in terminal."
HOMEPAGE = "http://pypi.python.org/pypi/termcolor"
AUTHOR = "Konstantin Lepa <konstantin.lepa@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=809e8749b63567978acfbd81d9f6a27d"

SRC_URI = "https://files.pythonhosted.org/packages/8a/48/a76be51647d0eb9f10e2a4511bf3ffb8cc1e6b14e9e4fab46173aa79f981/termcolor-1.1.0.tar.gz"
SRC_URI[md5sum] = "043e89644f8909d462fbbfa511c768df"
SRC_URI[sha256sum] = "1d6d69ce66211143803fbc56652b41d73b4a400a2891d7bf7a1cdf4c02de613b"

S = "${WORKDIR}/termcolor-1.1.0"

RDEPENDS_${PN} = ""

inherit setuptools3
