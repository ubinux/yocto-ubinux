FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-Fix-multilib-conflict-error-after-kea-been-upgraded-.patch "

EXTRA_OEMESON += "-Dcrypto=openssl -Drunstatedir=${runtimedir} -Dkrb5=disabled -Dnetconf=disabled --install-umask=0022"

do_install:append() {
    rm -rf ${D}${runtimedir}
}
