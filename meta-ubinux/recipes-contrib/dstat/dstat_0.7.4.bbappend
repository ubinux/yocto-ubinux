FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = "\
                  file://0001-change-dstat-to-python3.patch"

