inherit update-alternatives

ALTERNATIVE_PRIORITY = "60"
ALTERNATIVE_${PN}-doc = "sha1.h"
ALTERNATIVE_LINK_NAME[sha1.h] = "${includedir}/sha1.h"

