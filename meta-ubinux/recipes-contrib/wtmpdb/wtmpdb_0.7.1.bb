SUMMARY = "Y2038 safe version of wtmp"
HOMEPAGE = "https://github.com/thkukuk/wtmpdb"
DESCRIPTION = "last reports the login and logout times of users and when the machine got rebooted."
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=020090a00b69dd2af9ab82eb0003ea2c"
SECTION = "libs"

SRCREV = "502b19a41c7a3b1b5e70969b18088683825f71f8"

SRC_URI = "git://github.com/thkukuk/wtmpdb.git;branch=main;protocol=https \
"

S = "${WORKDIR}/git"

inherit meson pkgconfig systemd

DEPENDS += " ${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)} sqlite3 "

SYSTEMD_SERVICE:${PN} = "wtmpdb-update-boot.service wtmpdb-rotate.service"

EXTRA_OEMESON = " -Dpamlibdir=${libdir}"

do_install:append () {
      # Fix makefile hardcoded path assumptions for systemd (assumes $prefix)
      # without usrmerge distro feature enabled
      install -d `dirname ${D}${systemd_unitdir}`
      mv ${D}${prefix}/lib/systemd `dirname ${D}${systemd_unitdir}`
}

FILES:${PN} += " ${systemd_system_unitdir} "
FILES:${PN} += " ${libdir} "
FILES:${PN} += " ${nonarch_libdir}/tmpfiles.d/* "
