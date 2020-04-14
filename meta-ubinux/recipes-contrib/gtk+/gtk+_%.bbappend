FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_class-native = "file://0001-Disable-demo.patch"

RRECOMMENDS_${PN}_class-native = ""

BBCLASSEXTEND += "native"

