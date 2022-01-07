SUMMARY = "JavaScript UI library for dynamic web applications"
DESCRIPTION = "jQuery UI provides abstractions for low-level interaction and animation, advanced effects and high-level, themeable widgets, built on top of the jQuery JavaScript Library, that you can use to build highly interactive web applications."
SECTION = "console/network"
HOMEPAGE = "http://jqueryui.com/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://jquery-ui-${PV}/LICENSE.txt;md5=e0c0d3d883e83f19efa64feb54d5f63d"

DEPENDS = "virtual/libc"

SRC_URI = "https://jqueryui.com/resources/download/jquery-ui-${PV}.zip;name=jui \
	   https://jqueryui.com/resources/download/jquery-ui-themes-${PV}.zip;name=jui-themes \
	  "
SRC_URI[jui.sha256sum] = "fa6a6c9eb997a18522987dddba2052b9835a646e5e9679f738b1a18caabfe7ce"
SRC_URI[jui-themes.sha256sum] = "091163207082eac14bca8bd42d8176e85cb57dd5eb3e521d62580dd4d724b811"

PACKAGES = "${PN} ${PN}-doc"
FILES:${PN} = "${datadir}/javascript/jquery-ui"
FILES:${PN}-doc += "${datadir}/doc/${PN}"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${datadir}/javascript/jquery-ui/
	install -p -m 0644 ${S}/jquery-ui-${PV}/*.js ${D}${datadir}/javascript/jquery-ui/

	install -d ${D}${datadir}/javascript/jquery-ui/css/smoothness/images/
	install -p -m 0644 ${S}/jquery-ui-${PV}/images/*.png ${D}${datadir}/javascript/jquery-ui/css/smoothness/images/
	install -p -m 0644 ${S}/jquery-ui-${PV}/*.css ${D}${datadir}/javascript/jquery-ui/css/smoothness/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/black-tie/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/black-tie/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/black-tie/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/black-tie/*.css ${D}${datadir}/javascript/jquery-ui/themes/black-tie/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/blitzer/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/blitzer/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/blitzer/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/blitzer/*.css ${D}${datadir}/javascript/jquery-ui/themes/blitzer/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/cupertino/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/cupertino/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/cupertino/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/cupertino/*.css ${D}${datadir}/javascript/jquery-ui/themes/cupertino/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/dark-hive/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/dark-hive/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/dark-hive/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/dark-hive/*.css ${D}${datadir}/javascript/jquery-ui/themes/dark-hive/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/dot-luv/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/dot-luv/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/dot-luv/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/dot-luv/*.css ${D}${datadir}/javascript/jquery-ui/themes/dot-luv/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/eggplant/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/eggplant/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/eggplant/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/eggplant/*.css ${D}${datadir}/javascript/jquery-ui/themes/eggplant/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/excite-bike/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/excite-bike/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/excite-bike/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/excite-bike/*.css ${D}${datadir}/javascript/jquery-ui/themes/excite-bike/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/flick/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/flick/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/flick/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/flick/*.css ${D}${datadir}/javascript/jquery-ui/themes/flick/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/hot-sneaks/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/hot-sneaks/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/hot-sneaks/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/hot-sneaks/*.css ${D}${datadir}/javascript/jquery-ui/themes/hot-sneaks/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/humanity/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/humanity/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/humanity/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/humanity/*.css ${D}${datadir}/javascript/jquery-ui/themes/humanity/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/le-frog/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/le-frog/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/le-frog/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/le-frog/*.css ${D}${datadir}/javascript/jquery-ui/themes/le-frog/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/mint-choc/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/mint-choc/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/mint-choc/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/mint-choc/*.css ${D}${datadir}/javascript/jquery-ui/themes/mint-choc/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/overcast/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/overcast/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/overcast/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/overcast/*.css ${D}${datadir}/javascript/jquery-ui/themes/overcast/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/pepper-grinder/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/pepper-grinder/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/pepper-grinder/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/pepper-grinder/*.css ${D}${datadir}/javascript/jquery-ui/themes/pepper-grinder/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/redmond/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/redmond/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/redmond/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/redmond/*.css ${D}${datadir}/javascript/jquery-ui/themes/redmond/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/smoothness/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/smoothness/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/smoothness/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/smoothness/*.css ${D}${datadir}/javascript/jquery-ui/themes/smoothness/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/south-street/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/south-street/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/south-street/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/south-street/*.css ${D}${datadir}/javascript/jquery-ui/themes/south-street/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/start/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/start/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/start/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/start/*.css ${D}${datadir}/javascript/jquery-ui/themes/start/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/sunny/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/sunny/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/sunny/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/sunny/*.css ${D}${datadir}/javascript/jquery-ui/themes/sunny/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/swanky-purse/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/swanky-purse/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/swanky-purse/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/swanky-purse/*.css ${D}${datadir}/javascript/jquery-ui/themes/swanky-purse/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/trontastic/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/trontastic/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/trontastic/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/trontastic/*.css ${D}${datadir}/javascript/jquery-ui/themes/trontastic/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/ui-darkness/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/ui-darkness/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/ui-darkness/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/ui-darkness/*.css ${D}${datadir}/javascript/jquery-ui/themes/ui-darkness/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/ui-lightness/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/ui-lightness/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/ui-lightness/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/ui-lightness/*.css ${D}${datadir}/javascript/jquery-ui/themes/ui-lightness/

	install -d ${D}${datadir}/javascript/jquery-ui/themes/vader/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/vader/images/*.png ${D}${datadir}/javascript/jquery-ui/themes/vader/images/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/themes/vader/*.css ${D}${datadir}/javascript/jquery-ui/themes/vader/

	install -d ${D}${datadir}/doc/${PN}/
	install -p -m 0644 ${S}/jquery-ui-themes-${PV}/AUTHORS.txt ${D}${datadir}/doc/${PN}/
	install -p -m 0644 ${LICSSTATEDIR}${PN}/generic_MIT ${D}${datadir}/doc/${PN}/
}
