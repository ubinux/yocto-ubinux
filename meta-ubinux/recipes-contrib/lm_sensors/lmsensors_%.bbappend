RPROVIDES:${PN}-dbg:remove:arm = "${PN}-isatools-dbg"
RPROVIDES:${PN}-dbg:remove:aarch64 = "${PN}-isatools-dbg"

RDEPENDS:${PN}:remove:arm = "${PN}-isatools"
RDEPENDS:${PN}:remove:aarch64 = "${PN}-isatools"

PACKAGES_${PN}:remove:arm = "${PN}-isatools ${PN}-isatools-doc"
PACKAGES_${PN}:remove:aarch64 = "${PN}-isatools ${PN}-isatools-doc"

