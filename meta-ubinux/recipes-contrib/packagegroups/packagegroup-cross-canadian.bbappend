
# Use indirection to stop these being expanded prematurely
CRASH = "crash-cross-canadian-${TRANSLATED_TARGET_ARCH}"

RDEPENDS_${PN}_aarch64 += "\
    ${@all_multilib_tune_values(d, 'CRASH')} \
    "
