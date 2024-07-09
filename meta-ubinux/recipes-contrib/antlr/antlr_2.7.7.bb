SUMMARY = "Framework for constructing recognizers, interpreters, compilers, and translators"
HOMEPAGE = "http://www.antlr2.org"
# see http://www.antlr2.org/license.html
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=361934e706423915b4d9f413ad37fb65"

SRC_URI = "http://www.antlr2.org/download/${BP}.tar.gz"
SRC_URI:append:class-native = " file://runantlr"

inherit java-library

do_configure:class-native() {
    sed -i -e"s|@JAR_FILE@|${STAGING_DATADIR_JAVA_NATIVE}/antlr.jar|" ${UNPACKDIR}/runantlr
}

do_compile() {
    mkdir -p build

    javac -sourcepath . -d build `find antlr -name "*.java"`

    fastjar cf ${JARFILENAME} -C build .
}

do_install:class-native() {
    install -d ${D}${bindir}
    install -m 0755 ${UNPACKDIR}/runantlr ${D}${bindir}/
}

SRC_URI[md5sum] = "01cc9a2a454dd33dcd8c856ec89af090"
SRC_URI[sha256sum] = "853aeb021aef7586bda29e74a6b03006bcb565a755c86b66032d8ec31b67dbb9"

BBCLASSEXTEND = "native"

