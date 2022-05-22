DESCRIPTION = "Open-iSCSI project is a high performance, transport independent, multi-platform implementation of RFC3720."
HOMEPAGE = "http://www.open-iscsi.org/"
LICENSE = "GPL-2.0-only"
PR = "r1"

inherit autotools systemd pkgconfig

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "kmod openssl util-linux open-isns"
DEPENDS:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '', d)}"

SRC_URI = "git://github.com/open-iscsi/open-iscsi.git;protocol=https;branch=master \
           file://0001-Makefile-Fix-build-error-of-cross-build.patch \
           file://0001-Fix-usr-bin-sed-to-sed.patch \
           file://0001-Modified-path-of-systemd-service-from-usr-lib-to-lib.patch \
           "

SRCREV = "7b53fcc502da8617110fd64d675b476772c28a6f"

S = "${WORKDIR}/git"
B = "${S}"

PARALLEL_MAKEINST = ""
TARGET_CC_ARCH += "${LDFLAGS}"
EXTRA_OEMAKE += "CONFIGURE_ARGS='--host=${HOST_SYS}' MFLAGS='' LIB_DIR=${libdir}"
RDEPENDS:${PN} += "bash"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "iscsi.service \
                         iscsid.socket \
                         iscsiuio.socket \
                         iscsid.service \
                         iscsi-init.service \
                         iscsiuio.service \
"
SYSTEMD_AUTO_ENABLE = "disable"


#FILES:${PN}-dev += "${libdir}/libopeniscsiusr.so*" 
# systemd support
FILES:${PN} += " \
    ${systemd_system_unitdir}/iscsi.service \
    ${systemd_system_unitdir}/iscsid.socket \
    ${systemd_system_unitdir}/iscsiuio.socket \
    ${systemd_system_unitdir}/iscsid.service \
    ${systemd_system_unitdir}/iscsi-init.service \
    ${systemd_system_unitdir}/iscsiuio.service \
    ${systemd_unitdir}/system-generators/ibft-rule-generator \
"
