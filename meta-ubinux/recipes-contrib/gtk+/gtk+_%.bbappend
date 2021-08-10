FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:class-native = "file://0001-Disable-demo.patch"

RRECOMMENDS_${PN}:class-native = ""

BBCLASSEXTEND += "native"

