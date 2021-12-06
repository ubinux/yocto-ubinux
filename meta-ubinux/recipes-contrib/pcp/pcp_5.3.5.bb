require pcp.inc
#inherit perlnative
#inherit python3native

# NOTE: the following prog dependencies are unknown, ignoring: gtar gzip pkgmk xmlto lzma qshape md5sum pod2man publican git makedepend qmake-qt4 xconfirm true gmake xz dblatex hdiutil rpm bzip2 which mkinstallp dtrace seinfo qmake-qt5 gawk dlltool rpmbuild dpkg makepkg qmake echo
# NOTE: unable to map the following pkg-config dependencies: libmicrohttpd libsystemd-journal
#       (this is based on recipes that have previously been built and packaged)
# NOTE: the following library dependencies are unknown, ignoring: nspr gen ibumad regex sasl2 pfm nss papi ibmad
#       (this is based on recipes that have previously been built and packaged)
DEPENDS += "perl-native bison-native flex-native python3-native python3-setuptools python3 \
	pcp-native cairo zlib ncurses readline libx11 avahi openssl"


SRC_URI += "file://0001-Remove-unsuitble-part-for-cross-compile.patch \
           "


export PCP_DIR = "${RECIPE_SYSROOT_NATIVE}"
#export PCP_RUN_DIR = "${RECIPE_SYSROOT_NATIVE}"
#EXTRA_OEMAKE = "CC="${CC}" LD="${LD}" AR="${AR}""
inherit useradd systemd autotools pkgconfig

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "pmcd.service pmcd.service pmie_check.service pmie_farm_check.service \
                         pmlogger_daily.service pmlogger_farm_check.service pmfind.service \
                         pmie_daily.service  pmlogger.service pmlogger_daily_report.service \
                         pmproxy.service pmie.service pmie_farm.service pmlogger_check.service \
                         pmlogger_farm.service"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "--system --home ${localstatedir}/lib/pcp --no-create-home \
                       --user-group pcp"

USERADD_PACKAGES = "${PN}-testsuite"
USERADD_PARAM:${PN}-testsuite = "--system --home ${localstatedir}/lib/pcp/testsuite --no-create-home \
                       --user-group pcpqa"

RDEPENDS:${PN} += "perl"
RDEPENDS:${PN}-testsuite += "${PN} bash perl"

do_configure:prepend () {
    cp ${WORKDIR}/config.linux ${B}
    rm -rf ${S}/include/pcp/configsz.h
    rm -rf ${S}/include/pcp/platformsz.h
    export SED=${TMPDIR}/hosttools/sed
    export PYTHON=python3
    sed -i -e 's|="-I/usr/include/${PY_VERSION}m | ="-I${STAGING_DIR_HOST}${includedir}/${PY_VERSION}m|' \
        -e 's|-I/usr/include/${PY_VERSION}"|-I${STAGING_DIR_HOST}${includedir}/${PY_VERSION}|' \
      	${S}/configure.ac
}

do_compile() {
	sed -i -e "s,#undef HAVE_64BIT_LONG,,g" \
		-e "s,#undef HAVE_64BIT_PTR,,g" \
		-e "s,#undef PM_SIZEOF_SUSECONDS_T,,g" \
		-e "s,#undef PM_SIZEOF_TIME_T,,g" \
		${S}/src/include/pcp/config.h.in
	sed -i -e "s,HAVE_PYTHON_ORDEREDDICT = false,HAVE_PYTHON_ORDEREDDICT = true,g" \
		${S}/src/include/builddefs 

        oe_runmake default_pcp
}

