do_install_append () {
        # Prevent QA warnings about installed ${localstatedir}/run
        if [ -d ${D}${localstatedir}/run ]; then
                rm -rf ${D}${localstatedir}/run
        fi
}
