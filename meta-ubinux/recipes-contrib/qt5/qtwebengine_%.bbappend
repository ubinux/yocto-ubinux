FILESEXTRAPATHS:prepend := "${THISDIR}/qtwebengine:"

SRC_URI += "file://Fix_build_error_with_ninja1.12.patch \
            file://chromium/0001-Fix-no-module-named-imp-error-on-ubuntu24.04-with-py.patch;patchdir=src/3rdparty/chromium/ \
            file://chromium/0002-Fix-No-module-named-six.moves-error-on-ubuntu-24.04-.patch;patchdir=src/3rdparty/chromium/ \
            file://chromium/0002-python_message.py-Fix-No-module-named-six.moves-on-u.patch;patchdir=src/3rdparty/chromium/ "

