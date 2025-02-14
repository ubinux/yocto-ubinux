SUMMARY = "Package group for ubinux"
DESCRIPTION = "Package group for ubinux"
#LICENSE = "MIT"
PACKAGE_ARCH = "${TUNE_PKGARCH}"
inherit packagegroup

LSB_IMAGE_FEATURES = " splash ssh-server-openssh hwcodecs package-management "
IMAGE_FEATURES += " ${LSB_IMAGE_FEATURES} "
IMAGE_FEATURES += " dev-pkgs staticdev-pkgs "

LSB_PKG_GROUPS = " \
        packagegroup-core-full-cmdline \
"
BASE_PKG_GROUPS = " \
        packagegroup-core-boot \
"
PACKAGES = "packagegroup-ubinux-all-noconflict "

UBINUX_PKGS_NOCONFLICT = " \
	adcli \
	acpid \
	alsa-utils \
	anthy \
	at \
	at-spi2-atk \
	atk \
	audit \
	auditd \
	bastille \
	bdftopcf \
	bind \
	bind-utils \
	bison \
	babeld \
	bluez5 \
	bmaptool \
	brotli \
	boost \
	byacc \
	pbzip2 \
	busybox-httpd \
	cairo \
	ccs-tools \
	checksec \
	cifs-utils \
	cmpi-bindings \
	consolekit \
	coreutils-doc \
	cpio \
	cpufrequtils \
	crash \
	cronie \
	cryptodev-linux \
	czmq \
	daq \
	devmem2 \
	dfu-util \
	dhcpcd \
	dnf \
	dialog \
	dool \
	dosfstools \
	dovecot \
	pbzip2 \
	ed \
	edac-utils \
	ecryptfs-utils \
	encodings \
	ethtool \
	expat-bin \
	fatresize \
	flex \
	fio \
	firewalld \
	font-alias \
	font-util \
	fontconfig \
	formfactor \
	freetype \
	f2fs-tools \
	fscryptctl \
	fuse3 \
	geoip \
	geoipupdate \
	geoip-database \
	ghostscript \
	glib-2.0-utils \
	gmime \
	gnutls \
	gobject-introspection \
	groff \
	grpc \
	gtk+ \
	hdf5 \
	hdparm \
	hexedit \
	hicolor-icon-theme \
	icu \
	init-ifupdown \
	initscripts \
	inotify-tools \
	iputils-clockdiff \
	irqbalance \
	ifenslave \
	iozone3 \
	ipc-run \
	iptraf-ng \
	libjpeg-turbo \
	iwd \
	kbd \
	kea \
	kexec-tools \
	less \
	libcap-ng \
	libdrm \
	libffi \
	libfontenc \
	libgcrypt \
	libgpg-error \
	libharu \
	libice \
	libidn \
	libnewt \
	libnl \
	libnss-nis \
	libpcap \
	libpipeline \
	libpciaccess \
	libpeas \
	libpng \
	libsdl \
	libsm \
	libasound \
	libtirpc \
	libtool \
	libuio \
	libuser \
	libx11 \
	libxau \
	libxcb \
	libxcomposite \
	libxcursor \
	libxdamage \
	libxdmcp \
	libxext \
	libxfixes \
	libxfont \
	libxft \
	libxi \
	libxinerama \
	libxkbfile \
	libxml-perl \
	libxmu \
	libxpm \
	libxrandr \
	libxrender \
	libxres \
	libxslt \
	libxt \
	libxtst \
	libxv \
	libxxf86vm \
	libzip \
	linux-libc-headers-dev \
	lksctp-tools \
	lrzsz \
	lsof \
	lxc \
	lynis \
	man-db \
	man-pages \
	makedumpfile \
	mdadm \
	mesa-demos \
	minicom \
	mingetty \
	mmc-utils \
	mkfontscale \
	mmc-utils \
	mpfr \
	mtr \
	esmtp \
	mtd-utils \
	mtd-utils-jffs2 \
	nautilus \
	nfs-export-root \
	novnc \
	openhpi \
	openssh \
	paxctl \
	paho-mqtt-c \
	pango \
	pbzip2 \
	pcregrep \
	pcmciautils \
	pixman \
	php \
	pkgconfig \
	pm-utils \
	polkit \
	pointercal \
	powertop \
	ppp \
	xorgproto-dev \
	xorgxrdp \
	xrdp \
	rp-pppoe \
	rp-pppoe-server \
	rp-pppoe-relay \
	rpcsvc-proto \
	ruby \
	rgb \
	rsync \
	screen \
	setserial \
	setxkbmap \
	slang \
	spitools \
	strace \
	stress \
	strongswan \
	stunnel \
	subversion \
	sysprof \
	sysstat \
	tiff \
	udev \
	util-macros \
	usbutils \
	watchdog \
	xdg-utils \
	wpa-supplicant \
	xauth \
	xdelta3 \
	xdpyinfo \
	xf86-input-evdev \
	xf86-input-mouse \
	xf86-input-synaptics \
	xf86-video-fbdev \
	xhost \
	xinetd \
	xinit \
	xkbcomp \
	xinit \
	xkbcomp \
	xkeyboard-config \
	xmodmap \
	xorg-minimal-fonts \
	xprop \
	xrandr \
	xrestop \
	xserver-xorg \
	xset \
	xtrans-dev \
	xvinfo \
	xwd \
	xwininfo \
	xwud \
	bridge-utils \
	ca-certificates \
	corosync \
	cryptsetup \
	ctapi-common \
	cyrus-sasl \
	cyrus-sasl-bin \
	daemontools \
	dash \
	ttf-dejavu-sans \
	ttf-dejavu-sans-mono \
	ttf-dejavu-sans-condensed \
	ttf-dejavu-serif \
	ttf-dejavu-serif-condensed \
	ttf-dejavu-common \
	multipath-tools \
	eject \
	fbset \
	fuse \
	fuse-utils \
	drbd-utils \
	hostapd \
	hwdata \
	i2c-tools \
	indent \
	iperf3 \
	iw \
	kbd \
	keyutils \
	libconfig \
	libdbi \
	libedit \
	libesmtp \
	libgxim \
	liblockfile \
	libnotify \
	libp11 \
	libsmi \
	libssh2 \
	libutempter \
	libunwind \
	libxaw6 \
	libxaw7 \
	libxvmc \
	linux-atm \
	lldpd \
	rrdtool \
	lockfile-progs \
	logfsprogs \
	logwatch \
	ltrace \
	lvm2 \
	mailcap \
	mcpp \
	monit \
	ncftp \
	net-snmp-client \
	net-snmp-server \
	net-snmp-mibs \
	xserver-xorg \
	ntp \
	ntp-utils \
	opensc \
	nss-pam-ldapd \
	ntp \
	ntp-utils \
	opensc \
	openipmi \
	openl2tp \
	openldap \
	openldap-slapd \
	openvpn \
	openvpn-sample \
	openwsman \
	passwdqc \
	pam-plugin-access \
	pam-plugin-debug \
	pam-plugin-deny \
	pam-plugin-echo \
	pam-plugin-env \
	pam-plugin-exec \
	pam-plugin-faildelay \
	pam-plugin-filter \
	pam-plugin-ftp \
	pam-plugin-group \
	pam-plugin-issue \
	pam-plugin-keyinit \
	pam-plugin-limits \
	pam-plugin-listfile \
	pam-plugin-localuser \
	pam-plugin-loginuid \
	pam-plugin-mail \
	pam-plugin-mkhomedir \
	pam-plugin-motd \
	pam-plugin-namespace \
	pam-plugin-nologin \
	pam-plugin-permit \
	pam-plugin-pwhistory \
	pam-plugin-rhosts \
	pam-plugin-rootok \
	pam-plugin-securetty \
	pam-plugin-shells \
	pam-plugin-stress \
	pam-plugin-succeed-if \
	pam-plugin-time \
	pam-plugin-timestamp \
	pam-plugin-umask \
	pam-plugin-unix \
	pam-plugin-warn \
	pam-plugin-xauth \
	perf \
	pcsc-lite \
	pkcs11-helper \
	procmail \
	ptpd \
	radvd \
	rarpd \
	smartmontools \
	sessreg \
	sshfs-fuse \
	sgpio \
	smem \
	sshfs-fuse \
	stress \
	ttf-ipag \
	ttf-ipagp \
	ttf-ipam \
	ttf-ipamp \
	ttf-takao-gothic \
	ttf-takao-mincho \
	ttf-takao-pgothic \
	ttf-takao-pmincho \
	tcpdump \
	tcsh \
	tftp-hpa \
	tftp-hpa-server \
	tk \
	tomoyo-tools \
	vlan \
	wireshark \
	xf86-input-void \
	xfsprogs \
	xkbevd \
	xkbprint \
	xkbutils \
	iceauth \
	xgamma \
	xlsatoms \
	xlsclients \
	xlsfonts \
	xrdb \
	xrefresh \
	xsetroot \
	xstdcmap \
	twm \
	xterm \
	zabbix \
	libcgroup \
	alsa-conf \
	alsa-server \
	alsa-state \
	avahi-autoipd \
	avahi-utils \
	base-passwd-update \
	cxpm \
	db-bin \
	e2fsprogs-e2fsck \
	e2fsprogs-mke2fs \
	e2fsprogs-tune2fs \
	elfutils-binutils \
	gdbserver \
	gtk-demo \
	gtk-immodule-am-et \
	gtk-immodule-cedilla \
	gtk-immodule-cyrillic-translit \
	gtk-immodule-inuktitut \
	gtk-immodule-ipa \
	gtk-immodule-multipress \
	gtk-immodule-thai \
	gtk-immodule-ti-er \
	gtk-immodule-ti-et \
	gtk-immodule-viqr \
	gtk-immodule-xim \
	gtk-printbackend-file \
	gtk-printbackend-lpr \
	gdk-pixbuf \
	gtk3-immodule-viqr \
	kbd-consolefonts \
	kbd-consoletrans \
	kbd-keymaps \
	kbd-unimaps \
	kdump \
	kexec \
	libdrm-tests \
	libgail \
	libjs-sizzle \
	libjs-jquery \
	libkcapi \
	libmemusage \
	libpam \
	libpulsecore \
	libsotruss \
	libulockmgr \
	libxslt-bin \
	lmsensors-sensors \
	lmsensors-sensord \
	lmsensors-config-sensord \
	lmsensors-sensorsdetect \
	babeltrace \
	matchbox-keyboard \
	mesa-megadriver \
	nano \
	ncurses-terminfo \
	ncurses-tools \
	nfs-utils-stats \
	nscd \
	openssh-misc \
	openssh-sftp \
	openssh-sftp-server \
	openssl-engines \
	openssl-misc \
	pango-modules \
	gawk \
	ppp-l2tp \
	ppp-minconn \
	ppp-oa \
	ppp-password \
	ppp-radius \
	ppp-tools \
	ppp-winbind \
	psmisc-extras \
	pulseaudio-lib-alsa-util \
	rpm-build \
	samba \
	shared-mime-info-data \
	sln \
	smack \
	snappy \
	sxpm \
	trace-cmd \
	tslib-calibrate \
	tslib-tests \
	tzdata-africa \
	tzdata-americas \
	tzdata-antarctica \
	tzdata-arctic \
	tzdata-asia \
	tzdata-atlantic  \
	tzdata-australia \
	tzdata-europe \
	tzdata-misc \
	tzdata-pacific \
	tzdata-posix \
	tzdata-right \
	uftrace \
	uhubctl \
	uim \
	upm \
	util-linux-hwclock \
	util-linux-agetty \
	util-linux-blkid \
	util-linux-cfdisk \
	util-linux-fdisk \
	util-linux-fsck \
	util-linux-losetup \
	util-linux-lscpu \
	util-linux-mcookie \
	util-linux-mkfs \
	util-linux-mount \
	util-linux-sfdisk \
	util-linux-swaponoff \
	util-linux-umount \
	util-linux-uuidgen \
	util-linux-uuidd \
	xserver-xorg-extension-glx \
	xserver-xorg-module-libwfb \
	xev \
	gradm \
	libxml-simple-perl \
	nicstat \
	tiptop \
	blktrace \
	systemtap \
	iotop \
	iptraf \
	btrfs-tools \
	openvswitch \
	xmlto \
	expect \
	cim-schema-exper \
	cairo \
	firewalld \
	font-alias \
	font-util \
	fontconfig \
	freetype \
	wtmpdb \
	xinput \
	wget \
	linuxptp \
"	

RDEPENDS:packagegroup-ubinux-all-noconflict = " \
        ${UBINUX_PKGS_NOCONFLICT} \
"

