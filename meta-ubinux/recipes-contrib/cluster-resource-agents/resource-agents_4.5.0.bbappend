do_install:append() {
    rm -rf "${D}${localstatedir}"
}

