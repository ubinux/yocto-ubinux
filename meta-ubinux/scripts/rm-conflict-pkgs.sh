#!/bin/sh
find ./ -name "lib32-packagegroup-ubinux-all*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-*-doc-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-*-symlinks-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-*-ptest-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-bash-bashbug-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-libsctp-utils-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-pulseaudio-misc-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-nautilus-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-gawk-gawkbug-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-libmariadb-dev-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-php-dev-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-php-phar-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-ldd-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-uim-common-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-libtraceevent-plugins-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "libtraceevent-plugins-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "lib32-libtraceevent-dbg-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "libtraceevent-dbg-*" |  xargs -n1 -I{} rm -rf  {};
find ./ -name "vulkan-headers-dev-*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "lib32-openvswitch-ptest*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "lib32-frr*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "lib32-cluster-glue-*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "lib32-python3-psutil-tests*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "kernel-*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "linux-yocto-*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "watchdog-keepalive*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "lib32-watchdog-keepalive*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "packagegroup-core-standalone-sdk-target*" |  xargs -n1 -I{} rm -rf  {}
find ./ -name "lib32-packagegroup-core-standalone-sdk-target*" |  xargs -n1 -I{} rm -rf  {}
