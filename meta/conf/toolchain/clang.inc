CC = "${CCACHE}${HOST_PREFIX}clang ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}"
CXX = "${CCACHE}${HOST_PREFIX}clang++ ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}"
FC = "${HOST_PREFIX}gfortran ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}"
CPP = "${CCACHE}${HOST_PREFIX}clang ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS} -E"
LD = "${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-lld', '${HOST_PREFIX}ld.lld${TOOLCHAIN_OPTIONS} ${HOST_LD_ARCH}', '${HOST_PREFIX}ld${TOOLCHAIN_OPTIONS} ${HOST_LD_ARCH}', d)}"
CCLD = "${CCACHE}${HOST_PREFIX}clang ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}"
RANLIB = "${HOST_PREFIX}llvm-ranlib"
AR = "${HOST_PREFIX}llvm-ar"
AS = "${HOST_PREFIX}as ${HOST_AS_ARCH}"
STRIP = "${HOST_PREFIX}llvm-strip"
OBJCOPY = "${HOST_PREFIX}llvm-objcopy"
OBJDUMP = "${HOST_PREFIX}llvm-objdump"
STRINGS = "${HOST_PREFIX}llvm-strings"
NM = "${HOST_PREFIX}llvm-nm"
READELF = "${HOST_PREFIX}llvm-readelf"

PREFERRED_PROVIDER_virtual/cross-cc = "${MLPREFIX}clang-cross-${TARGET_ARCH}"
PREFERRED_PROVIDER_virtual/cross-c++ = "${MLPREFIX}clang-cross-${TARGET_ARCH}"
PREFERRED_PROVIDER_virtual/compilerlibs = "gcc-runtime"
PREFERRED_PROVIDER_virtual/cross-cc:class-nativesdk = "clang-crosssdk-${SDK_SYS}"
PREFERRED_PROVIDER_virtual/cross-c++:class-nativesdk = "clang-crosssdk-${SDK_SYS}"

PREFERRED_PROVIDER_virtual/nativesdk-cross-cc = "clang-crosssdk-${SDK_SYS}"
PREFERRED_PROVIDER_virtual/nativesdk-cross-c++ = "clang-crosssdk-${SDK_SYS}"
PREFERRED_PROVIDER_virtual/nativesdk-compilerlibs = "nativesdk-gcc-runtime"

BASE_DEFAULT_DEPS:append:class-target = " compiler-rt"

TUNE_CCARGS += "${@bb.utils.contains("DISTRO_FEATURES", "usrmerge", " --dyld-prefix=/usr", "", d)}"

LDFLAGS:append:class-nativesdk:x86-64 = " -Wl,-dynamic-linker,${base_libdir}/ld-linux-x86-64.so.2"
LDFLAGS:append:class-nativesdk:aarch64 = " -Wl,-dynamic-linker,${base_libdir}/ld-linux-aarch64.so.1"

TCOVERRIDE = "toolchain-clang"
