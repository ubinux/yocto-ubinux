SUMMARY = "GTK+ icon theme"
DESCRIPTION = "The Adwaita icon theme is the default icon theme of the GNOME desktop \
This package package contains an icon theme for Gtk+ 3 applications."
HOMEPAGE = "https://gitlab.gnome.org/GNOME/adwaita-icon-theme"
BUGTRACKER = "https://gitlab.gnome.org/GNOME/adwaita-icon-theme/issues"
SECTION = "x11/gnome"

LICENSE = "LGPL-3.0-only | CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=c84cac88e46fc07647ea07e6c24eeb7c \
                    file://COPYING_CCBYSA3;md5=96143d33de3a79321b1006c4e8ed07e7 \
                    file://COPYING_LGPL;md5=e6a600fd5e1d9cbde2d983680233ad02"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase allarch gtk-icon-cache

SRC_URI[archive.sha256sum] = "2442bfb06f4e6cc95bf6e2682fdff98fa5eddc688751b9d6215c623cb4e42ff1"

DEPENDS += "librsvg-native"

PACKAGES =+ "${PN}-cursors ${PN}-symbolic"

RREPLACES:${PN} = "gnome-icon-theme"
RCONFLICTS:${PN} = "gnome-icon-theme"
RPROVIDES:${PN} = "gnome-icon-theme"

FILES:${PN}-cursors = "${datadir}/icons/Adwaita/cursors/"
FILES:${PN}-symbolic = "${datadir}/icons/Adwaita/symbolic*/"
FILES:${PN}-doc += "${datadir}/licenses/adwaita-icon-theme"

BBCLASSEXTEND = "native nativesdk"
