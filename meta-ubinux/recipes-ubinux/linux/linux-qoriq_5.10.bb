inherit kernel qoriq_build_64bit_kernel siteinfo
inherit fsl-kernel-localversion

SUMMARY = "Linux Kernel for NXP QorIQ platforms"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KERNEL_BRANCH ?= "linux-5.10"
KERNEL_SRC ?= "git://source.codeaurora.org/external/qoriq/qoriq-components/linux.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${KERNEL_BRANCH} \
           file://init_disassemble_info-signature-changes-causes-compile-failures.patch \
           "

SRCREV = "ef3f2cfc6010c13feb40cfb7fd7490832cf86f45"

S = "${WORKDIR}/git"

DEPENDS:append = " libgcc"
# not put Images into /boot of rootfs, install kernel-image if needed
RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""

KERNEL_CC:append = " ${TOOLCHAIN_OPTIONS}"
KERNEL_LD:append = " ${TOOLCHAIN_OPTIONS}"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

ZIMAGE_BASE_NAME = "zImage-${PKGE}-${PKGV}-${PKGR}-${MACHINE}-${DATETIME}"
ZIMAGE_BASE_NAME[vardepsexclude] = "DATETIME"

# Set the PV to the correct kernel version to satisfy the kernel version sanity check
LINUX_VERSION = "5.10.35"
PV = "${LINUX_VERSION}+git${SRCPV}"

SCMVERSION ?= "y"
LOCALVERSION = ""
DELTA_KERNEL_DEFCONFIG ?= ""
DELTA_KERNEL_DEFCONFIG:prepend:qoriq-arm64 = "lsdk.config "
DELTA_KERNEL_DEFCONFIG:prepend:qoriq-arm = "multi_v7_lpae.config lsdk.config "

do_merge_delta_config[depends] += "virtual/${TARGET_PREFIX}gcc:do_populate_sysroot bison-native:do_populate_sysroot"
do_merge_delta_config[dirs] = "${B}"

do_merge_delta_config() {
    # create config with make config
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
