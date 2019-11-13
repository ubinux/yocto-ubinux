FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
        file://0001-To-fix-build-error-on-arm32BE.patch \
        file://0001-Make-mozjs-support-aarch64_be.patch \
        "

