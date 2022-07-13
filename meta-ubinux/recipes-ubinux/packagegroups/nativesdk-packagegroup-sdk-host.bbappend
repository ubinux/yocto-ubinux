PACKAGE_ARCH = "${SDK_ARCH}-${SDKPKGSUFFIX}"


RDEPENDS:${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-qemu-xilinx \
    nativesdk-qemu-helper \
    nativesdk-pseudo \
    nativesdk-unfs3 \
    nativesdk-opkg \
    nativesdk-libtool \
    nativesdk-autoconf \
    nativesdk-automake \
    nativesdk-shadow \
    nativesdk-makedevs \
    nativesdk-cmake \
    nativesdk-meson \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'nativesdk-wayland', '', d)} \
    nativesdk-sdk-provides-dummy \
    nativesdk-bison \
    nativesdk-flex \
    nativesdk-perl-module-integer \
    "
RDEPENDS:${PN} += "nativesdk-libnewt-python \
                   nativesdk-createrepo-c \
                   nativesdk-libxml2 \
                   nativesdk-libxml2-python \
		   nativesdk-dnf-plugin-tui \
		   nativesdk-e2fsprogs \
		   nativesdk-gpgme \
		   nativesdk-update-rc.d \
                   nativesdk-gdk-pixbuf \
		   "
