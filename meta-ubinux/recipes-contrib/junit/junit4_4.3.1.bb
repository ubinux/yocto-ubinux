SUMMARY = "JUnit is a testing framework for Java"
LICENSE = "CPL-1.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/CPL-1.0;md5=5295cd12fc5acc87bf1cf754455a1c56"
AUTHOR = "junit.org"
HOMEPAGE = "http://www.junit.org"

SRC_URI = "http://downloads.sourceforge.net/junit/junit-${PV}-src.jar"

S = "${UNPACKDIR}"

inherit java-library

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build

	# Workaround for jamvm.
	bcp=${STAGING_DATADIR_NATIVE}/classpath/glibj.zip

  javac -source 5.0 -bootclasspath $bcp -sourcepath . -d build `find . -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}

SRC_URI[md5sum] = "170f9645a41398388e8553b32ff5f630"
SRC_URI[sha256sum] = "57d1e49ee3fd0dbdc0a68a852925c973af5c30b1725b6aa63bfb42df6f7c3349"

BBCLASSEXTEND = "native"
