inherit multilib_script multilib_header
MULTILIB_SCRIPTS += "${PN}:${bindir}/php-config \
                     ${PN}:${bindir}/phpize \
"

do_install:append () {
        oe_multilib_header php/main/build-defs.h php/main/php_config.h
}


