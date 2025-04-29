do_compile() {
    oe_runmake -i CFLAGS="$TARGET_CFLAGS -Wno-comments -Wno-implicit-function-declaration -Wno-error=implicit-int -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64" LDFLAGS0="${LDFLAGS}"
}

