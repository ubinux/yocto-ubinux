do_install() {
       oe_runmake libdir_relative=${baselib} etcdir=${sysconfdir} pkgconfig_dir=${libdir}/pkgconfig DESTDIR=${D} install install_libs
       # Because makefile uses cp instead of install we need to change owner of files
       chown -R root:root ${D}${libdir}
}
