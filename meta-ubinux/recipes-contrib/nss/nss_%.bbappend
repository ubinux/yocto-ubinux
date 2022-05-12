do_compile:append:class-target() {
    export NSS_ENABLE_FIPS_INDICATORS
    export NSS_FORCE_FIPS=1
}
