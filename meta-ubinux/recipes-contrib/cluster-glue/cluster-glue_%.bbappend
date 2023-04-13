inherit multilib_script
MULTILIB_SCRIPTS += "${PN}:${systemd_system_unitdir}/logd.service \
		     ${PN}-lrmtest:${datadir}/cluster-glue/lrmtest/regression.sh \
		     ${PN}-lrmtest:${datadir}/cluster-glue/lrmtest/LRMBasicSanityCheck "

