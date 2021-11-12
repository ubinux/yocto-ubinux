FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:class-nativesdk = "\
    file://0001-The-rpm-has-been-updated-and-the-name-of-the-databas.patch \
"

