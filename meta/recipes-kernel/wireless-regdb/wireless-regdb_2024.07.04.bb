SUMMARY = "Wireless Central Regulatory Domain Database"
HOMEPAGE = "https://wireless.wiki.kernel.org/en/developers/regulatory/crda"
SECTION = "net"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=07c4f6dea3845b02a18dc00c8c87699c"

SRC_URI = "https://www.kernel.org/pub/software/network/${BPN}/${BP}.tar.xz"
SRC_URI[sha256sum] = "9832a14e1be24abff7be30dee3c9a1afb5fdfcf475a0d91aafef039f8d85f5eb"

inherit bin_package allarch

do_install() {
    install -d -m0755 ${D}${nonarch_libdir}/crda
    install -d -m0755 ${D}${sysconfdir}/wireless-regdb/pubkeys
    install -m 0644 regulatory.bin ${D}${nonarch_libdir}/crda/regulatory.bin
    install -m 0644 wens.key.pub.pem ${D}${sysconfdir}/wireless-regdb/pubkeys/wens.key.pub.pem

    install -m 0644 -D regulatory.db ${D}${nonarch_base_libdir}/firmware/regulatory.db
    install -m 0644 regulatory.db.p7s ${D}${nonarch_base_libdir}/firmware/regulatory.db.p7s
}

# Install static regulatory DB in /lib/firmware for kernel to load.
# This requires Linux kernel >= v4.15.
# For kernel <= v4.14, inherit the kernel_wireless_regdb.bbclass
# (in meta-networking) in kernel's recipe.
PACKAGES = "${PN}-static ${PN}"
RCONFLICTS:${PN} = "${PN}-static"

FILES:${PN}-static = " \
    ${nonarch_base_libdir}/firmware/regulatory.db \
    ${nonarch_base_libdir}/firmware/regulatory.db.p7s \
"

# Native users might want to use the source of regulatory DB.
# This is for example used by Linux kernel <= v4.14 and
# kernel_wireless_regdb.bbclass in meta-networking.
do_install:append:class-native() {
    install -m 0644 -D db.txt ${D}${libdir}/crda/db.txt
}

RSUGGESTS:${PN} = "crda"

BBCLASSEXTEND = "native"
