RPROVIDES_${PN}-dbg_remove_arm = "${PN}-isatools-dbg"
RPROVIDES_${PN}-dbg_remove_aarch64 = "${PN}-isatools-dbg"

RDEPENDS_${PN}_remove_arm = "${PN}-isatools"
RDEPENDS_${PN}_remove_aarch64 = "${PN}-isatools"

PACKAGES_${PN}_remove_arm = "${PN}-isatools ${PN}-isatools-doc"
PACKAGES_${PN}_remove_aarch64 = "${PN}-isatools ${PN}-isatools-doc"

