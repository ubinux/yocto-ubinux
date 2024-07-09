inherit multilib_script

MULTILIB_SCRIPTS:append:ubinux-armv8 = "${PN}-terminfo-base:${sysconfdir}/terminfo/x/xterm-256color \
                    ${PN}-terminfo-base:${sysconfdir}/terminfo/x/xterm-color \
                    ${PN}-terminfo:${datadir}/terminfo/a/alacritty \
                    ${PN}-terminfo:${datadir}/terminfo/a/alacritty+common \
                    ${PN}-terminfo:${datadir}/terminfo/a/alacritty-direct \
                    ${PN}-terminfo:${datadir}/terminfo/k/konsole \
                    ${PN}-terminfo:${datadir}/terminfo/k/konsole-16color \
                    ${PN}-terminfo:${datadir}/terminfo/k/konsole-256color \
                    ${PN}-terminfo:${datadir}/terminfo/k/konsole-base \
                    ${PN}-terminfo:${datadir}/terminfo/k/konsole-direct \
                    ${PN}-terminfo:${datadir}/terminfo/k/konsole-linux \
                    ${PN}-terminfo:${datadir}/terminfo/k/konsole-vt100 \
                    ${PN}-terminfo:${datadir}/terminfo/k/konsole-xf3x \
                    ${PN}-terminfo:${datadir}/terminfo/k/konsole-xf4x \
                    ${PN}-terminfo:${datadir}/terminfo/k/kterm \
                    ${PN}-terminfo:${datadir}/terminfo/k/kterm-co \
                    ${PN}-terminfo:${datadir}/terminfo/k/kterm-color \
                    ${PN}-terminfo:${datadir}/terminfo/n/nxterm \
                    ${PN}-terminfo:${datadir}/terminfo/r/rio \
                    ${PN}-terminfo:${datadir}/terminfo/r/rio-direct \
                    ${PN}-terminfo:${datadir}/terminfo/s/screen-bce.konsole   \
                    ${PN}-terminfo:${datadir}/terminfo/s/screen-bce.xterm-new   \
                    ${PN}-terminfo:${datadir}/terminfo/s/screen.konsole   \
                    ${PN}-terminfo:${datadir}/terminfo/s/screen.konsole-256color   \
                    ${PN}-terminfo:${datadir}/terminfo/s/screen.xterm-256color   \
                    ${PN}-terminfo:${datadir}/terminfo/s/screen.xterm-new   \
                    ${PN}-terminfo:${datadir}/terminfo/s/screen.xterm-r6   \
                    ${PN}-terminfo:${datadir}/terminfo/s/screen.xterm-xfree86   \
                    ${PN}-terminfo:${datadir}/terminfo/s/scrt   \
                    ${PN}-terminfo:${datadir}/terminfo/s/securecrt \
                    ${PN}-terminfo:${datadir}/terminfo/v/vs100  \
                    ${PN}-terminfo:${datadir}/terminfo/w/wezterm  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xgterm  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xiterm  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm+kbs  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm+nofkeys  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-1002  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-1003  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-1005  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-1006  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-24  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-88color  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-8bit  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-basic  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-bold  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-direct  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-direct16  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-direct2  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-hp  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-mono  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-new  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-nic  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-noapp  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-old  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-p370  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-p371  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-pcolor  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-r5 \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-r6 \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-sun  \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-utf8 \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-vt220 \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-vt52 \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-x10mouse \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-x11hilite \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm-x11mouse \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterm1 \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterms \
                    ${PN}-terminfo:${datadir}/terminfo/x/xterms-sun" 









