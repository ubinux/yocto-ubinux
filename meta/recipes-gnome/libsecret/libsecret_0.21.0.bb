SUMMARY = "libsecret is a library for storing and retrieving passwords and other secrets"
DESCRIPTION = "A GObject-based library for accessing the Secret Service API of \
the freedesktop.org project, a cross-desktop effort to access passwords, \
tokens and other types of secrets. libsecret provides a convenient wrapper \
for these methods so consumers do not have to call the low-level DBus methods."
LICENSE = "LGPL-2.1-only"
HOMEPAGE = "https://github.com/GNOME/libsecret"
BUGTRACKER = "https://gitlab.gnome.org/GNOME/libsecret/issues"
LIC_FILES_CHKSUM = "file://COPYING;md5=23c2a5e0106b99d75238986559bb5fc6"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase gi-docgen vala gobject-introspection manpages

DEPENDS += "glib-2.0 libgcrypt gettext-native"

SRC_URI[archive.sha256sum] = "2735b29d1cc0e5b12ba90bee88bd21774ac8db4ae1a4b716f46c409c19a14613"

GTKDOC_MESON_OPTION = 'gtk_doc'

PACKAGECONFIG[manpages] = "-Dmanpage=true,-Dmanpage=false,libxslt-native xmlto-native"

# http://errors.yoctoproject.org/Errors/Details/20228/
ARM_INSTRUCTION_SET:armv4 = "arm"
ARM_INSTRUCTION_SET:armv5 = "arm"
ARM_INSTRUCTION_SET:armv6 = "arm"
