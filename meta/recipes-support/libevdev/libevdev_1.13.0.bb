SUMMARY = "Wrapper library for evdev devices"
DESCRIPTION = "A library for handling evdev kernel devices. It abstracts \
the evdev ioctls through type-safe interfaces and provides functions \
to change the appearance of the device."
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/libevdev/"
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=80c550b3197bcb8da7d7557ebcc3fc46 \
                    "

SRC_URI = "http://www.freedesktop.org/software/libevdev/${BP}.tar.xz"
SRC_URI[sha256sum] = "9edf2006cc86a5055279647c38ec923d11a821ee4dc2c3033e8d20e8ee237cd9"

inherit autotools pkgconfig

UPSTREAM_CHECK_REGEX = "libevdev-(?P<pver>(\d+\.)+(?!90\d+)\d+)"
