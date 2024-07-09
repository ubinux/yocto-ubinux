do_compile() {
    oe_runmake -i CFLAGS="$TARGET_CFLAGS -Wno-comments -Wno-implicit-int -Wno-implicit-function-declaration -Wno-implicit-function-declaration -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64" LDFLAGS0="${LDFLAGS}"
}
