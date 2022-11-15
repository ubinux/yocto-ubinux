#inherit kernel qoriq_build_64bit_kernel siteinfo
inherit fsl-kernel-localversion

SUMMARY = "Linux Kernel for NXP QorIQ platforms"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

#require recipes-kernel/linux/linux-yocto.inc

# Pick up shared functions
inherit kernel
inherit kernel-yocto
inherit pkgconfig
inherit qoriq_build_64bit_kernel siteinfo
# board specific branches
KBRANCH:ubinux-armv8  ?= "v5.15/standard/nxp-sdk-5.15/nxp-soc"

SRCREV = "aba3eb2ce023befdd3b86cae6a2be97e272df7b1"

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;name=machine;branch=${KBRANCH}; \
           file://ubinux_defconfig \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
LINUX_VERSION ?= "5.15.72"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"
DEPENDS += "gmp-native libmpc-native"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "1"

DEPENDS:append = " libgcc"
# not put Images into /boot of rootfs, install kernel-image if needed
RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""

KERNEL_CC:append = " ${TOOLCHAIN_OPTIONS}"
KERNEL_LD:append = " ${TOOLCHAIN_OPTIONS}"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

COMPATIBLE_MACHINE = "^(ubinux-armv8|ubinux-x86-64)$"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"
KERNEL_FEATURES:append = " ${KERNEL_EXTRA_FEATURES}"
KERNEL_FEATURES:append:qemuall=" cfg/virtio.scc features/drm-bochs/drm-bochs.scc"
KERNEL_FEATURES:append:ubinux-x86-64=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES:append:ubinux-armv8 =" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES:append = " ${@bb.utils.contains("TUNE_FEATURES", "mx32", " cfg/x32.scc", "", d)}"
KERNEL_FEATURES:append = " ${@bb.utils.contains("DISTRO_FEATURES", "ptest", " features/scsi/scsi-debug.scc", "", d)}"
KERNEL_FEATURES:append = " ${@bb.utils.contains("DISTRO_FEATURES", "ptest", " features/gpio/mockup.scc", "", d)}"

ZIMAGE_BASE_NAME = "zImage-${PKGE}-${PKGV}-${PKGR}-${MACHINE}-${DATETIME}"
ZIMAGE_BASE_NAME[vardepsexclude] = "DATETIME"

SCMVERSION ?= "y"
LOCALVERSION = ""
DELTA_KERNEL_DEFCONFIG = "ubinux_defconfig "
do_merge_delta_config[depends] += "virtual/${TARGET_PREFIX}gcc:do_populate_sysroot bison-native:do_populate_sysroot"
do_merge_delta_config[dirs] = "${B}"

#do_merge_delta_config() {
#    cp  ${WORKDIR}/ubinux_defconfig ${WORKDIR}/defconfig
#}
#addtask merge_delta_config before do_kernel_localversion after do_patch

do_merge_delta_config() {
    # create config with make config
    cp ${WORKDIR}/${DELTA_KERNEL_DEFCONFIG} ${S}/arch/${ARCH}/configs/
    oe_runmake  -C ${S} O=${B} ${KERNEL_DEFCONFIG}

    # check if bigendian is enabled
    if [ "${SITEINFO_ENDIANNESS}" = "be" ]; then
        echo "CONFIG_CPU_BIG_ENDIAN=y" >> .config
        echo "CONFIG_MTD_CFI_BE_BYTE_SWAP=y" >> .config
    fi

    # add config fragments
    for deltacfg in ${DELTA_KERNEL_DEFCONFIG}; do
        if [ -f ${S}/arch/${ARCH}/configs/${deltacfg} ]; then
            oe_runmake  -C ${S} O=${B} ${deltacfg}
        elif [ -f "${WORKDIR}/${deltacfg}" ]; then
            ${S}/scripts/kconfig/merge_config.sh -m .config ${WORKDIR}/${deltacfg}
        elif [ -f "${deltacfg}" ]; then
            ${S}/scripts/kconfig/merge_config.sh -m .config ${deltacfg}
        fi
    done
    cp .config ${WORKDIR}/defconfig
}
addtask merge_delta_config before do_kernel_localversion after do_patch

FILES_${KERNEL_PACKAGE_NAME}-image += "/boot/zImage*"
COMPATIBLE_MACHINE = "(qoriq)"
deltask kernel_version_sanity_check do_kernel_metadata kernel_configme do_kernel_configcheck
