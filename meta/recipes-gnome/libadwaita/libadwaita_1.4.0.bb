SUMMARY = "Building blocks for modern GNOME applications"
HOMEPAGE = "https://gitlab.gnome.org/GNOME/libadwaita"
LICENSE="LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

GNOMEBASEBUILDCLASS = "meson"

DEPENDS = " \
    gtk4 \
    appstream \
"

inherit gnomebase gobject-introspection gi-docgen vala features_check

SRC_URI[archive.sha256sum] = "e51a098a54d43568218fc48fcf52e80e36f469b3ce912d8ce9c308a37e9f47c2"

ANY_OF_DISTRO_FEATURES = "${GTK3DISTROFEATURES}"
REQUIRED_DISTRO_FEATURES = "opengl"

GIR_MESON_ENABLE_FLAG = 'enabled'
GIR_MESON_DISABLE_FLAG = 'disabled'
GTKDOC_MESON_OPTION = 'gtk_doc'

PACKAGECONFIG[examples] = "-Dexamples=true,-Dexamples=false"

FILES:${PN} += "${datadir}/metainfo"

EXTRA_OEMESON += "${@bb.utils.contains('GI_DATA_ENABLED', 'True', '-Dvapi=true', '-Dvapi=false', d)}"
