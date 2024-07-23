do_install:append:class-target() {
    sed -i -e 's|${TMPDIR}||g' ${B}/src/plugins/position/geoclue/*
    sed -i -e 's|${TMPDIR}||g' ${B}/src/plugins/position/geoclue2/*
}
