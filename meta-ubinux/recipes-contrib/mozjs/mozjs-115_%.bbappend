FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:i686 = "\
    file://0001-Fix-build-error-when-enable-multilib-on-x86-64.patch \
"
