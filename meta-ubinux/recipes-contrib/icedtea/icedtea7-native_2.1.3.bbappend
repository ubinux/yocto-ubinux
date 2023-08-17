FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"


SRC_URI += " \
        file://0001-Fix-build-error-with-gcc-13.2.0.patch;apply=no \
	file://0001-Fix-build-error-with-gcc-13.2.0-openjdk.patch;apply=no \
	file://0001-Fix-build-error-of-jni.cpp.patch;apply=no \
	file://0001-Fix-build-error-of-jni.cpp-openjdk.patch;apply=no \
"


EXTRA_OEMAKE:append = " LDD=:"

do_configure:append() {
        patch -p1 < ${WORKDIR}/0001-Fix-build-error-with-gcc-13.2.0.patch
	patch -p1 < ${WORKDIR}/0001-Fix-build-error-with-gcc-13.2.0-openjdk.patch
	patch -p1 < ${WORKDIR}/0001-Fix-build-error-of-jni.cpp.patch
	patch -p1 < ${WORKDIR}/0001-Fix-build-error-of-jni.cpp-openjdk.patch
}