do_install () {
	export NO_CHOWN=true
	oe_runmake install DESTDIR=${D} \
	PCP_ETC_DIR=${D}${sysconfdir} \
	PCP_SYSCONFIG_DIR=${D}${sysconfdir} \
	PCP_SYSCONF_DIR=${D}${sysconfdir}/pcp \
	PCP_VAR_DIR=${D}${localstatedir}/lib/pcp \
	PCP_SHARE_DIR=${D}${datadir}/pcp \
	PCP_BIN_DIR=${D}${bindir} \
	PCP_BINADM_DIR=${D}${libdir}/pcp/bin \
	PCP_LIBADM_DIR=${D}${libdir} \
	PCP_LIB_DIR=${D}${libdir} \
	PCP_MAN_DIR=${D}${mandir} \
	PCP_DOC_DIR=${D}${docdir} \
	PCP_TMP_DIR=${D}${localstatedir}/lib/pcp/tmp \
	PCP_PMDAS_DIR=${D}${localstatedir}/pcp/pmdas \
	PCP_INC_DIR=${D}${includedir}/pcp \
	PCP_SECURE_DB_PATH=${D}${sysconfdir}/pcp \
	PCP_DEMOS_DIR=${D}${datadir}/pcp/demos \
	PCP_PMNSADM_DIR=${D}${libdir}/pcp/pmns \
	PCP_PMNS_DIR=${D}${localstatedir}/lib/pcp/pmns \
	PCP_BASHSHARE_DIR=${D}${datadir}/bash-completion \
	PCP_LOG_DIR=${D}${localstatedir}/log \
	PCP_SYSTEMDUNIT_DIR=${D}${systemd_system_unitdir} \
	PCP_PMCDOPTIONS_PATH=${D}${sysconfdir}/pcp/pmcd/pmcd.options \
	PCP_PMCDRCLOCAL_PATH=${D}${sysconfdir}/pcp/pmcd/rc.local \
	PCP_RC_DIR=${D}${libdir}/pcp/lib/ \
	PCP_PMCDCONF_PATH=${D}${sysconfdir}/pcp/pmcd/pmcd.conf \
	PCP_SASLCONF_DIR=${D}${sysconfdir}/sasl2 \
	PCP_PMDASADM_DIR=${D}${libdir}/pcp/pmdas \
	PCP_PMIECONTROL_PATH=${D}${sysconfdir}/pcp/pmie/control \
	PCP_PMLOGGERCONTROL_PATH=${D}${sysconfdir}/pcp/pmlogger/control \
	PCP_SA_DIR=${D}${localstatedir}/log/sa \
	INSTALLVENDORLIB=${D}${datadir}/perl5 \
	INSTALLVENDORARCH=${D}${libdir}/x86_64-linux-gnu/perl5/5.30 \
	INSTALLVENDORMAN3DIR=${D}${mandir}/man3 \
	PCP_HTML_DIR=${D}${datadir}/doc/pcp-doc/html \
	install_pcp

	rm -rf ${D}${localstatedir}/log
	rm -rf ${D}${localstatedir}/lib/pcp/pmcd
	rm -rf ${D}${localstatedir}/lib/pcp/tmp
	mv ${D}${libdir}/pcp/bin/pcp-dstat ${D}${bindir}/dstat
	ln -sf ${libdir}/pcp/pmdas/sendmail/pmda_sendmail.so ${D}${localstatedir}/pcp/pmdas/sendmail/pmda_sendmail.so
 	ln -sf ${libdir}/pcp/pmdas/jbd2/pmda_jbd2.so ${D}${localstatedir}/pcp/pmdas/jbd2/pmda_jbd2.so
	ln -sf ${libdir}/pcp/pmdas/hacluster/pmda_hacluster.so ${D}${localstatedir}/pcp/pmdas/hacluster/pmda_hacluster.so
	ln -sf ${libdir}/pcp/pmdas/linux/pmda_linux.so ${D}${localstatedir}/pcp/pmdas/linux/pmda_linux.so
	ln -sf ${libdir}/pcp/pmdas/sample/pmda_sample.so ${D}${localstatedir}/pcp/pmdas/sample/pmda_sample.so
	ln -sf ${libdir}/pcp/pmdas/sockets/pmda_sockets.so ${D}${localstatedir}/pcp/pmdas/sockets/pmda_sockets.so
	ln -sf ${libdir}/pcp/pmdas/proc/pmda_proc.so ${D}${localstatedir}/pcp/pmdas/proc/pmda_proc.so
	ln -sf ${libdir}/pcp/pmdas/smart/pmda_smart.so ${D}${localstatedir}/pcp/pmdas/smart/pmda_smart.so
	ln -sf ${libdir}/pcp/pmdas/denki/pmda_denki.so ${D}${localstatedir}/pcp/pmdas/denki/pmda_denki.so
	ln -sf ${libdir}/pcp/pmdas/nvidia/pmda_nvidia.so ${D}${localstatedir}/pcp/pmdas/nvidia/pmda_nvidia.so
	ln -sf ${libdir}/pcp/pmdas/pmcd/pmda_pmcd.so ${D}${localstatedir}/pcp/pmdas/pmcd/pmda_pmcd.so
	ln -sf ${libdir}/pcp/pmdas/mmv/pmda_mmv.so ${D}${localstatedir}/pcp/pmdas/mmv/pmda_mmv.so
	ln -sf ${libdir}/pcp/pmdas/dm/pmda_dm.so ${D}${localstatedir}/pcp/pmdas/dm/pmda_dm.so
	ln -sf ${libdir}/pcp/pmdas/xfs/pmda_xfs.so ${D}${localstatedir}/pcp/pmdas/xfs/pmda_xfs.so
	ln -sf ${libdir}/pcp/pmdas/docker/pmda_docker.so ${D}${localstatedir}/pcp/pmdas/docker/pmda_docker.so
	ln -sf ${libdir}/pcp/pmdas/zfs/pmda_zfs.so ${D}${localstatedir}/pcp/pmdas/zfs/pmda_zfs.so
	ln -sf ${libdir}/pcp/pmdas/cifs/pmda_cifs.so ${D}${localstatedir}/pcp/pmdas/cifs/pmda_cifs.so
	ln -sf ${libdir}/pcp/pmdas/kvm/pmda_kvm.so ${D}${localstatedir}/pcp/pmdas/kvm/pmda_kvm.so
	ln -sf ${libdir}/zabbix/agent/zbxpcp.so ${D}${libdir}/zabbix/modules/zbxpcp.so
}

