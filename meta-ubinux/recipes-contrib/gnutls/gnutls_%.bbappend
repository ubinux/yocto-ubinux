DEPENDS:append:class-target = " gnutls-native"
DEPENDS:append:class-nativesdk = " gnutls-native"

PACKAGECONFIG:append = " fips "

PACKAGECONFIG[fips] = "--enable-fips140-mode --with-libdl-prefix=${STAGING_BASELIBDIR},--disable-fips140-mode"

do_compile:prepend:class-target () {
        if ${@bb.utils.contains('PACKAGECONFIG', 'fips', 'true', 'false', d)}; then
          sed -i -e "s#\$(builddir)/fipshmac#${STAGING_DIR_NATIVE}/lib/fipshmac#g" ${B}/lib/Makefile
        fi
}

do_compile:prepend:class-nativesdk () {
        if ${@bb.utils.contains('PACKAGECONFIG', 'fips', 'true', 'false', d)}; then
          sed -i -e "s#\$(builddir)/fipshmac#${STAGING_DIR_NATIVE}/lib/fipshmac#g" ${B}/lib/Makefile
        fi
}

do_install:append:class-native() {
        if ${@bb.utils.contains('PACKAGECONFIG', 'fips', 'true', 'false', d)}; then
          install -d ${D}${base_prefix}/lib
          install -d ${D}${base_prefix}/lib/.libs
          install -m 0755 ${B}/lib/fipshmac ${D}${base_prefix}/lib/
          install -m 0755 ${B}/lib/.libs/fipshmac ${D}/${base_prefix}/lib/.libs/
        fi
}

