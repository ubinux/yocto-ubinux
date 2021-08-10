RPROVIDES_${PN}-dbg:remove:arm = "${PN}-isatools-dbg"
RPROVIDES_${PN}-dbg:remove:aarch64 = "${PN}-isatools-dbg"

RDEPENDS_${PN}:remove:arm = "${PN}-isatools"
RDEPENDS_${PN}:remove:aarch64 = "${PN}-isatools"

PACKAGES_${PN}:remove:arm = "${PN}-isatools ${PN}-isatools-doc"
PACKAGES_${PN}:remove:aarch64 = "${PN}-isatools ${PN}-isatools-doc"

