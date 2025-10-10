# ubinux-2025.10 Release Notes

OSS x AI Technology Div.  
Fujitsu Limited  

## 1. Basic Information
### 1.1 Version Information
- Yocto: 5.3
- Kernel: 6.12.47
- Toolchain
  - GCC: 15.2.0
  - Binutils: 2.45
  - glibc: 2.42
  - GDB: 16.3
- License Files Format: SPDX 2.3

### 1.2 CPU Architecture Support
- x86 (64bit, 32bit Mulitlib)
- Armv8 (64bit EL, 32bit Mulitlib)

### 1.3 Tested reference boards
- NXP FRWY-LS1046A
- NXP Layerscape LS1088A-RDB
- NXP Layerscape LX2160A-RDB
- Lenovo QiTian M4550 (Processor: Core i5-4570)

### 1.4 Host OS Support
- Ubuntu 24.04 LTS (64bit)

### 1.5 U-Boot and firmware Support
- NXP Layerscape SDK v21.08 (U-Boot v2021.04)

## 2. Features
### 2.1 Security Fixes
Following security issues have been fixed from ubinux-2025.09.

samba:
- CVE-2021-3670
- CVE-2022-1615
- CVE-2022-32743

gnutls:
- CVE-2025-32989
- CVE-2025-32990

icu:
- CVE-2025-5222

ubinux-kernel:
- CVE-2025-37925

vim:
- CVE-2025-53905
- CVE-2025-53906

### 2.2 Added packages

- babeltrace2
- freeradius

### 2.3 Removed packages

- babeltrace
- xf86-input-mouse

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2025.10 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL)|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2025.10.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL)|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2025.10/environment-setup-[TYPE2]`

### 3.3 Create rootfs from Userland Packages
To create rootfs, see Section 3.1.2 and 3.1.3 of the dnf-plugin-tui documentation.  
https://github.com/ubinux/dnf-plugin-tui/blob/dc41277946edbca76e375a72e4c0babd38d71d35/README.md#312-initialize

## 4. Notice
### 4.1 Kernel
Enable some kernel configs to use following features.
- systemd
  - CONFIG_CGROUPS
  - CONFIG_FHANDLE
- Booting with UEFI
  - CONFIG_EFI_STUB
- Display Console in some environments (x86_64 only)
  - CONFIG_DRM_FBDEV_EMULATION

### 4.2 Userland Packages

N/A

### 4.3 Tools

- Kernel Build  
  Use "make nconfig" instead of "make meunconfig"  
  Please contact us if you want to use "make menuconfig"

### 4.4 validation
The following objects are not validated because the hardware of the test environment does not support them:

#### 4.4.1 X86_64
- ipmi
- tcsd
- edac-util
- mdadm

#### 4.4.2 Armv8
- smartd
- hostapd
- ipmi
- resizecons
- lm_sensors
- cpufreq-aperf
- busybox devmem
- busybox setkeycodes
- cransh-cross-canadian
- mdadm
- dool
- tiptop

## 5. Known Security Issues
The following security issues were known in this release:  

cups:
- CVE-2025-58060
- CVE-2025-58364

db:
- CVE-2016-0682
- CVE-2016-0689
- CVE-2016-0692
- CVE-2016-0694
- CVE-2016-3418

dovecot:
- CVE-2022-30550

exiv2:
- CVE-2025-26623
- CVE-2025-54080
- CVE-2025-55304

glibc:
- CVE-2010-4756

hdf5:
- CVE-2018-17433
- CVE-2018-17436
- CVE-2019-8396
- CVE-2020-10809
- CVE-2020-10812
- CVE-2025-2912
- CVE-2025-2913
- CVE-2025-2914
- CVE-2025-2915
- CVE-2025-2923
- CVE-2025-2924
- CVE-2025-2925
- CVE-2025-2926
- CVE-2025-6269
- CVE-2025-6270
- CVE-2025-6516

jasper:
- CVE-2025-8835
- CVE-2025-8836
- CVE-2025-8837

libpcre2:
- CVE-2025-58050

libraw:
- CVE-2025-43961
- CVE-2025-43962
- CVE-2025-43963
- CVE-2025-43964

libsndfile1:
- CVE-2024-50613
- CVE-2025-52194

libssh:
- CVE-2025-8114

libuser:
- CVE-2012-5644

libvirt:
- CVE-2023-3750

libxslt:
- CVE-2025-7424

openjpeg:
- CVE-2023-39327
- CVE-2023-39328
- CVE-2023-39329

openvswitch:
- CVE-2019-25076

php:
- CVE-2024-3566

polkit:
- CVE-2016-2568

qemu:
- CVE-2023-1386
- CVE-2024-8354
- CVE-2024-6519

qtbase:
- CVE-2023-51714
- CVE-2024-36048
- CVE-2024-39936
- CVE-2025-30348

rpm:
- CVE-2021-35937

samba:
- CVE-2022-38023
- CVE-2023-37369

sqlite3:
- CVE-2025-29087
- CVE-2025-3277
- CVE-2025-6965

sysstat:
- CVE-2022-39377

tiff:
- CVE-2023-1916
- CVE-2025-8961
- CVE-2025-9165

tigervnc:
- CVE-2014-8241
- CVE-2023-6377
- CVE-2023-6478
- CVE-2025-26594
- CVE-2025-26595
- CVE-2025-26596
- CVE-2025-26597
- CVE-2025-26598
- CVE-2025-26599
- CVE-2025-26600
- CVE-2025-26601

ubinux-kernel:
- CVE-2007-4998
- CVE-2008-4609
- CVE-2010-4563
- CVE-2019-14899
- CVE-2020-35501
- CVE-2021-3714
- CVE-2021-3847
- CVE-2021-3864
- CVE-2022-0400
- CVE-2022-1247
- CVE-2022-25265
- CVE-2022-2961
- CVE-2022-38096
- CVE-2022-4543
- CVE-2023-23039
- CVE-2023-26242
- CVE-2023-3397
- CVE-2023-3640
- CVE-2023-4010
- CVE-2023-6238
- CVE-2023-6240
- CVE-2023-6535
- CVE-2024-24864
- CVE-2024-25740
- CVE-2024-57995
- CVE-2024-58097
- CVE-2025-21751
- CVE-2025-21833
- CVE-2025-21949
- CVE-2025-37860
- CVE-2025-40014

xrdp:
- CVE-2022-23468
- CVE-2022-23477
- CVE-2022-23478
- CVE-2022-23479
- CVE-2022-23480
- CVE-2022-23481
- CVE-2022-23482
- CVE-2022-23483
- CVE-2022-23484
- CVE-2022-23493
- CVE-2023-40184
- CVE-2023-42822
- CVE-2024-39917

xserver-xorg:
- CVE-2023-1393

## 6. Contact us
If you find an issue in ubinux, you should report it in the issue tracker on GitHub.
