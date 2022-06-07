FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "\
    file://0001-postinst-intercepts-Fix-the-directory-name-and-path.patch \
"

do_install:append() {
    install -d -p ${D}/${SDKPATH}/postinst-intercepts
    cp -r ${COREBASE}/scripts/postinst-intercepts/* ${D}/${SDKPATH}/postinst-intercepts/
}
FILES:${PN} += "${SDKPATH}/postinst-intercepts"
