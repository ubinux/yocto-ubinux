do_install () {
        oe_runmake DESTDIR="${D}" install_user
        install ${S}/etc/initd/initd.debian ${D}/etc/init.d/open-iscsi
        install -m 0644 ${S}/etc/iscsid.conf ${D}/etc/iscsi/

        install -d ${D}${libdir}
        install -Dm 0644 ${S}/libopeniscsiusr/libopeniscsiusr.so.0.2.0 ${D}${libdir}/
        ln -sf ${libdir}/libopeniscsiusr.so.0.2.0 ${D}${libdir}/libopeniscsiusr.so
}

