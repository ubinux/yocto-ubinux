SUMMARY = "Generic XKB keymap library"
DESCRIPTION = "libxkbcommon is a keymap compiler and support library which \
processes a reduced subset of keymaps as defined by the XKB specification."
HOMEPAGE = "http://www.xkbcommon.org"
LIC_FILES_CHKSUM = "file://LICENSE;md5=70eff33050c59f900f5b83275dcf1211"
LICENSE = "MIT & MIT-open-group & HPND & HPND-sell-variant & X11"

DEPENDS = "flex-native bison-native"

SRC_URI = "git://github.com/xkbcommon/libxkbcommon;protocol=https;branch=master"

SRCREV = "b3465081878e80ca6c11fe35c81787ec374ec15a"
S = "${WORKDIR}/git"

inherit meson pkgconfig bash-completion

PACKAGECONFIG ?= "${@bb.utils.filter('DISTRO_FEATURES', 'x11 wayland', d)} xkbregistry"

PACKAGECONFIG[docs] = "-Denable-docs=true,-Denable-docs=false,doxygen-native"
PACKAGECONFIG[wayland] = "-Denable-wayland=true,-Denable-wayland=false,wayland-native wayland wayland-protocols,"
PACKAGECONFIG[x11] = "-Denable-x11=true,-Denable-x11=false,libxcb xkeyboard-config,"
PACKAGECONFIG[xkbregistry] = "-Denable-xkbregistry=true,-Denable-xkbregistry=false,libxml2"

PACKAGE_BEFORE_PN += "xkbcli"
FILES:${PN} = ""
FILES:xkbcli = "${bindir}/xkbcli ${libexecdir}/xkbcommon/xkbcli-*"

python populate_packages:prepend () {
    # Put the libraries into separate packages to avoid dependency creep
    do_split_packages(d, d.expand('${libdir}'), r'^(lib.*)\.so\.*', '%s', '%s library', extra_depends='', allow_links=True)
}

# Recommended to fix a possible runtime error:
# xkbcommon: ERROR: couldn't find a Compose file for locale "C"
RRECOMMENDS:${PN} = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'libx11-locale', 'libx11-compose-data', d)}"

BBCLASSEXTEND += "native"

CVE_PRODUCT += "xkbcommon:libxkbcommon"
