SUMMARY = "Xcursor: X Cursor management library"

DESCRIPTION = "Xcursor is a simple library designed to help locate and \
load cursors. Cursors can be loaded from files or memory. A library of \
common cursors exists which map to the standard X cursor names. Cursors \
can exist in several sizes and the library automatically picks the best \
size."

require xorg-lib-common.inc
SRC_URI = "${XORG_MIRROR}/individual/lib/${XORG_PN}-${PV}.tar.xz"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=dbf3bd0f2348eeccd0f217146ba26250"

DEPENDS += "libxrender libxfixes"

PE = "1"

XORG_PN = "libXcursor"

SRC_URI[sha256sum] = "46c143731610bafd2070159a844571b287ac26192537d047a39df06155492104"

BBCLASSEXTEND = "native nativesdk"
