do_install:append:class-target() {
    sed -i -e 's|${S}||g' ${B}/tests/auto/dbus/qdbusabstractinterface/qdbusabstractinterface/pinger_interface.cpp
    sed -i -e 's|${S}||g' ${B}/tests/auto/dbus/qdbusabstractinterface/qdbusabstractinterface/pinger_interface.h
}

