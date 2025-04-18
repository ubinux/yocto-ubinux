SUMMARY = "XRender: X Rendering Extension library"

DESCRIPTION = "The X Rendering Extension (Render) introduces digital \
image composition as the foundation of a new rendering model within the \
X Window System. Rendering geometric figures is accomplished by \
client-side tessellation into either triangles or trapezoids.  Text is \
drawn by loading glyphs into the server and rendering sets of them."

require xorg-lib-common.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=d8bc71986d3b9b3639f6dfd6fac8f196"

DEPENDS += "virtual/libx11 xorgproto"

PE = "1"

XORG_PN = "libXrender"

BBCLASSEXTEND = "native nativesdk"
SRC_URI[sha256sum] = "b832128da48b39c8d608224481743403ad1691bf4e554e4be9c174df171d1b97"

