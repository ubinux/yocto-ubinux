DESCRIPTION = "Poky exampl feed configuration"

PR = "r1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

#FEEDNAMEPREFIX ?= "INVALID"
#FEEDURIPREFIX ?= "INVALID"

do_compile() {
	mkdir -p ${S}/${sysconfdir}/opkg/

	archconf=${S}/${sysconfdir}/opkg/arch.conf

	rm -f $archconf
	ipkgarchs="${PACKAGE_ARCHS}"
	priority=1
	for arch in $ipkgarchs; do 
		echo "arch $arch $priority" >> $archconf
		priority=$(expr $priority + 5)
	done

	basefeedconf=${S}/${sysconfdir}/opkg/base-feeds.conf

	rm -f $basefeedconf
	touch $basefeedconf

	#for arch in $ipkgarchs; do
	#        echo "src/gz ${FEEDNAMEPREFIX}-$arch http://pokylinux.org/${FEEDURIPREFIX}$arch" >> $basefeedconf
	#done
}


do_install () {
	install -d ${D}${sysconfdir}/opkg
	install -m 0644  ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

FILES_${PN} = "${sysconfdir}/opkg/ "

CONFFILES_${PN} += "${sysconfdir}/opkg/base-feeds.conf \
                    ${sysconfdir}/opkg/arch.conf"

