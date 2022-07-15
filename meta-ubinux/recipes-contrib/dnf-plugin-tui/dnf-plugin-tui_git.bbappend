FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "1e202f109a07ded81e4c7d4bbee9bc191cd03220"

do_install:append() {
    install -d -p ${D}/${SDKPATH}/postinst-intercepts
    cp -r ${COREBASE}/scripts/postinst-intercepts/* ${D}/${SDKPATH}/postinst-intercepts/
    sed -i -e 's/STAGING_DIR_NATIVE/NATIVE_ROOT/g' ${D}/${SDKPATH}/postinst-intercepts/*
}
FILES:${PN} += "${SDKPATH}/postinst-intercepts"
