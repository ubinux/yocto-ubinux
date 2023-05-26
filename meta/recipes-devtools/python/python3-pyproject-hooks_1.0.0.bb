SUMMARY = "A low-level library for calling build-backends in pyproject.toml-based projects"
HOMEPAGE = "https://github.com/pypa/pyproject-hooks"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aad69c93f605003e3342b174d9b0708c"

SRC_URI[sha256sum] = "f271b298b97f5955d53fb12b72c1fb1948c22c1a6b70b315c54cedaca0264ef5"

inherit pypi python_flit_core

PYPI_PACKAGE = "pyproject_hooks"

BBCLASSEXTEND = "native nativesdk"

# Bootstrap the native build
DEPENDS:remove:class-native = "python3-build-native"

RDEPENDS:${PN} += " \
    python3-io \
    python3-json \
"

do_compile:class-native () {
    python_flit_core_do_manual_build
}
