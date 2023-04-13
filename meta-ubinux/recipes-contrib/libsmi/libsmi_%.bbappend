inherit update-alternatives

ALTERNATIVE_PRIORITY = "50"

ALTERNATIVE:${PN}-yang = "ietf-interfaces "

ALTERNATIVE_LINK_NAME[ietf-interfaces] = "${datadir}/yang/ietf-interfaces.yang"

