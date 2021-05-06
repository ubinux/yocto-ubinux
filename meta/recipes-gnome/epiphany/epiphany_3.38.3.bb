SUMMARY = "WebKit based web browser for GNOME"
DESCRIPTION = "Epiphany is an open source web browser for the Linux desktop environment. \
It provides a simple and easy-to-use internet browsing experience."
HOMEPAGE = "https://wiki.gnome.org/Apps/Web"
BUGTRACKER = "https://gitlab.gnome.org/GNOME/epiphany"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "libsoup-2.4 webkitgtk gtk+3 iso-codes avahi libnotify gcr gnutls \
	   gsettings-desktop-schemas libxml2-native \
	   glib-2.0 glib-2.0-native json-glib libdazzle libhandy libportal"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase gsettings features_check upstream-version-is-even gettext mime-xdg
REQUIRED_DISTRO_FEATURES = "x11 opengl"

SRC_URI = "${GNOME_MIRROR}/${GNOMEBN}/${@gnome_verdir("${PV}")}/${GNOMEBN}-${PV}.tar.${GNOME_COMPRESS_TYPE};name=archive \
           file://0002-help-meson.build-disable-the-use-of-yelp.patch \
           file://migrator.patch \
           file://distributor.patch \
           "
SRC_URI[archive.sha256sum] = "ce62c1fa3e442a9d6131fc884a6bc9a65cf06224c30d649c49624c2ebcb0d275"

# Developer mode enables debugging
PACKAGECONFIG[developer-mode] = "-Ddeveloper_mode=true,-Ddeveloper_mode=false"

FILES_${PN} += "${datadir}/dbus-1 ${datadir}/gnome-shell/search-providers ${datadir}/metainfo"
RDEPENDS_${PN} = "iso-codes adwaita-icon-theme gsettings-desktop-schemas"
