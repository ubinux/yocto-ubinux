SUMMARY = "Start the program if the specified terminal device is available."
DESCRIPTION = "ttyrun is typically used to prevent a respawn through the \
init(8) program when a terminal is not available."
HOMEPAGE = "https://github.com/ibm-s390-linux/s390-tools"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f5118f167b055bfd7c3450803f1847af"

SRC_URI = "git://github.com/ibm-s390-linux/s390-tools;protocol=https;branch=master"
SRCREV = "d9ce54dee3ac3827e76624352293a83eb05c727e"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "\
    V=1 \
    CC="${CC}" \
    DISTRELEASE=${PR} \
    "

# We just want ttyrun and not the rest of s390-utils

do_configure() {
    oe_runmake -C ${S}/iucvterm/src clean
}

do_compile() {
    oe_runmake -C ${S}/iucvterm/src ttyrun
}

do_install() {
    install -d ${D}${sbindir}
    install ${S}/iucvterm/src/ttyrun ${D}${sbindir}
}
