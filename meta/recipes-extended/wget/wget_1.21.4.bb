SRC_URI = "${GNU_MIRROR}/wget/wget-${PV}.tar.gz \
           file://0002-improve-reproducibility.patch \
          "

SRC_URI[sha256sum] = "81542f5cefb8faacc39bbbc6c82ded80e3e4a88505ae72ea51df27525bcde04c"

require wget.inc
