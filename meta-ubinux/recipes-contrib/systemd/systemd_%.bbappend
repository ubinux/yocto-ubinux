pkg_postinst:udev-hwdb () {
        if test -n "$D"; then
                $INTERCEPT_DIR/postinst_intercept update_udev_hwdb ${PKG} mlprefix=${MLPREFIX} binprefix=${MLPREFIX} rootlibexecdir="${rootlibexecdir}" base_bindir="${base_bindir}" PREFERRED_PROVIDER_udev="${PREFERRED_PROVIDER_udev}"
        else
                udevadm hwdb --update
        fi
}

