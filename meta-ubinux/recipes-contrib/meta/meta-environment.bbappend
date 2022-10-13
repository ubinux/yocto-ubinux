create_sdk_files:append() {
    echo 'export MACHINE_ARCH=${MACHINE_ARCH}' >> $script
    echo 'export SDKPATH=${SDKPATH}' >> $script
    echo "export PATH=${SDKTARGETSYSROOT}${prefix_nativesdk}/bin/crossscripts"':$PATH' >> $script
    echo 'export TARGET_VENDOR=${TARGET_VENDOR}' >> $script
    echo 'export DISTRO_CODENAME=${DISTRO_CODENAME}' >> $script
}
