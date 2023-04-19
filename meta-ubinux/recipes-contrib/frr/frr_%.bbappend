inherit multilib_script multilib_header

do_install:append () {
        oe_multilib_header frr/version.h
}

inherit update-alternatives

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE:${PN} = " ietf-interfaces "

ALTERNATIVE_LINK_NAME[ietf-interfaces] = "${datadir}/yang/ietf-interfaces.yang"

