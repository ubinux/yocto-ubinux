INC_FILE_SUFFIX = ""
INC_FILE_SUFFIX:aarch64 = "-aarch64"
INC_FILE_SUFFIX:armv7a = "-aarch32"
INC_FILE_SUFFIX:armv7ve = "-aarch32"
require openjdk-8-release${INC_FILE_SUFFIX}.inc
require openjdk-8-cross.inc

do_install() {
    rm -rf ${D}${JRE_HOME}
    mkdir -p ${D}${JRE_HOME}
    cp -rp ${B}/images/j2re-image/* ${D}${JRE_HOME}
    chown -R root:root ${D}${JRE_HOME}
    install -m644 ${WORKDIR}/jvm.cfg  ${D}${JRE_HOME}/lib/${JDK_ARCH}/
}

FILES:${PN}:append = "\
    ${JRE_HOME}/bin/[a-z]* \
    ${JRE_HOME}/lib/[a-z]* \
    ${JRE_HOME}/LICENSE \
    ${JRE_HOME}/release \
"

FILES:${PN}-dbg:append = "\
    ${JRE_HOME}/bin/.debug/ \
    ${JRE_HOME}/lib/.debug/ \
    ${JRE_HOME}/lib/${JDK_ARCH}/.debug/ \
    ${JRE_HOME}/lib/${JDK_ARCH}/jli/.debug/ \
    ${JRE_HOME}/lib/${JDK_ARCH}/server/.debug/ \
"

FILES:${PN}-doc:append = "\
    ${JRE_HOME}/man \
    ${JRE_HOME}/ASSEMBLY_EXCEPTION \
    ${JRE_HOME}/THIRD_PARTY_README \
"

RPROVIDES:${PN} = "java2-runtime"

inherit update-alternatives

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE:${PN} = "java keytool"
ALTERNATIVE_LINK_NAME[java] = "${bindir}/java"
ALTERNATIVE_TARGET[java] = "${JRE_HOME}/bin/java"

ALTERNATIVE_LINK_NAME[keytool] = "${bindir}/keytool"
ALTERNATIVE_TARGET[keytool] = "${JRE_HOME}/bin/keytool"
