pkg_postinst_${PN} () {
    if [ x"$D" != "x" ]; then
        $INTERCEPT_DIR/postinst_intercept delay_to_first_boot ${PKG} mlprefix=${MLPREFIX}
    else
        ${datadir}/sfcb/genSslCert.sh ${sysconfdir}/sfcb
        ${bindir}/sfcbrepos -f
    fi
}

