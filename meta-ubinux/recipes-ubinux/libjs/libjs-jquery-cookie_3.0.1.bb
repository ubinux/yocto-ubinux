SUMMARY = "JavaScript Cookie"
DESCRIPTION = "A simple, lightweight JavaScript API for handling cookies"

HOMEPAGE = "https://github.com/js-cookie/js-cookie"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://js.cookie.js;md5=e5054597c36e96dea8b5ae4ae941fb7a"

SRC_URI = " \
           https://github.com/js-cookie/js-cookie/releases/download/v3.0.1/js.cookie.js;md5sum=e5054597c36e96dea8b5ae4ae941fb7a \
           https://github.com/js-cookie/js-cookie/releases/download/v3.0.1/js.cookie.min.js;md5sum=511390c6668bb8cb2c65b03dc65cf6de \
           https://github.com/js-cookie/js-cookie/releases/download/v3.0.1/js.cookie.min.mjs;md5sum=24632392dabf5bf2caf9f80dedac13ed \
           https://github.com/js-cookie/js-cookie/releases/download/v3.0.1/js.cookie.mjs;md5sum=397b8e10308ea44fce62c657c024a41d \
           "
S = "${WORKDIR}"
do_install() {
	install -d ${D}${datadir}/javascript/jquery-cookie
	install -m 0644 ${WORKDIR}/js.cookie.js ${D}${datadir}/javascript/jquery-cookie/
	install -m 0644 ${WORKDIR}/js.cookie.min.js ${D}${datadir}/javascript/jquery-cookie/
	install -m 0644 ${WORKDIR}/js.cookie.min.mjs ${D}${datadir}/javascript/jquery-cookie/
	install -m 0644 ${WORKDIR}/js.cookie.mjs ${D}${datadir}/javascript/jquery-cookie/
}

FILES:${PN} += "${datadir}/javascript/jquery-cookie"

