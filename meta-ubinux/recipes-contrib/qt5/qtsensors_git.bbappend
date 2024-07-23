do_install:append:class-target() {
    sed -i -e 's|${TMPDIR}||g' ${B}/src/plugins/sensors/iio-sensor-proxy/*
}

