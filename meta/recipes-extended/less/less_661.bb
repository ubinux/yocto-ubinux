SUMMARY = "Text file viewer similar to more"
DESCRIPTION = "Less is a program similar to more, i.e. a terminal \
based program for viewing text files and the output from other \
programs. Less offers many features beyond those that more does."
HOMEPAGE = "http://www.greenwoodsoftware.com/"
SECTION = "console/utils"

# (GPL-2.0-or-later (<< 418), GPL-3.0-or-later (>= 418)) | less
# Including email author giving permissing to use BSD
#
# From: Mark Nudelman <markn@greenwoodsoftware.com>
# To: Elizabeth Flanagan <elizabeth.flanagan@intel.com
# Date: 12/19/11
#
# Hi Elizabeth,
# Using a generic BSD license for less is fine with me.
# Thanks,
#
# --Mark
#

LICENSE = "GPL-3.0-or-later | BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://LICENSE;md5=ea7ea443692720f3015859945c0fb65d \
                    "
DEPENDS = "ncurses"

SRC_URI = "http://www.greenwoodsoftware.com/${BPN}/${BPN}-${PV}.tar.gz \
           file://run-ptest \
           "

SRC_URI[sha256sum] = "2b5f0167216e3ef0ffcb0c31c374e287eb035e4e223d5dae315c2783b6e738ed"

UPSTREAM_CHECK_URI = "http://www.greenwoodsoftware.com/less/download.html"

inherit autotools ptest update-alternatives

EXTRA_OEMAKE += " LESSTEST=1"

inherit autotools update-alternatives

do_compile_ptest () {
        cd ${S}/lesstest
        oe_runmake
}

do_install () {
        oe_runmake 'bindir=${D}${bindir}' 'mandir=${D}${mandir}' install
}

do_install_ptest () {
        cp ${S}/lesstest/lesstest ${D}${PTEST_PATH}
        cp ${S}/lesstest/runtest ${D}${PTEST_PATH}
        cp ${S}/lesstest/lt_screen ${D}${PTEST_PATH}
        cp -r ${S}/lesstest/lt ${D}${PTEST_PATH}
}

RDEPENDS:${PN}-ptest:append = " perl-module-getopt-std perl-module-cwd perl-module-file-basename locale-base-en-us"

ALTERNATIVE:${PN} = "less"
ALTERNATIVE_PRIORITY = "100"
