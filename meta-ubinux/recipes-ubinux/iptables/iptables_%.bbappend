FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://iptables.service \
    file://ip6tables.service \
    file://iptables.init \
    file://iptables.default \
    file://iptables.data \
    file://ip6tables.init \
    file://ip6tables.default \
    file://ip6tables.data \
"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "iptables.service ip6tables.service"
SYSTEMD_AUTO_ENABLE = "disable"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
         install -d ${D}${systemd_unitdir}/system
         install -d ${D}${libexecdir}

         install -m 0644 ${WORKDIR}/ip6tables.service ${D}${systemd_unitdir}/system/
         install -m 0644 ${WORKDIR}/iptables.service ${D}${systemd_unitdir}/system/
         install -m 755 ${WORKDIR}/iptables.init ${D}${libexecdir}/
         install -m 755 ${WORKDIR}/ip6tables.init ${D}${libexecdir}/
         sed -i -e "s,/usr/libexec/iptables,${libexecdir},g" \
                       ${D}${systemd_unitdir}/system/iptables.service
         sed -i -e "s,/usr/libexec/iptables,${libexecdir},g" \
                           ${D}${systemd_unitdir}/system/ip6tables.service
    fi

    install -d ${D}/${sysconfdir}/init.d
    install -d ${D}/${sysconfdir}/default
    install -d ${D}/${sysconfdir}/iptables

    install -m 755 ${WORKDIR}/iptables.init    ${D}${sysconfdir}/init.d/iptables
    install -m 755 ${WORKDIR}/iptables.default ${D}${sysconfdir}/default/iptables
    install -m 755 ${WORKDIR}/iptables.data    ${D}${sysconfdir}/iptables/iptables
    install -m 755 ${WORKDIR}/ip6tables.init    ${D}${sysconfdir}/init.d/ip6tables
    install -m 755 ${WORKDIR}/ip6tables.default ${D}${sysconfdir}/default/ip6tables
    install -m 755 ${WORKDIR}/ip6tables.data    ${D}${sysconfdir}/iptables/ip6tables

}

