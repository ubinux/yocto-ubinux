inherit update-alternatives


ALTERNATIVE_${PN} = "fail2ban-client fail2ban-regex fail2ban-server fail2ban-testcases"

ALTERNATIVE_TARGET[fail2ban-client] = "${bindir}/fail2ban-client"
ALTERNATIVE_TARGET[fail2ban-regex] = "${bindir}/fail2ban-regex"
+ALTERNATIVE_TARGET[fail2ban-server] = "${bindir}/fail2ban-server"
ALTERNATIVE_TARGET[fail2ban-testcases] = "${bindir}/fail2ban-testcases"

ALTERNATIVE_PRIORITY = "30"

