SUMMARY = "Y2038 safe version of lastlog"
HOMEPAGE = "https://github.com/thkukuk/lastlog2"
DESCRIPTION = "lastlog reports the last login of a given user or of all users who did ever login on a system."
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=020090a00b69dd2af9ab82eb0003ea2c"
SECTION = "libs"

SRCREV = "585153a577788c590370d20e40263b61238dfab3"

SRC_URI = "git://github.com/thkukuk/lastlog2.git;branch=main;protocol=https \
"

S = "${WORKDIR}/git"

inherit meson pkgconfig systemd

DEPENDS += " ${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)} sqlite3 "

SYSTEMD_SERVICE:${PN} = "lastlog2-import.service"

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
