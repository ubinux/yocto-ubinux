inherit update-alternatives

ALTERNATIVE:${PN} = "rules.d"

ALTERNATIVE_TARGET[rules.d] = "${datadir}/polkit-1/rules-polkit.d"
ALTERNATIVE_LINK_NAME[rules.d] = "${datadir}/polkit-1/rules.d"

ALTERNATIVE_PRIORITY[rules.d] = "100"

