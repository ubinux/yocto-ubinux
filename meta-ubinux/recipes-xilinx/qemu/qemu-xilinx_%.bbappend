QEMU_TARGETS += " i386 "
do_install:append() {
    # ELF binary /usr/share/qemu/s390-netboot.img has relocations in .text
    rm ${D}${datadir}/qemu-xilinx/s390-netboot.img -f
    # ELF binary /usr/share/qemu/s390-ccw.img has relocations in .text [textrel]
    rm ${D}${datadir}/qemu-xilinx/s390-ccw.img -f
}
