inherit multilib_header
do_install:append() {
    oe_multilib_header jasper/jas_config.h
 }

