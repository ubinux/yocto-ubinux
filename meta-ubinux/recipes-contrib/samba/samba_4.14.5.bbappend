inherit perl-version

do_configure_append () {
    cd ${S}/pidl/
    perl Makefile.PL PREFIX=${prefix}
    sed -e 's,VENDORPREFIX)/lib/perl,VENDORPREFIX)/${baselib}/perl,g' \
        -e 's,PERLPREFIX)/lib/perl,PERLPREFIX)/${baselib}/perl,g' -i Makefile
}

do_compile_append () {
    cd ${S}/pidl/
    make
}

do_install_append() {
    cd ${S}/pidl/
    make DESTDIR=${D} install_vendor
    rm -rf ${D}${libdir}/perl5/${PERLVERSION}/${BUILD_SYS}/perllocal.pod
    rm -rf ${D}${libdir}/perl5/vendor_perl/${PERLVERSION}/${BUILD_SYS}/auto/Parse/Pidl/.packlist
}

FILES_${PN}-pidl = "${bindir}/pidl \
                    ${libdir}/perl5 \
                   "
