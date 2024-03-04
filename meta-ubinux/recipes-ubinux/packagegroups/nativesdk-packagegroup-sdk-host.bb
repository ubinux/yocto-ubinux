#
# Copyright (C) 2007 OpenedHand Ltd
#

SUMMARY = "Host packages for the standalone SDK or external toolchain"
PR = "r12"
PACKAGE_ARCH = "${TUNE_PKGARCH}"
inherit packagegroup nativesdk

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

# autoconf pulls in nativesdk-perl but perl-module-integer is needed to 
# build some recent linux kernels (5.14+) for arm
RDEPENDS:${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-qemu-xilinx \
    nativesdk-qemu-xilinx-user-aarch64 \
    nativesdk-qemu-xilinx-user-arm \
    nativesdk-qemu-xilinx-user-x86-64 \
    nativesdk-qemu-xilinx-user-i386 \
    nativesdk-qemu-xilinx-user-microblazeel \
    nativesdk-qemu-xilinx-user-microblaze \
    nativesdk-qemu-xilinx-common \
    nativesdk-qemu-xilinx-guest-agent \
    nativesdk-qemu-xilinx-system-aarch64 \
    nativesdk-qemu-xilinx-system-arm \
    nativesdk-qemu-xilinx-system-i386 \
    nativesdk-qemu-xilinx-system-x86-64 \
    nativesdk-qemu-xilinx-system-microblaze \
    nativesdk-qemu-xilinx-system-microblazeel \
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
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'nativesdk-wayland-tools nativesdk-wayland-dev', '', d)} \
    nativesdk-sdk-provides-dummy \
    nativesdk-bison \
    nativesdk-flex \
    nativesdk-perl-module-integer \
    "

RDEPENDS:${PN}:darwin = "\
    nativesdk-pkgconfig \
    nativesdk-opkg \
    nativesdk-libtool \
    "

RDEPENDS:${PN} += "nativesdk-libnewt-python \
    nativesdk-createrepo-c \
    nativesdk-libxml2 \
    nativesdk-libxml2-python \
    nativesdk-dnf-plugin-tui \
    nativesdk-e2fsprogs \
    nativesdk-gpgme \
    nativesdk-update-rc.d \
    nativesdk-systemd-systemctl \
    nativesdk-gdk-pixbuf \
    "
