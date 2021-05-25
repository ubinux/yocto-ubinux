do_install_append() {
	mkdir -p ${D}${libdir}/traceevent/plugins/${BPN}
        mv ${D}/${libdir}/traceevent/plugins/*.so ${D}${libdir}/traceevent/plugins/${BPN}/
}

