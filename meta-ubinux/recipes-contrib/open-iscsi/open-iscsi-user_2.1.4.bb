DESCRIPTION = "Open-iSCSI project is a high performance, transport independent, multi-platform implementation of RFC3720."
HOMEPAGE = "http://www.open-iscsi.org/"
LICENSE = "GPLv2"
PR = "r1"

inherit systemd autotools pkgconfig

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "kmod openssl util-linux open-isns"
DEPENDS:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '', d)}"

SRC_URI = "git://github.com/open-iscsi/open-iscsi.git;protocol=https;branch=master \
           file://0001-fix-build-error-of-cross-build.patch \
           "

SRCREV = "095f59ca464220eae285de6b5f2ee31185a6a84c"

S = "${WORKDIR}/git"
B = "${S}"

TARGET_CC_ARCH += "${LDFLAGS}"
EXTRA_OEMAKE += "CONFIGURE_ARGS='--host=${HOST_SYS}'"

do_configure () {
    :
}

do_compile () {
        oe_runmake user
}

do_install () {
        oe_runmake DESTDIR="${D}" install_user
        install ${S}/etc/initd/initd.debian ${D}/etc/init.d/open-iscsi
        install -m 0644 ${S}/etc/iscsid.conf ${D}/etc/iscsi/

        install -d ${D}${libdir}
        install -Dm 0644 ${S}/libopeniscsiusr/libopeniscsiusr.so.0.2.0 ${D}${libdir}/
        ln -sf ${libdir}/libopeniscsiusr.so.0.2.0 ${D}${libdir}/libopeniscsiusr.so
}

# systemd support
PACKAGES =+ "${PN}-systemd"
RDEPENDS:${PN} += "bash"
RDEPENDS:${PN}-systemd += "${PN}"
FILES:${PN}-systemd +=  "${base_libdir}/systemd                  \
                         ${sysconfdir}/default/iscsi-initiator   \
                        "
SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE:${PN}-systemd = "iscsi.service \
                                 iscsiuio.service \
                                 iscsid.service \
                                 iscsi-init.service \
                                 iscsid.socket \
                                 iscsiuio.socket "

do_install:append () {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${S}/etc/systemd/* ${D}${systemd_unitdir}/system/
}
