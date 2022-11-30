SUMMARY = "This provides a PEP 517 build backend for packages using Flit."
DESCRIPTION = "This provides a PEP 517 build backend for packages using \
Flit. The only public interface is the API specified by PEP 517, at \
flit_core.buildapi."
HOMEPAGE = "https://github.com/pypa/flit"
BUGTRACKER = "https://github.com/pypa/flit/issues"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=41eb78fa8a872983a882c694a8305f08"

SRC_URI[sha256sum] = "d0f2a8f4bd45dc794befbf5839ecc0fd3830d65a57bd52b5997542fac5d5e937"

inherit pypi python_flit_core

# Need to install by hand as there's a dependency loop
DEPENDS:remove:class-native = " python3-picobuild-native python3-installer-native"
DEPENDS:append:class-native = " unzip-native"

# We need the full flit tarball
PYPI_PACKAGE = "flit"
PEP517_SOURCE_PATH = "${S}/flit_core"

do_compile:class-native () {
    python_flit_core_do_manual_build
}

do_install:class-native () {
    python_pep517_do_bootstrap_install
}

PACKAGES =+ "${PN}-tests"

FILES:${PN}-tests += "\
    ${PYTHON_SITEPACKAGES_DIR}/flit_core/tests/* \
"

BBCLASSEXTEND = "native nativesdk"
