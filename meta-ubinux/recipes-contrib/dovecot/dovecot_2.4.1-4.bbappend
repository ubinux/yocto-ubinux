do_install:append () {
    install -d 755 ${D}/etc/dovecot
    touch ${D}/etc/dovecot/ssl-key.pem
    touch ${D}/etc/dovecot/ssl-cert.pem
    chmod 600 ${D}/etc/dovecot/ssl-key.pem
    chmod 600 ${D}/etc/dovecot/ssl-cert.pem
}
