SRC_URI = "\
	https://github.com/mozilla/rhino/archive/refs/tags/Rhino1_7R4_RELEASE.zip \
	file://rhino \
	file://rhino-jsc \
	"

S = "${WORKDIR}/rhino-Rhino1_7R4_RELEASE"

SRC_URI[md5sum] = "1f893577269631703d31e4de9d5dc1f4"
SRC_URI[sha256sum] = "860965fc611764745b3a4fc5bd4baac07356a9fedd2ce6642e7bb0bd7ef58d07"
