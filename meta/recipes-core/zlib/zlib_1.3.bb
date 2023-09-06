SUMMARY = "Zlib Compression Library"
DESCRIPTION = "Zlib is a general-purpose, patent-free, lossless data compression \
library which is used by many different programs."
HOMEPAGE = "http://zlib.net/"
SECTION = "libs"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://zlib.h;beginline=6;endline=23;md5=5377232268e952e9ef63bc555f7aa6c0"

# The source tarball needs to be .gz as only the .gz ends up in fossils/
SRC_URI = "https://zlib.net/${BP}.tar.gz \
           file://0001-configure-Pass-LDFLAGS-to-link-tests.patch \
           file://run-ptest \
           "
UPSTREAM_CHECK_URI = "http://zlib.net/"

SRC_URI[sha256sum] = "ff0ba4c292013dbc27530b3a81e1f9a813cd39de01ca5e0f8bf355702efa593e"

# When a new release is made the previous release is moved to fossils/, so add this
# to PREMIRRORS so it is also searched automatically.
PREMIRRORS:append = " https://zlib.net/ https://zlib.net/fossils/"

CFLAGS += "-D_REENTRANT"

RDEPENDS:${PN}-ptest += "make"

inherit ptest

B = "${WORKDIR}/build"

do_configure() {
	LDCONFIG=true ${S}/configure --prefix=${prefix} --shared --libdir=${libdir} --uname=GNU
}
do_configure[cleandirs] += "${B}"

do_compile() {
	oe_runmake shared
}

do_install() {
	oe_runmake DESTDIR=${D} install
}

do_install_ptest() {
	install ${B}/examplesh ${D}${PTEST_PATH}
}

BBCLASSEXTEND = "native nativesdk"
