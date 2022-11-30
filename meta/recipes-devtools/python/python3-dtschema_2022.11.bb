DESCRIPTION = "Tooling for devicetree validation using YAML and jsonschema"
HOMEPAGE = "https://github.com/devicetree-org/dt-schema"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=457495c8fa03540db4a576bf7869e811"

inherit pypi setuptools3

PYPI_PACKAGE = "dtschema"

SRC_URI[sha256sum] = "825e51b8bb82a2d4833d15c25ff2b9a3f5a53b36a490d7c4b6b136037e823320"

DEPENDS += "python3-setuptools-scm-native"
RDEPENDS:${PN} += "python3-ruamel-yaml python3-jsonschema python3-rfc3987"

BBCLASSEXTEND = "native nativesdk"
