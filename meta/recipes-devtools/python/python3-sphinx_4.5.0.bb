DESCRIPTION = "Python documentation generator"
HOMEPAGE = "http://sphinx-doc.org/"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause & MIT & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=72c536e78c21c567311b193fe00cd253"

PYPI_PACKAGE = "Sphinx"

SRC_URI[sha256sum] = "7bf8ca9637a4ee15af412d1a1d9689fec70523a68ca9bb9127c2f3eeb344e2e6"

inherit setuptools3 pypi

 
do_install:append () {
	# The cache format of "{None, 'en', 'ja'}" doesn't seem to be consistent (dict ordering?)
	rm ${D}${libdir}/${PYTHON_DIR}/site-packages/sphinx/writers/__pycache__/*latex*
}

RDEPENDS:${PN} = "\
    python3-packaging python3-docutils python3-requests \
    python3-imagesize python3-alabaster python3-jinja2 \
    python3-babel python3-pygments python3-snowballstemmer \
    python3-sphinxcontrib-applehelp python3-sphinxcontrib-devhelp \
    python3-sphinxcontrib-jsmath python3-sphinxcontrib-htmlhelp \
    python3-sphinxcontrib-serializinghtml python3-sphinxcontrib-qthelp \
    "

BBCLASSEXTEND = "native nativesdk"
