FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
RDEPENDS:${PN} += " nativesdk-systemd-systemctl "

SRCREV = "f6ee3fa8fe6f3d7ca8d5b104aa73c1a5c938a403"

do_install:append() {
    install -d -p ${D}/${SDKPATH}/postinst-intercepts
    cp -r ${COREBASE}/scripts/postinst-intercepts/* ${D}/${SDKPATH}/postinst-intercepts/
}
FILES:${PN} += "${SDKPATH}/postinst-intercepts"
