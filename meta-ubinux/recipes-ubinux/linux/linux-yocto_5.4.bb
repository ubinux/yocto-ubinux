KBRANCH ?= "v5.4/standard/base"

require recipes-kernel/linux/linux-yocto.inc

# board specific branches
KBRANCH:qemuarm  ?= "v5.4/standard/arm-versatile-926ejs"
KBRANCH:qemuarm64 ?= "v5.4/standard/qemuarm64"
KBRANCH:qemumips ?= "v5.4/standard/mti-malta32"
KBRANCH:qemuppc  ?= "v5.4/standard/qemuppc"
KBRANCH:qemuriscv64  ?= "v5.4/standard/base"
KBRANCH:qemux86  ?= "v5.4/standard/base"
KBRANCH:qemux86-64 ?= "v5.4/standard/base"
KBRANCH:qemumips64 ?= "v5.4/standard/mti-malta64"

SRCREV_machine:qemuarm ?= "7bbd138602fda3d69d74674460e73bffdec73cd2"
SRCREV_machine:qemuarm64 ?= "706efec4c1e270ec5dda92275898cd465dfdc7dd"
SRCREV_machine:qemumips ?= "e43ed1586cd85a007b0fae3c63d6980d4f5cb336"
SRCREV_machine:qemuppc ?= "706efec4c1e270ec5dda92275898cd465dfdc7dd"
SRCREV_machine:qemuriscv64 ?= "706efec4c1e270ec5dda92275898cd465dfdc7dd"
SRCREV_machine:qemux86 ?= "706efec4c1e270ec5dda92275898cd465dfdc7dd"
SRCREV_machine:qemux86-64 ?= "706efec4c1e270ec5dda92275898cd465dfdc7dd"
SRCREV_machine:qemumips64 ?= "d1ff96887c64f70de00add62eb91d4c36f1b181a"
SRCREV_machine ?= "706efec4c1e270ec5dda92275898cd465dfdc7dd"
SRCREV_meta ?= "83311f062f4aede9928eca82a34ddf73f264fe2a"

KBRANCH:genericx86  = "v5.4/standard/base"
KBRANCH:genericx86-64  = "v5.4/standard/base"
KBRANCH:edgerouter = "v5.4/standard/edgerouter"
KBRANCH:beaglebone-yocto = "v5.4/standard/beaglebone"

KMACHINE:genericx86 ?= "common-pc"
KMACHINE:genericx86-64 ?= "common-pc-64"
KMACHINE:beaglebone-yocto ?= "beaglebone"

SRCREV_machine:genericx86 ?= "9fc2fb2e73466a520ee9a3c48b3ca2f5b21415dc"
SRCREV_machine:genericx86-64 ?= "9fc2fb2e73466a520ee9a3c48b3ca2f5b21415dc"
SRCREV_machine:edgerouter ?= "9fc2fb2e73466a520ee9a3c48b3ca2f5b21415dc"
SRCREV_machine:beaglebone-yocto ?= "9fc2fb2e73466a520ee9a3c48b3ca2f5b21415dc"

COMPATIBLE_MACHINE:genericx86 = "genericx86"
COMPATIBLE_MACHINE:genericx86-64 = "genericx86-64"
COMPATIBLE_MACHINE:edgerouter = "edgerouter"
COMPATIBLE_MACHINE:beaglebone-yocto = "beaglebone-yocto"

LINUX_VERSION:genericx86 = "5.4.54"
LINUX_VERSION:genericx86-64 = "5.4.54"
LINUX_VERSION:edgerouter = "5.4.54"
LINUX_VERSION:beaglebone-yocto = "5.4.54"

# remap qemuarm to qemuarma15 for the 5.4 kernel
# KMACHINE_qemuarm ?= "qemuarma15"

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;name=machine;branch=${KBRANCH}; \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.4;destsuffix=${KMETA}"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
LINUX_VERSION ?= "5.4.58"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "1"

KERNEL_DEVICETREE:qemuarmv5 = "versatile-pb.dtb"

COMPATIBLE_MACHINE = "qemuarm|qemuarmv5|qemuarm64|qemux86|qemuppc|qemumips|qemumips64|qemux86-64|qemuriscv64"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"
KERNEL_FEATURES:append = " ${KERNEL_EXTRA_FEATURES}"
KERNEL_FEATURES:append:qemuall=" cfg/virtio.scc features/drm-bochs/drm-bochs.scc"
KERNEL_FEATURES:append:qemux86=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES:append:qemux86-64=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES:append = " ${@bb.utils.contains("TUNE_FEATURES", "mx32", " cfg/x32.scc", "" ,d)}"
KERNEL_FEATURES:append = " ${@bb.utils.contains("DISTRO_FEATURES", "ptest", " features/scsi/scsi-debug.scc", "" ,d)}"
