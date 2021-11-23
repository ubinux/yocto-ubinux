#!/bin/sh

if [ "x$0" = "x./setup_ubinux.sh" ] ; then
	echo "Error: This script needs to be sourced. "
	echo "Please run as '. ./setup_ubinux.sh <machine> <build>'"
	exit 1
fi

if [ $# -ne 2 ] ; then
	echo "usage: $0 <machine> <build>"
	exit 1
fi

MACHINE=$1
BUILD=$2
export TEMPLATECONF="meta-ubinux/conf"

#. trunk/poky-ubinux/oe-init-build-env ${BUILD}
. ./oe-init-build-env ${BUILD}

DOWNLOADS=$(readlink -f $2)/downloads/downloads-ubinux202111
add_conf_append ()
{
cat << EOF >> conf/local.conf
MACHINE = "${MACHINE}"
#BB_NUMBER_THREADS = "4"
#PARALLEL_MAKE = "-j 8"
SOURCE_MIRROR_URL ?= "file://${DOWNLOADS}"
INHERIT += "own-mirrors"
BB_GENERATE_MIRROR_TARBALLS = "1"
DL_DIR ?= "${DOWNLOADS}"
EOF
}

if [ -f $BUILDDIR/conf/local.conf ]; then
	have_set=`grep '^MACHINE =' ${BUILDDIR}/conf/local.conf |tail -n 1 |awk '{print $3}'`
	if [ "x$have_set" != "x\"$MACHINE\"" ]; then
		add_conf_append
	fi
else 
	add_conf_append
fi

#bitbake ubinux-all
#bitbake meta-toolchain 
#bitbake package-index
