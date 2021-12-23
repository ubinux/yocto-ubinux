
# Use indirection to stop these being expanded prematurely
CRASH = "crash-cross-canadian-${TRANSLATED_TARGET_ARCH}"

RDEPENDS:${PN} += "\
    ${CRASH} \
    "
#    ${@all_multilib_tune_values(d, 'CRASH')} 

