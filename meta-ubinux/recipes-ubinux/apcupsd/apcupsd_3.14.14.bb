SUMMARY = "Apcupsd a daemon for controlling APC UPSes"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

#SRC_URI = "http://garr.dl.sourceforge.net/project/apcupsd/apcupsd%20-%20Stable/3.14.14/apcupsd-${PV}.tar.gz"
SRC_URI = "https://sourceforge.net/projects/apcupsd/files/apcupsd%20-%20Stable/3.14.14/apcupsd-3.14.14.tar.gz"
SRC_URI[sha256sum] = "db7748559b6b4c3784f9856561ef6ac6199ef7bd019b3edcd7e0a647bf8f9867"

PNBLACKLIST[apcupsd] ?= "BROKEN: doesn't build with B!=S"

inherit autotools

PNBLACKLIST[apcupsd] = ""
B = "${S}"
HOSTTOOLS_NONFATAL:append = "man col shutdown"

LD = "${CXX}"

EXTRA_OECONF = "--without-x \
                --enable-usb \
                --with-distname=${DISTRO} \
                ac_cv_path_SCRIPTSHELL=/bin/sh \
               "

do_configure() {
    export topdir=${S}
    cp -a ${S}/autoconf/configure.in ${S}

    if ! [ -d ${S}/platforms/${DISTRO} ] ; then
        cp -a ${S}/platforms/unknown ${S}/platforms/${DISTRO} 
    fi

    gnu-configize --force
    # install --help says '-c' is an ignored option, but it turns out that the argument to -c isn't ignored, so drop the complete '-c path/to/strip' line
    sed -i -e 's:$(INSTALL_PROGRAM) $(STRIP):$(INSTALL_PROGRAM):g' ${S}/autoconf/targets.mak
    # Searching in host dirs triggers the QA checks
    sed -i -e 's:-I/usr/local/include::g' -e 's:-L/usr/local/lib64::g' -e 's:-L/usr/local/lib::g' ${S}/configure

    # m4 macros are missing, using autotools_do_configure leads to linking errors with gethostname_re
    oe_runconf
}

do_install:append() {
    rm ${D}${datadir}/hal -rf
}

