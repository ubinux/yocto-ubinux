SRCREV = "bac88927b253cdcfe0d06ac7dc5afb876cd2d996"
DEPENDS:append:class-nativesdk = " file-replacement-nativesdk"

do_install:append() {
    install -d -p ${D}/${SDKPATH}/postinst-intercepts
    cp -r ${COREBASE}/scripts/postinst-intercepts/* ${D}/${SDKPATH}/postinst-intercepts/
    sed -i -e 's/STAGING_DIR_NATIVE/NATIVE_ROOT/g' ${D}/${SDKPATH}/postinst-intercepts/*
}
FILES:${PN} += "${SDKPATH}/postinst-intercepts"
