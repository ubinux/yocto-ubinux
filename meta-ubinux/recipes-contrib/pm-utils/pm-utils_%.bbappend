inherit multilib_script
MULTILIB_SCRIPTS += "${PN}:${bindir}/pm-is-supported \
		     ${PN}:${sbindir}/pm-hibernate \
		     ${PN}:${sbindir}/pm-powersave \
		     ${PN}:${sbindir}/pm-suspend \
		     ${PN}:${sbindir}/pm-suspend-hybrid \
"


