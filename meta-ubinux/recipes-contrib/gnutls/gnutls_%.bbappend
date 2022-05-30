FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "\
                 file://0001-Creating-.hmac-file-should-be-excuted-in-target-envi.patch \ 
                 "

PACKAGECONFIG[fips] = "--enable-fips140-mode --with-libdl-prefix=${STAGING_BASELIBDIR},--disable-fips140-mode"

PACKAGECONFIG:append = " fips "

do_install:append:class-target() {
        if ${@bb.utils.contains('PACKAGECONFIG', 'fips', 'true', 'false', d)}; then
          install -d ${D}${bindir}/bin
          install -m 0755 ${B}/lib/.libs/fipshmac ${D}/${bindir}/
        fi
}

PACKAGES =+ "${PN}-fips"

FILES:${PN}-fips += "${bindir}/fipshmac"

pkg_postinst_ontarget:${PN}-fips () {
    if test -x ${bindir}/fipshmac
    then
        mkdir ${sysconfdir}/gnutls
        touch ${sysconfdir}/gnutls/config
        ${bindir}/fipshmac ${libdir}/libgnutls.so.30.*.* > ${libdir}/.libgnutls.so.30.hmac
        ${bindir}/fipshmac ${libdir}/libnettle.so.8.* > ${libdir}/.libnettle.so.8.hmac
        ${bindir}/fipshmac ${libdir}/libgmp.so.10.*.* > ${libdir}/.libgmp.so.10.hmac
        ${bindir}/fipshmac ${libdir}/libhogweed.so.6.* > ${libdir}/.libhogweed.so.6.hmac
    fi
}

