do_install_append () {
        # Prevent QA warnings about installed ${localstatedir}/run
        if [ -d ${D}${localstatedir}/lock ]; then
                rm -rf ${D}${localstatedir}/lock
        fi
}

