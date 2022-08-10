do_install:append() {
    rm -rf ${D}${localstatedir}/run
    rm -rf ${D}${localstatedir}
}

