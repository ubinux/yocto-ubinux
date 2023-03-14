do_install:append () {
    rm -rf  ${D}${sysconfdir}/initrd-release
}

PACKAGES:remove = "${PN}-initrd"

