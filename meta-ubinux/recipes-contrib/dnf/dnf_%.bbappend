RDEPENDS_${PN}_class-nativesdk += " \
  python3-core \
  python3-codecs \
  python3-netclient \
  python3-email \
  python3-threading \
  python3-distutils \
  python3-logging \
  python3-fcntl \
  librepo \
  python3-shell \
  libcomps \
  libdnf \
  python3-sqlite3 \
  python3-compression \
  python3-rpm \
  python3-iniparse \
  python3-json \
  python3-curses \
  python3-misc \
  python3-gpg \
  libnewt-python \
  "

do_install_append_class-nativesdk() {
        create_wrapper ${D}/${bindir}/dnf \
                RPM_CONFIGDIR=${SDKPATHNATIVE}${libdir_nativesdk}/rpm \
                RPM_NO_CHROOT_FOR_SCRIPTS=1
}
