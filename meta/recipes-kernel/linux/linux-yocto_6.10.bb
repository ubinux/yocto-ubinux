KBRANCH ?= "v6.10/standard/base"

require recipes-kernel/linux/linux-yocto.inc

# CVE exclusions
include recipes-kernel/linux/cve-exclusion.inc
include recipes-kernel/linux/cve-exclusion_6.10.inc

# board specific branches
KBRANCH:qemuarm  ?= "v6.10/standard/arm-versatile-926ejs"
KBRANCH:qemuarm64 ?= "v6.10/standard/qemuarm64"
KBRANCH:qemumips ?= "v6.10/standard/mti-malta32"
KBRANCH:qemuppc  ?= "v6.10/standard/qemuppc"
KBRANCH:qemuriscv64  ?= "v6.10/standard/base"
KBRANCH:qemuriscv32  ?= "v6.10/standard/base"
KBRANCH:qemux86  ?= "v6.10/standard/base"
KBRANCH:qemux86.104 ?= "v6.10/standard/base"
KBRANCH:qemuloongarch64  ?= "v6.10/standard/base"
KBRANCH:qemumips64 ?= "v6.10/standard/mti-malta64"

SRCREV_machine:qemuarm ?= "4562f66c12f660d40de2c8dc2b53f851ba1d7847"
SRCREV_machine:qemuarm64 ?= "92466d9d49ed65d9a13f2ab648a92becc027a257"
SRCREV_machine:qemuloongarch64 ?= "92466d9d49ed65d9a13f2ab648a92becc027a257"
SRCREV_machine:qemumips ?= "8ef41c4428d1eb040edbae58b685bcba6472ab9b"
SRCREV_machine:qemuppc ?= "92466d9d49ed65d9a13f2ab648a92becc027a257"
SRCREV_machine:qemuriscv64 ?= "92466d9d49ed65d9a13f2ab648a92becc027a257"
SRCREV_machine:qemuriscv32 ?= "92466d9d49ed65d9a13f2ab648a92becc027a257"
SRCREV_machine:qemux86 ?= "92466d9d49ed65d9a13f2ab648a92becc027a257"
SRCREV_machine:qemux86-64 ?= "92466d9d49ed65d9a13f2ab648a92becc027a257"
SRCREV_machine:qemumips64 ?= "c1f8e21e4999d233df12ee60c7a47cad144e7344"
SRCREV_machine ?= "92466d9d49ed65d9a13f2ab648a92becc027a257"
SRCREV_meta ?= "9e63c08171dc88ed8a5ed8ecc4b508465ea75352"

# set your preferred provider of linux-yocto to 'linux-yocto-upstream', and you'll
# get the <version>/base branch, which is pure upstream -stable, and the same
# meta SRCREV as the linux-yocto-standard builds. Select your version using the
# normal PREFERRED_VERSION settings.
BBCLASSEXTEND = "devupstream:target"
SRCREV_machine:class-devupstream ?= "d29de02effd4e8816333582ed8230d41e14a73dc"
PN:class-devupstream = "linux-yocto-upstream"
KBRANCH:class-devupstream = "v6.10/base"

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;name=machine;branch=${KBRANCH};protocol=https \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.10;destsuffix=${KMETA};protocol=https"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
LINUX_VERSION ?= "6.10.3"

PV = "${LINUX_VERSION}+git"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "1"

KERNEL_DEVICETREE:qemuarmv5 = "arm/versatile-pb.dtb"

COMPATIBLE_MACHINE = "^(qemuarm|qemuarmv5|qemuarm64|qemux86|qemuppc|qemuppc64|qemumips|qemumips64|qemux86-64|qemuriscv64|qemuriscv32|qemuloongarch64)$"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"
KERNEL_FEATURES:append = " ${KERNEL_EXTRA_FEATURES}"
KERNEL_FEATURES:append:qemuall=" cfg/virtio.scc features/drm-bochs/drm-bochs.scc cfg/net/mdio.scc"
KERNEL_FEATURES:append:qemux86=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES:append:qemux86-64=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES:append = " ${@bb.utils.contains("TUNE_FEATURES", "mx32", " cfg/x32.scc", "", d)}"
KERNEL_FEATURES:append = " ${@bb.utils.contains("DISTRO_FEATURES", "ptest", " features/scsi/scsi-debug.scc features/nf_tables/nft_test.scc", "", d)}"
KERNEL_FEATURES:append = " ${@bb.utils.contains("DISTRO_FEATURES", "ptest", " features/gpio/mockup.scc features/gpio/sim.scc", "", d)}"
# libteam ptests from meta-oe needs it
KERNEL_FEATURES:append = " ${@bb.utils.contains("DISTRO_FEATURES", "ptest", " features/net/team/team.scc", "", d)}"
KERNEL_FEATURES:append:powerpc =" arch/powerpc/powerpc-debug.scc"
KERNEL_FEATURES:append:powerpc64 =" arch/powerpc/powerpc-debug.scc"
KERNEL_FEATURES:append:powerpc64le =" arch/powerpc/powerpc-debug.scc"

INSANE_SKIP:kernel-vmlinux:qemuppc64 = "textrel"
