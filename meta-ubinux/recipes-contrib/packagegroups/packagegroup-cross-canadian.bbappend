
# Use indirection to stop these being expanded prematurely
CRASH = "crash-cross-canadian-${TRANSLATED_TARGET_ARCH}"

RDEPENDS:${PN} += "\
    ${@all_multilib_tune_values(d, 'CRASH')} \
    "