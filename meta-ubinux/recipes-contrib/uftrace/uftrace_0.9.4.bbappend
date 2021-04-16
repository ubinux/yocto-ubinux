FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_class-native = "file://0001-Fix-bug-of-runtime-on-aarch64.patch"

