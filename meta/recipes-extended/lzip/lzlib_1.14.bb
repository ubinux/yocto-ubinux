SUMMARY = "Data compression library providing in-memory LZMA compression and decompression functions"
HOMEPAGE = "https://www.nongnu.org/lzip/lzlib.html"
DESCRIPTION = "Lzlib is a data compression library providing in-memory LZMA compression and decompression functions, including integrity checking of the decompressed data. The compressed data format used by the library is the lzip format. Lzlib is written in C. "
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=04d943636aa1482e0a97d924d9f4f68f \
                    "

SRC_URI = "${SAVANNAH_GNU_MIRROR}/lzip/lzlib/lzlib-${PV}.tar.gz"
SRC_URI[sha256sum] = "5acac8714ed4f306020bae660dddce706e5f8a795863679037da9fe6bf4dcf6f"

B = "${WORKDIR}/build"
do_configure[cleandirs] = "${B}"

CONFIGUREOPTS = "\
    '--srcdir=${S}' \
    '--prefix=${prefix}' \
    '--exec-prefix=${exec_prefix}' \
    '--bindir=${bindir}' \
    '--datadir=${datadir}' \
    '--infodir=${infodir}' \
    '--libdir=${libdir}' \
    '--sysconfdir=${sysconfdir}' \
    '--enable-shared' \
    '--disable-static' \
    'CC=${CC}' \
    'CPPFLAGS=${CPPFLAGS}' \
    'CXXFLAGS=${CXXFLAGS}' \
    'LDFLAGS=${LDFLAGS}' \
"

do_configure () {
    ${S}/configure ${CONFIGUREOPTS}
}

do_install () {
    oe_runmake 'DESTDIR=${D}' install
}

BBCLASSEXTEND = "native nativesdk"
