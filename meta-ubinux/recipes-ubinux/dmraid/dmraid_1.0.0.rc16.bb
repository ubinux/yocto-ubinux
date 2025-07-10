SUMMARY = "dmraid (Device-mapper RAID tool and library)"
DESCRIPTION = "DMRAID supports RAID device discovery, RAID set activation, \
creation, removal, rebuild and display of properties for ATARAID/DDF1 \
metadata on Linux >= 2.4 using device-mapper."
HOMEPAGE = "http://people.redhat.com/heinzm/sw/dmraid"
SECTION = "System Environment/Base"

inherit autotools-brokensep

SRC_URI = "http://people.redhat.com/heinzm/sw/dmraid/src/old/${BPN}-${PV}.tar.bz2 \
           file://01_fix_broken_linking.patch \
           file://04_promise-add-offsets.patch \
           file://05_exit_code.patch \
           file://06_support_virtio_devices.patch \
           file://07_isw-probe-hpa.patch \
           file://08_activate_multiple_raid_sets.patch \
           file://09_pdc_raid10_failure..patch \
           file://10_ddf1_lsi_persistent_name.patch \
           file://11_fix_isw_sectors_calculation.patch \
           file://12_jmicron_namefix.patch \
           file://13_fix_testing.patch \
           file://14_pdc_dump_extended_metadata.patch \
           file://15_drop_p_for_partition_conditional.patch \
           file://16_change-uuid.patch \
           file://17_convert-dmraid45-to-dmraid.patch \
           file://18_ignore-too-small-devices.patch \
           file://19_compile-dmraid-in-subdir-tools.patch \
           file://20_specifies-install-dir-by-DESTDIR.patch \
          "

SRC_URI[md5sum] = "32832c1dfd7e72cd4355490322fca68a"
SRC_URI[sha256sum] = "f849c44d041f8891c61419ddf906e6e34b44948939ae9e550be662ffc2492255"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=15b3012575eeffacc3cec27a6d3cb31f"

DEPENDS = "lvm2"

S = "${UNPACKDIR}/${BPN}/${PV}"

EXTRA_OECONF += " --disable-static_link --enable-led --enable-intel_led --enable-debug  "

do_configure() {
    oe_runconf
}

do_compile() {
    oe_runmake DESTDIR=${D}
}

do_install() {
    oe_runmake DESTDIR=${D} install
}
