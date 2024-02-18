SUMMARY = "Tools to generate block map (AKA bmap) and flash images using bmap"
DESCRIPTION = "Bmap-tools - tools to generate block map (AKA bmap) and flash images using \
bmap. Bmaptool is a generic tool for creating the block map (bmap) for a file, \
and copying files using the block map. The idea is that large file containing \
unused blocks, like raw system image files, can be copied or flashed a lot \
faster with bmaptool than with traditional tools like "dd" or "cp"."
HOMEPAGE = "https://github.com/01org/bmap-tools"
SECTION = "console/utils"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI = "git://github.com/intel/${BPN};branch=main;protocol=https \
	file://0001-BmapCopy.py-fix-error-message.patch \
	file://0002-CLI.py-fix-block-device-udev-race-condition.patch \
	file://0003-BmapCopy.py-tweak-suggested-udev-rule.patch \
	"

SRCREV = "d84a6fd202fe246a0bc19ed2082e41bcdd75fb13"
S = "${WORKDIR}/git"
BASEVER = "3.7"
PV = "${BASEVER}+git"

UPSTREAM_CHECK_GITTAGREGEX = "v(?P<pver>\d+(\.\d+)+)"

# Need df from coreutils
RDEPENDS:${PN} = "python3-core python3-compression python3-misc python3-mmap python3-setuptools python3-fcntl python3-six coreutils"

inherit setuptools3

BBCLASSEXTEND = "native nativesdk"
