ALTERNATIVE_${PN} += "mailq newaliases"

ALTERNATIVE_TARGET[mailq] = "${bindir}/mailq"

ALTERNATIVE_TARGET[newaliases] = "${bindir}/newaliases"
