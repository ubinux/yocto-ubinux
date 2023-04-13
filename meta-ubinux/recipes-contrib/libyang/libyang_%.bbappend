inherit multilib_header

do_install:append () {
        oe_multilib_header  libyang/config.h
}

