PACKAGECONFIG = "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', ' systemd', '', d)}"

PACKAGECONFIG[openhpi] = "--with-hpi-interface=B03,,openhpi"
PACKAGECONFIG[plm] = "--enable-ais-plm,--disable-ais-plm,libvirt openhpi"

