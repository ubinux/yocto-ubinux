PACKAGECONFIG = " "



DEPENDS:remove:class-target = " googletest "

do_install_ptest () {
	install -d ${D}${PTEST_PATH}      
}
