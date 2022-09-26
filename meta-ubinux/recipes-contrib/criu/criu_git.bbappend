FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "6128eb6185b4ca61b2ec4fabe3dc28565e7f643c"
PV = "3.17.1+git${SRCPV}"

SRC_URI = "git://github.com/checkpoint-restore/criu.git;branch=criu-dev;protocol=https \
           file://0001-criu-Skip-documentation-install.patch \
           file://0002-criu-Change-libraries-install-directory.patch \
           file://0003-lib-Makefile-overwrite-install-lib-to-allow-multiarc.patch \
           "
do_install () {
    export INSTALL_LIB="${libdir}/${PYTHON_DIR}/site-packages"
    oe_runmake PREFIX=${exec_prefix} LIBDIR=${libdir} DESTDIR="${D}" PLUGINDIR="${localstatedir}/lib" FULL_PYTHON=${PYTHON} PYTHON=python3 install

    # python3's distutils has a feature of rewriting the interpeter on setup installed
    # scripts. 'crit' is one of those scripts. The "executable" or "e" option to the
    # setup call should fix it, but it is being ignored. So to avoid getting our native
    # intepreter replaced in the script, we'll do an explicit update ourselves.
    sed -i 's%^\#\!.*%\#\!/usr/bin/env python3%' ${D}/usr/bin/crit ${D}${libdir}/python3*/site-packages/crit-3.17-py3*.egg/EGG-INFO/scripts/crit
}

INSANE_SKIP_${PN} += "textrel"
