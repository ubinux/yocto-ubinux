SUMMARY = "User interface to Ftrace"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=873f48a813bded3de6ebc54e6880c4ac \
                    file://tracecmd/trace-cmd.c;beginline=6;endline=8;md5=b666ac82dd0a42eacc166bd21279e62c \
                    file://COPYING.LIB;md5=edb195fe538e4552c1f6ca0fd7bf4f0a \
                    file://lib/trace-cmd/trace-input.c;beginline=5;endine=8;md5=74329baf7476864ad5337f13e20549e9"

DEPENDS = "swig-native"

SRCREV = "530b1a0caef39466e16bbd49de5afef89656f03f"
PV = "2.9.1"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/rostedt/trace-cmd.git"

S = "${WORKDIR}/git"

do_install() {
    ${MAKE} NO_PYTHON=1 prefix=${prefix} plugin_traceevent_dir=${libdir}/trace-cmd/plugins DESTDIR=${D} install
}

FILES_${PN} += "${prefix}/etc/"
FILES_${PN} += "${libdir}/traceevent/plugins/"
FILES_${PN}-dbg += "${libdir}/trace-cmd/plugins/.debug/"
