do_install:append () {
    install -d ${D}${libdir}/${BPN}/example
    install -d ${D}${libdir}/${BPN}/example/mock/chef_wrap
    install -d ${D}${libdir}/${BPN}/example/mock/uptime

    install -m 0755 ${B}/example/mock/uptime/test_uptime ${D}/${libdir}/${BPN}/example/mock/uptime
    install -m 0644 ${B}/example/mock/uptime/libproc_uptime.so ${D}/${libdir}/${BPN}/example/mock/libproc_uptime.so
    rm -rf ${D}/${datadir}/${BPN}/example/mock/libproc_uptime.so 
}

