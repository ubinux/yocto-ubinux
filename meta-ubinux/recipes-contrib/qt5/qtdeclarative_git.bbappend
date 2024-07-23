INSANE_SKIP:${PN}-ptest += "buildpaths"
do_install:append:class-target() {
     sed -i -e 's|${TMPDIR}||g' ${B}/include/QtQml/5.15.13/QtQml/private/qqmljsparser_p.h
     sed -i -e 's|${TMPDIR}||g' ${D}/usr/include/qt5/QtQml/5.15.13/QtQml/private/qqmljsparser_p.h
}


