SUMMARY = "The Vulkan Samples is collection of resources to help develop optimized Vulkan applications."
HOMEPAGE = "https://www.khronos.org/vulkan/"
BUGTRACKER = "https://github.com/KhronosGroup/Vulkan-Samples/issues"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=48aa35cefb768436223a6e7f18dc2a2a"

SRC_URI = "gitsm://github.com/KhronosGroup/Vulkan-Samples.git;branch=main;protocol=https;lfs=0 \
           file://0001-vulkan-samples-Fix-reproducibility-issue.patch \
           file://0001-zstd.c-replace-FORCE_INLINE_TEMPLATE-with-inline.patch;patchdir=third_party/ktx \
           "

UPSTREAM_CHECK_COMMITS = "1"
SRCREV = "fdce530c029514e2f66296288f9ee26a05058ec1"

UPSTREAM_CHECK_GITTAGREGEX = "These are not the releases you're looking for"
S = "${WORKDIR}/git"

REQUIRED_DISTRO_FEATURES = 'vulkan'

inherit cmake features_check

FILES:${PN} += "${datadir}"

#
# There is code to remove the prefix CMAKE_SOURCE_DIR from __FILENAME__ paths
# used for logging with LOGE in the code. We need to make this match the value we use
# in the debug source remapping from CFLAGS
#
EXTRA_OECMAKE += "-DCMAKE_DEBUG_SRCDIR=${TARGET_DBGSRC_DIR}/"
# Binaries built with PCH enabled don't appear reproducible, differing results were seen
# from some builds depending on the point the PCH was compiled. Disable it to be
# deterministic
EXTRA_OECMAKE += "-DCMAKE_DISABLE_PRECOMPILE_HEADERS=ON"

# This needs to be specified explicitly to avoid xcb/xlib dependencies
EXTRA_OECMAKE += "-DVKB_WSI_SELECTION=D2D"

COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"
