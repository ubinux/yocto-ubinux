do_install_append() {
        mkdir -p ${D}/${includedir}/${PV}
        mv ${D}/${includedir}/sha1.h ${D}/${includedir}/${PV}/.
} 
