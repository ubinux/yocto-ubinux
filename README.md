# 1. Introduction
***
Like RHEL, Fedora and Ubuntu, ubinux is a solution of embedded platform operating system（including mass storage，small printers and scanners） based on Linux distribution.

# 2. Prepare
***
## 2.1 Download

Currently yocto-ubinux is managed on Github. You can get from there.
```
$ git clone https://github.com/ubinux/yocto-ubinux.git
```

Note
  - Modify the value of the DOWNLOADS variable in the file setup_ubinux.sh to specify the download directory.

## 2.2 Build environment

Please refer to the build environment of poky3.0.
Ubuntu 18.04 is recommended.
More than 100g space needs to be prepared for build.

# 3. Usage
## 3.1 Download repos
```
$ cd yocto-ubinux/
$ ./meta-ubinux/scripts/checkoutmetas.py
```

## 3.2 Set up build environment
```
$ . setup_ubinux.sh ${machine} ${build_dir}
```
Note
  - ${machine} - the config file’s name of each arch
  ```
  $ cd meta-ubinux/conf/machine
  $ ls
  ubinux-armv8.conf
  ubinux-x86-64.conf
  ```
  - ${build_dir} - build directory of ubinux and it's set by the user
  - The multlib option is enabled in ubinux-armv8.conf, so if you compile this machine, it will actually compile aarch64 and armv7 together.

Example
set up build environment of X86_64
```
$ . setup_ubinux.sh ubinux-x86-64 ../build-ubinux-x86-64
```
  - You can enter the build directory to set the environment variables.
    ```
    $ cd ${build_dir}
    $ vi conf/local.conf
    ```
  - You can find the explanation of environment variables from https://wiki.yoctoproject.org/wiki/Main_Page

## 3.3 Generate toolchain
Enter the build directory to generate the toolchain of the specified arch.
```
$ bitbake meta-toolchain
```
Note
  - The toolchains of each arch are stored in the corresponding directory of ${build_dir}/tmp/deploy/sdk/

## 3.4 Generate image
Enter the build directory to generate the image of the specified arch.
```
$ cd ${build_dir}
$ bitbake ubinux-all
```
Note
  - The rpms of each arch are stored in the corresponding directory of ${build_dir}/tmp/deploy/rpm
  - Using dnf-plugin-tui(https://github.com/ubinux/dnf-plugin-tui) in toolchain generated in Chapter 3.4 to generate image.
