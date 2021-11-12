require qemu.inc
require qemu-xilinx.inc

BBCLASSEXTEND = "nativesdk"

RDEPENDS_${PN}:class-target += "bash"

PROVIDES:class-nativesdk = "nativesdk-qemu"
#RPROVIDES_${PN}:class-nativesdk = "nativesdk-qemu"
#RPROVIDES_${PN}:class-nativesdk = "nativesdk-qemu-src"

EXTRA_OECONF:append:class-target = " --target-list=${@get_qemu_target_list(d)}"
EXTRA_OECONF:append:class-nativesdk = " --target-list=${@get_qemu_target_list(d)}"

do_install:append:class-nativesdk() {
    ${@bb.utils.contains('PACKAGECONFIG', 'gtk+', 'make_qemu_wrapper', '', d)}
}
