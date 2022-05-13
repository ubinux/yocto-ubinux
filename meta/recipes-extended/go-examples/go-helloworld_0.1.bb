DESCRIPTION = "This is a simple example recipe that cross-compiles a Go program."
SECTION = "examples"
HOMEPAGE = "https://golang.org/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://go.googlesource.com/example;branch=master;protocol=https"
SRCREV = "2e68773dfca072cb81f219fc3b97ad34fe9d9f94"
UPSTREAM_CHECK_COMMITS = "1"

GO_IMPORT = "golang.org/x/example"
GO_INSTALL = "${GO_IMPORT}/hello"

export GO111MODULE="off"

inherit go

# This is just to make clear where this example is
do_install:append() {
    mv ${D}${bindir}/hello ${D}${bindir}/${BPN}
}
