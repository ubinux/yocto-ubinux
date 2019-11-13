FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "file://0001-double-conversion-support-arm-BE.patch \
        file://0001-Fix-build-error-fir-BE.patch \
"

