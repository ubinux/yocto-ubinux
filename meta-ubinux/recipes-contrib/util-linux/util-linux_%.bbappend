inherit update-alternatives

ALTERNATIVE:${PN}-lastlog2 = "pam_lastlog2"
ALTERNATIVE_TARGET[pam_lastlog2] = "${libdir}/security/pam_lastlog2-util-linux.so"
ALTERNATIVE_LINK_NAME[pam_lastlog2] = "${libdir}/security/pam_lastlog2.so"

ALTERNATIVE_PRIORITY = "80"
