#!/bin/sh

RPMPATH=/home/ben/dev/ubinux/build/poky/qemux86_64.0203/tmp/deploy/rpm/
ARCH=x86_64
DATE=20150206

do_filter_dir() {
	local rpmdir="$1"
	local suffix="$1"

	if [ ! -d "$rpmdir" ]; then
		echo "No such Directory"
		return
	fi

	for rpmf in `find $rpmdir -name "*.rpm" | grep -vE "\-doc-|\-dbg-|\-ptest-"`; do
		echo $rpmf | awk -F "/" '{print $2}' | \
			     awk -F ".$suffix" '{print $1}' | \
			     awk -F "-" '{for(i=1;i<NF-2;i++)printf("%s-",$i); printf("%s\n", $(NF-2))}' >> "$TMPFILE"
	done
}

do_filter_x86() {
	do_filter_dir all
	do_filter_dir i586
	do_filter_dir ubinux_x86
}

do_filter_x86_64() {
	do_filter_dir all
	do_filter_dir core2_64
	do_filter_dir ubinux_x86_64
}

do_filter_armv7() {
	do_filter_dir all
	do_filter_dir armv7a_vfp_neon
	do_filter_dir ubinux_armv7
}

do_filter_e500v2() {
	do_filter_dir all
	do_filter_dir ppce500v2
	do_filter_dir ubinux_e500v2
}

CDIR=`pwd`
PKGFILE="$CDIR/pkg-$ARCH.$DATE"
TMPFILE="$CDIR/pkg-$ARCH.$DATE.temp"

echo "$ARCH Package List ($DATE)" > "$PKGFILE"
rm -rf "$TMPFILE"

cd $RPMPATH
do_filter_$ARCH
sort "$TMPFILE" >> "$PKGFILE"

rm -rf "$TMPFILE"

cd $CDIR
