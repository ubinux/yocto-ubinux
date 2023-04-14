SUMMARY = "Password strength checker library"
HOMEPAGE = "https://github.com/cracklib/cracklib"
DESCRIPTION = "${SUMMARY}"

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=e3eda01d9815f8d24aae2dbd89b68b06"

DEPENDS = "cracklib-native zlib"

EXTRA_OECONF = "--without-python --libdir=${base_libdir}"

SRC_URI = "git://github.com/cracklib/cracklib;protocol=https;branch=main \
           file://0001-packlib.c-support-dictionary-byte-order-dependent.patch \
           "

SRCREV = "4cf5125250c6325ef0a2dc085eabff875227edc3"
S = "${WORKDIR}/git/src"

inherit autotools gettext

# This is custom stuff from upstream's autogen.sh
do_configure:prepend() {
    mkdir -p ${S}/m4
    echo EXTRA_DIST = *.m4 > ${S}/m4/Makefile.am
    touch ${S}/ABOUT-NLS
}

do_install:append:class-target() {
	create-cracklib-dict -o ${D}${datadir}/cracklib/pw_dict ${D}${datadir}/cracklib/cracklib-small
}

BBCLASSEXTEND = "native nativesdk"

