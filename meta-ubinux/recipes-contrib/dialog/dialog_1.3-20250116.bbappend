do_install:append () {
        ln -sf ${bindir}/${HOST_SYS}-dialog ${D}${bindir}/${PN}
}
