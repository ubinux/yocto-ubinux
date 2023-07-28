SUMMARY = "GNU cpio is a program to manage archives of files"
DESCRIPTION = "GNU cpio is a tool for creating and extracting archives, or copying files from one place to \
another. It handles a number of cpio formats as well as reading and writing tar files."
HOMEPAGE = "http://www.gnu.org/software/cpio/"
SECTION = "base"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"

SRC_URI = "${GNU_MIRROR}/cpio/cpio-${PV}.tar.gz \
           file://0001-configure-Include-needed-header-for-major-minor-macr.patch \
           file://run-ptest \
           file://test.sh \
           "

SRC_URI[sha256sum] = "145a340fd9d55f0b84779a44a12d5f79d77c99663967f8cfa168d7905ca52454"

inherit autotools gettext texinfo ptest

CVE_STATUS[CVE-2010-4226] = "not-applicable-platform: Issue applies to use of cpio in SUSE/OBS"

EXTRA_OECONF += "DEFAULT_RMT_DIR=${sbindir}"

do_install () {
    autotools_do_install
    if [ "${base_bindir}" != "${bindir}" ]; then
        install -d ${D}${base_bindir}/
        mv "${D}${bindir}/cpio" "${D}${base_bindir}/cpio"
        if [ "${sbindir}" != "${bindir}" ]; then
            rmdir ${D}${bindir}/
        fi
    fi

    # Avoid conflicts with the version from tar
    mv "${D}${mandir}/man8/rmt.8" "${D}${mandir}/man8/rmt-cpio.8"
}

do_compile_ptest() {
    oe_runmake -C ${B}/gnu/ check
    oe_runmake -C ${B}/lib/ check
    oe_runmake -C ${B}/rmt/ check
    oe_runmake -C ${B}/src/ check
    oe_runmake -C ${B}/tests/ genfile
}

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests/
    sed -i "/abs_/d" ${B}/tests/atconfig
    install --mode=755 ${B}/tests/atconfig ${D}${PTEST_PATH}/tests/
    sed -i "s%${B}/tests:%%g" ${B}/tests/atlocal
    sed -i "s%${B}/src:%%g" ${B}/tests/atlocal
    install --mode=755 ${B}/tests/atlocal ${D}${PTEST_PATH}/tests/
    install --mode=755 ${B}/tests/genfile ${D}${PTEST_PATH}/tests/
    install --mode=755 ${S}/tests/testsuite ${D}${PTEST_PATH}/tests/
    install --mode=755 ${WORKDIR}/test.sh ${D}${PTEST_PATH}/test.sh
    sed -i "s#@PTEST_PATH@#${PTEST_PATH}#g" ${D}${PTEST_PATH}/test.sh
}

# ptest.bbclass currently chowns the ptest directory explicitly, so we need to
# change permission after that has happened so the ptest user can write a
# temporary directory.
do_install_ptest_base:append() {
    chgrp -R ptest ${D}${PTEST_PATH}/
    chmod -R g+w ${D}${PTEST_PATH}/
}

# The tests need to run as a non-root user, so pull in the ptest user
DEPENDS:append:class-target = "${@bb.utils.contains('PTEST_ENABLED', '1', ' ptest-runner', '', d)}"
PACKAGE_WRITE_DEPS:append:class-target = " ${MLPREFIX}ptest-runner"

RDEPENDS:${PN}-ptest += "ptest-runner"

PACKAGES =+ "${PN}-rmt"

FILES:${PN}-rmt = "${sbindir}/rmt*"

inherit update-alternatives

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE:${PN} = "cpio"
ALTERNATIVE:${PN}-rmt = "rmt"

ALTERNATIVE_LINK_NAME[cpio] = "${base_bindir}/cpio"

ALTERNATIVE_PRIORITY[rmt] = "50"
ALTERNATIVE_LINK_NAME[rmt] = "${sbindir}/rmt"

BBCLASSEXTEND = "native nativesdk"
