SUMMARY = "Perl-cross build system"
HOMEPAGE = "https://github.com/arsv/perl-cross"
DESCRIPTION = "perl-cross provides configure script, top-level Makefile and some auxiliary files for perl, \
with the primary emphasis on cross-compiling the source."
SECTION = "devel"
LICENSE = "Artistic-1.0 | GPL-1.0-or-later"
# README.md is taken from https://github.com/arsv/perl-cross/blob/master/README.md
# but is not provided inside the release tarballs
LIC_FILES_CHKSUM = "file://${WORKDIR}/README.md;md5=252fcce2026b765fee1ad74d2fb07a3b"

inherit allarch

SRC_URI = "https://github.com/arsv/perl-cross/releases/download/${PV}/perl-cross-${PV}.tar.gz;name=perl-cross \
           file://README.md \
           file://0001-perl-cross-add-LDFLAGS-when-linking-libperl.patch \
           file://determinism.patch \
           file://0001-Makefile-check-the-file-if-patched-or-not.patch \
           "
UPSTREAM_CHECK_URI = "https://github.com/arsv/perl-cross/releases/"

SRC_URI[perl-cross.sha256sum] = "77f13ca84a63025053852331b72d4046c1f90ded98bd45ccedea738621907335"

S = "${WORKDIR}/perl-cross-${PV}"

do_configure () {
}

do_compile () {
}

do_install:class-native() {
    mkdir -p ${D}/${datadir}/perl-cross/
    cp -rf ${S}/* ${D}/${datadir}/perl-cross/
    rm -rf ${D}/${datadir}/perl-cross/patches/
}

BBCLASSEXTEND = "native"

