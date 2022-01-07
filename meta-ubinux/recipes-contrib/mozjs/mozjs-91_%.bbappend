FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:i686 = "\
    file://0001-www-firefox-fix-build-on-32bit.patch \
"
