FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "file://0001-Header-definitions-need-to-be-external-when-building.patch \
                 "
