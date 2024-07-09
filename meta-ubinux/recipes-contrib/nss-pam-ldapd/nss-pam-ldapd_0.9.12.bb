SUMMARY = "NSS and PAM module for using LDAP as a naming service"
DESCRIPTION = "\
 daemon for NSS and PAM lookups using LDAP \
 This package provides a daemon for retrieving user accounts and similar \
 system information from LDAP. It is used by the libnss-ldapd and \
 libpam-ldapd packages but is not very useful by itself. \
 "

HOMEPAGE = "http://arthurdejong.org/nss-pam-ldapd/"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"
SECTION = "base"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "\
	http://arthurdejong.org/nss-pam-ldapd/${BPN}-${PV}.tar.gz \
	file://0001-utils-Makefile.am-fix-shebang-for-chsh.py-and-getent.patch \
	file://nslcd.init \
	file://nslcd.service \
	"

inherit autotools features_check
REQUIRED_DISTRO_FEATURES = "pam"

SRC_URI[md5sum] = "cc30ee0ab91d6c94b7a343ae09b5dc69"
SRC_URI[sha256sum] = "c6d661e74693cbf531a790631ca93b73f291fb23cc39465b09deb8da2bfb0e14"

DEPENDS += "libpam openldap krb5"

EXTRA_OECONF = "\
	--disable-pynslcd \
	--libdir=${base_libdir} \
	--with-pam-seclib-dir=${base_libdir}/security \
	"

CONFFILES:${PN} += "${sysconfdir}/nslcd.conf"

FILES:${PN} += "${base_libdir}/security ${datadir}"
FILES:${PN}-dbg += "${base_libdir}/security/.debug"

LDAP_DN ?= "dc=my-domain,dc=com"

do_install:append() {
	install -D -m 0755 ${UNPACKDIR}/nslcd.init ${D}${sysconfdir}/init.d/nslcd

	sed -i -e 's/^uid nslcd/# uid nslcd/;' ${D}${sysconfdir}/nslcd.conf
	sed -i -e 's/^gid nslcd/# gid nslcd/;' ${D}${sysconfdir}/nslcd.conf
	sed -i -e 's/^base dc=example,dc=com/base ${LDAP_DN}/;' ${D}${sysconfdir}/nslcd.conf

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${UNPACKDIR}/nslcd.service ${D}${systemd_unitdir}/system
}

inherit update-rc.d systemd

INITSCRIPT_NAME = "nslcd"
INITSCRIPT_PARAMS = "defaults"

SYSTEMD_SERVICE:${PN} = "nslcd.service"
