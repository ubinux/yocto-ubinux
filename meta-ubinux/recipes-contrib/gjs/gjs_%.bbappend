inherit multilib_script

MULTILIB_SCRIPTS:append = "${PN}:${libexecdir}/installed-tests/gjs/GIMarshallingTests-1.0.typelib \
                    ${PN}:${libexecdir}/installed-tests/gjs/Regress-1.0.typelib \
                    ${PN}:${libexecdir}/installed-tests/gjs/Utility-1.0.typelib \
                    ${PN}:${libexecdir}/installed-tests/gjs/WarnLib-1.0.typelib \
                    "
