create_sdk_files:append() {
    echo 'export MACHINE_ARCH=${MACHINE_ARCH}' >> $script
    echo 'export SDKPATH=${SDKPATH}' >> $script
}
