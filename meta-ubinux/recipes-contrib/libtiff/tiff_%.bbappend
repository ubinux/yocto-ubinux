FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "http://download.osgeo.org/libtiff/tiff-${PV}.tar.gz \
           file://CVE-2019-6128.patch \
           file://CVE-2019-7663-porting.patch \
           file://CVE-2019-14973.patch \
"

