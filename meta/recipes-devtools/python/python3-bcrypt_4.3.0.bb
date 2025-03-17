SUMMARY = "Modern password hashing for your software and your servers."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8f7bb094c7232b058c7e9f2e431f389c"
HOMEPAGE = "https://pypi.org/project/bcrypt/"

DEPENDS += "python3-cffi-native"
LDFLAGS += "${@bb.utils.contains('DISTRO_FEATURES', 'ptest', '-fuse-ld=bfd', '', d)}"

SRC_URI[sha256sum] = "3a3fd2204178b6d2adcf09cb4f6426ffef54762577a7c9b54c159008cb288c18"

inherit pypi python_setuptools3_rust cargo-update-recipe-crates ptest-python-pytest

CARGO_SRC_DIR = "src/_bcrypt"

require ${BPN}-crates.inc

RDEPENDS:${PN}:class-target += "\
    python3-cffi \
    python3-ctypes \
    python3-shell \
"
