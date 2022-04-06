SUMMARY = "An implementation of the standard Unix documentation system accessed using the man command"
HOMEPAGE = "http://man-db.nongnu.org/"
DESCRIPTION = "man-db is an implementation of the standard Unix documentation system accessed using the man command. It uses a Berkeley DB database in place of the traditional flat-text whatis databases."
LICENSE = "LGPL-2.1-only & GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c \
                    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "${SAVANNAH_NONGNU_MIRROR}/man-db/man-db-${PV}.tar.xz \
           file://99_mandb \
           file://0001-man-Move-local-variable-declaration-to-function-scop.patch \
           file://man_db.conf-avoid-multilib-install-file-conflict.patch"
SRC_URI[sha256sum] = "ee97954d492a13731903c9d0727b9b01e5089edbd695f0cdb58d405a5af5514d"

DEPENDS = "libpipeline gdbm groff-native base-passwd"
RDEPENDS:${PN} += "base-passwd"
PACKAGE_WRITE_DEPS += "base-passwd"

# | /usr/src/debug/man-db/2.8.0-r0/man-db-2.8.0/src/whatis.c:939: undefined reference to `_nl_msg_cat_cntr'
USE_NLS:libc-musl = "no"

inherit gettext pkgconfig autotools systemd

EXTRA_OECONF = "--with-pager=less --with-systemdsystemunitdir=${systemd_system_unitdir}"
EXTRA_AUTORECONF += "-I ${S}/gl/m4"

PACKAGECONFIG[bzip2] = "--with-bzip2=bzip2,ac_cv_prog_have_bzip2='',bzip2"
PACKAGECONFIG[gzip] = "--with-gzip=gzip,ac_cv_prog_have_gzip='',gzip"
PACKAGECONFIG[lzip] = "--with-lzip=lzip,ac_cv_prog_have_lzip='',lzip"
PACKAGECONFIG[lzma] = "--with-lzma=lzma,ac_cv_prog_have_lzma='',xz"
PACKAGECONFIG[zstd] = "--with-zstd=zstd,ac_cv_prog_have_zstd='',zstd"
PACKAGECONFIG[xz] = "--with-xz=xz,ac_cv_prog_have_xz='',xz"

do_install() {
	autotools_do_install

	if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
	        install -d ${D}/etc/default/volatiles
		install -m 0644 ${WORKDIR}/99_mandb ${D}/etc/default/volatiles
	fi
}

do_install:append:libc-musl() {
        rm -f ${D}${libdir}/charset.alias
}

FILES:${PN} += "${prefix}/lib/tmpfiles.d"

FILES:${PN}-dev += "${libdir}/man-db/libman.so ${libdir}/${BPN}/libmandb.so"

RDEPENDS:${PN} += "groff"
RRECOMMENDS:${PN} += "less"
RPROVIDES:${PN} += " man"

def compress_pkg(d):
    if bb.utils.contains("INHERIT", "compress_doc", True, False, d):
         compress = d.getVar("DOC_COMPRESS")
         if compress == "gz":
             return "gzip"
         elif compress == "bz2":
             return "bzip2"
         elif compress == "xz":
             return "xz"
    return ""

RDEPENDS:${PN} += "${@compress_pkg(d)}"

SYSTEMD_SERVICE:${PN} = "man-db.timer man-db.service"
SYSTEMD_AUTO_ENABLE ?= "disable"
