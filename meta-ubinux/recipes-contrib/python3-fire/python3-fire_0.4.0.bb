
SUMMARY = "A library for automatically generating command line interfaces."
HOMEPAGE = "https://github.com/google/python-fire"
AUTHOR = "David Bieber <dbieber@google.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ab892b2b62f951d424bdb712a72584cc"

SRC_URI = "https://files.pythonhosted.org/packages/11/07/a119a1aa04d37bc819940d95ed7e135a7dcca1c098123a3764a6dcace9e7/fire-0.4.0.tar.gz"
SRC_URI[md5sum] = "799be84cbbd7df2cf159cdcb538ab6f9"
SRC_URI[sha256sum] = "c5e2b8763699d1142393a46d0e3e790c5eb2f0706082df8f647878842c216a62"

S = "${WORKDIR}/fire-0.4.0"

RDEPENDS_${PN} = ""

inherit setuptools3
