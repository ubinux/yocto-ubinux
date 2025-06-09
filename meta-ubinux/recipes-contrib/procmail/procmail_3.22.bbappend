FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-Fix-build-error-with-gcc15.patch "

do_compile() {
    oe_runmake -i CFLAGS="$TARGET_CFLAGS -Wno-comments -Wno-implicit-int -Wno-implicit-function-declaration -Wno-incompatible-pointer-types -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -DNOuname" LDFLAGS0="${LDFLAGS}"
}