PACKAGES += " ${PN}-testsuite ${PN}-export-zabbix-agent \
	libpcp-gui2  libpcp-gui2-dev \
	libpcp-import1 \
	libpcp-mmv1 libpcp-mmv1-dev \
	libpcp-pmda3 libpcp-pmda3-dev \
	libpcp-trace2 libpcp-trace2-dev \
	libpcp-web1 libpcp-web1-dev \
	libpcp3 libpcp3-dev \
"
FILES:libpcp-gui2 = " \
	${libdir}/libpcp_gui.so.2 \
"	
FILES:libpcp-gui2-dev = " \
	${libdir}/libpcp_gui.so \
	${libdir}/libpcp_gui.a \
	${includedir}/pmafm.h \
	${includedir}/pmtime.h \
"
FILES:libpcp-mmv1 = " \
	${libdir}/libpcp_mmv.so.1 \
"
FILES:libpcp-mmv1-dev = " \
	${libdir}/libpcp_mmv.a \
	${libdir}/libpcp_mmv.so \
	${libdir}/libpcp_mmv.so \
	${includedir}/mmv_stats.h \
	${includedir}/mmv_dev.h \
	${datadir}/man/man3/mmv_* \
	${datadir}/man/man5/mmv.5.gz \
"
FILES:libpcp-import1 = " \
	${libdir}/libpcp_import.so.1 \
"
FILES:libpcp-pmda3 = " \
	${libdir}/libpcp_pmda.so.3 \
"
FILES:libpcp-pmda3-dev = " \
	${includedir}/pmda.h \
	${includedir}/pmdaroot.h \
	${libdir}/libpcp_pmda.a \
	${libdir}/libpcp_pmda.so \
	${libdir}/pkgconfig/libpcp_pmda.pc \
	${datadir}/man/man3/PMDA.3.gz \
	${datadir}/man/man3/pmda* \
"
FILES:libpcp-trace2 = " \
	${libdir}/libpcp_trace.so.2 \
"
FILES:libpcp-trace2-dev = " \
	${includedir}/trace.h \
	${includedir}/trace_dev.h \
	${libdir}/libpcp_trace.a \
	${libdir}/libpcp_trace.so \
	${datadir}/man/man3/pmtrace* \
"
FILES:libpcp-web1 = " \
	${libdir}/libpcp_web.so.1 \
"
FILES:libpcp-web1-dev = " \
	${includedir}/pmhttp.h \
	${includedir}/pmjson.h \
	${libdir}/libpcp_web.a \
	${libdir}/libpcp_web.so \
	${datadir}/man/man3/pmhttp* \
	${datadir}/man/man3/pmjson* \
"
FILES:libpcp3 = " \
	${libdir}/libpcp.so.3 \
"
FILES:libpcp3-dev = " \
	${includedir}/pcp \
	${libdir}/libpcp.a \
	${libdir}/libpcp.so \
	${libdir}/pcp/bin/install-sh \
	${libdir}/pkgconfig/libpcp.pc \
	${datadir}/man/man3/LOGIMPORT.3.gz \
	${datadir}/man/man3/P* \
	${datadir}/man/man3/Q* \
	${datadir}/man/man3/__pm* \
	${datadir}/man/man3/pmA* \
	${datadir}/man/man3/pmC* \
	${datadir}/man/man3/pmD* \
	${datadir}/man/man3/pmE* \
	${datadir}/man/man3/pmF* \
	${datadir}/man/man3/pmG* \
	${datadir}/man/man3/pmH* \
	${datadir}/man/man3/pmI* \
	${datadir}/man/man3/pmL* \
	${datadir}/man/man3/pmM* \
	${datadir}/man/man3/pmN* \
	${datadir}/man/man3/pmO* \
	${datadir}/man/man3/pmP* \
	${datadir}/man/man3/pmR* \
	${datadir}/man/man3/pmS* \
	${datadir}/man/man3/pmT* \
	${datadir}/man/man3/pmU* \
	${datadir}/man/man3/pmW* \
	${datadir}/man/man3/pmf* \
	${datadir}/man/man3/pmg* \
	${datadir}/man/man3/pmi* \
	${datadir}/man/man3/pms* \
	${datadir}/man/man3/pmt* \
"
FILES:${PN}-testsuite = " \
        ${includedir}/pcp/fault.h \
        ${libdir}/libpcp_fault.* \
        ${localstatedir}/lib/pcp/testsuite \
"

