inherit multilib_script multilib_header

do_install:append () {
        oe_multilib_header frr/version.h
}

inherit multilib_script
MULTILIB_SCRIPTS += "${PN}:${systemd_system_unitdir}/frr.service "
MULTILIB_SCRIPTS += "${PN}:${systemd_system_unitdir}/frr@.service "

inherit update-alternatives

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE:${PN} = " ietf-interfaces "

ALTERNATIVE_LINK_NAME[ietf-interfaces] = "${datadir}/yang/ietf-interfaces.yang"

