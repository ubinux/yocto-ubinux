FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-Backport-a-bug-fix-to-fix-radiuss.service-failed-wit.patch "
pkg_postinst:${PN} () {
    if [ -z "$D" ]; then
        if command -v systemd-tmpfiles >/dev/null; then
            # create /var/log/radius, /var/run/radiusd
            systemd-tmpfiles --create ${sysconfdir}/tmpfiles.d/radiusd.conf
        elif [ -e ${sysconfdir}/init.d/populate-volatile.sh ]; then
            ${sysconfdir}/init.d/populate-volatile.sh update
        fi

        # Fix ownership for /etc/raddb/*, /var/lib/radiusd
        chown -R radiusd:radiusd ${raddbdir}
        chown -R radiusd:radiusd ${localstatedir}/lib/radiusd

        # for radiusd.service with multilib
        if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
            install -d ${sysconfdir}/sysconfig
            echo "MLPREFIX=" > ${sysconfdir}/sysconfig/radiusd
        fi
    else
        if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
            install -d $D${sysconfdir}/sysconfig
            echo "MLPREFIX=" > $D${sysconfdir}/sysconfig/radiusd
        fi
    fi
}


