FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "file://0001-Install-static-lib-into-var-libdir-rather-than-hardc.patch"
