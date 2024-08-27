inherit update-alternatives

ALTERNATIVE:${PN} += "pam_lastlog2"

ALTERNATIVE_TARGET[pam_lastlog2] = "${libdir}/security/pam_lastlog2.so"
ALTERNATIVE_LINK_NAME[pam_lastlog2] = "${libdir}/security/pam_lastlog2.so"

ALTERNATIVE_PRIORITY = "100"

