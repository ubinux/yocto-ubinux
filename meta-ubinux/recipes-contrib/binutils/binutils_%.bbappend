inherit update-alternatives

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE:${PN}-doc = " sframe-spec "

ALTERNATIVE_LINK_NAME[sframe-spec] = "${infodir}/sframe-spec.info"

