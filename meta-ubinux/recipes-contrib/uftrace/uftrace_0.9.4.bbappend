FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "file://0001-Fix-error-on-aarch64-with-binutils-2.35.1.patch \
                  file://0001-Drop-old-bad-patch.patch "