FILES:${PN} = " \
	${sysconfdir}/pcp \
	${bindir} \
	${datadir}/bash-completion \
	${datadir}/pcp-gui \
	${datadir}/zsh \
	${systemd_system_unitdir}/ \
	${libdir}/pcp/ \
	${datadir}/pcp \
	${libdir}/*.sh \
	${datadir}/man \
	${localstatedir}/pcp/p* \
	${localstatedir}/lib/pcp/config/* \
	${localstatedir}/lib/pcp/pmdas/* \
	${localstatedir}/lib/pcp/pmns/* \
	${libdir}/rc-proc.sh.minimal \
	${sysconfdir}/p* \
	${sysconfdir}/s* \
"

FILES:${PN}-export-zabbix-agent = "${libdir}/zabbix \
	${sysconfdir}/zabbix \
	${mandir}/man3/zbxpcp.3.gz \
	${libdir}/zabbix \
"

FILES:${PN}-dev += " \
	${localstatedir}/pcp/pmdas/sendmail/pmda_sendmail.so \
	${localstatedir}/pcp/pmdas/jbd2/pmda_jbd2.so \
	${localstatedir}/pcp/pmdas/hacluster/pmda_hacluster.so \
	${localstatedir}/pcp/pmdas/linux/pmda_linux.so \
	${localstatedir}/pcp/pmdas/sample/pmda_sample.so \
	${localstatedir}/pcp/pmdas/sockets/pmda_sockets.so \
	${localstatedir}/pcp/pmdas/proc/pmda_proc.so \
	${localstatedir}/pcp/pmdas/smart/pmda_smart.so \
	${localstatedir}/pcp/pmdas/denki/pmda_denki.so \
	${localstatedir}/pcp/pmdas/nvidia/pmda_nvidia.so \
	${localstatedir}/pcp/pmdas/pmcd/pmda_pmcd.so \
	${localstatedir}/pcp/pmdas/mmv/pmda_mmv.so \
	${localstatedir}/pcp/pmdas/dm/pmda_dm.so \
	${localstatedir}/pcp/pmdas/xfs/pmda_xfs.so \
	${localstatedir}/pcp/pmdas/docker/pmda_docker.so \
	${localstatedir}/pcp/pmdas/zfs/pmda_zfs.so \
	${localstatedir}/pcp/pmdas/cifs/pmda_cifs.so \
	${localstatedir}/pcp/pmdas/kvm/pmda_kvm.so \
	${libdir}/zabbix/modules/zbxpcp.so \
"

