require xorg-driver-input.inc

SUMMARY = "X.Org X server -- synaptics touchpad input driver"

DESCRIPTION = "synaptics is an Xorg input driver for the touchpads from \
Synaptics Incorporated. Even though these touchpads (by default, \
operating in a compatibility mode emulating a standard mouse) can be \
handled by the normal evdev or mouse drivers, this driver allows more \
advanced features of the touchpad to become available."

LIC_FILES_CHKSUM = "file://COPYING;md5=55aacd3535a741824955c5eb8f061398"

SRC_URI[sha256sum] = "b8fa4aab913fc63754bbd6439e020658c412743a055201ddf212760593962c38"

DEPENDS += "libxi mtdev libxtst libevdev"

XORG_DRIVER_COMPRESSOR = ".tar.xz"
