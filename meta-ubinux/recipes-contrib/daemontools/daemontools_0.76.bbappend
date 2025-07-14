do_compile:prepend() {
     export CC="${CC} -Wno-error=incompatible-pointer-types ${CFLAGS}"
}

