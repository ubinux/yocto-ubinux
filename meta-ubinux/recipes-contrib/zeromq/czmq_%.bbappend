EXTRA_OECMAKE = " \
    -DCMAKECONFIG_INSTALL_DIR:PATH=${@os.path.relpath(d.getVar('libdir'), d.getVar('prefix') + '/') + "/cmake/"} \
"
FILES:lib${BPN}-dev = "${libdir}/*.so ${libdir}/pkgconfig ${includedir} ${libdir}/cmake"
