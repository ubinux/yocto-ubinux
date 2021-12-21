# ubinux-2021.11 Release Notes

FUJITSU LIMITED
FCT Group
Solution Development Dept. Software Div.

## 1. Basic Information
### 1.1 Version Information
- Yocto: 3.4
- Kernel: 5.10.77
- Kernel for Layerscape: 5.10.35
- Kernel for MPSoC: 5.10.0
- Toolchain
  - GCC: 11.2.0
  - Binutils: 2.37
  - glibc: 2.34
  - GDB: 10.2
- License Files Format: SPDX 2.2

### 1.2 CPU Architecture Support
- x86 (64bit)
- Armv8 (64bit EL, 32bit EL)
- Armv7

### 1.3 Tested reference boards
- NXP Layerscape LS1046A-RDB
- NXP Layerscape LX2160A-RDB
- Lenovo QiTian M4550 (Processor: Core i5-4570)
- Xilinx Zynq UltraScale+ MPSoC ZCU104

### 1.4 Host OS Support
- Ubuntu 20.04 LTS (64bit)

### 1.5 U-Boot for Layerscape Support
- NXP Layerscape SDK v21.08 (U-Boot v2021.04)

## 2. Features
### 2.1 Security Fixes
Following security issues have been fixed from ubinux-2021.10.

libgcrypt:
- CVE-2021-40528

lua:
- CVE-2020-15945

sqlite3:
- CVE-2021-36690

wget:
- CVE-2021-31879

### 2.2 Added packages
- libstd-rs
- python3-pyzmq

### 2.3 Removed packages

N/A

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2021.11 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL) and Arm7|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2021.11.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL) and Arm7|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2021.11/environment-setup-[TYPE2]`

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

### 4.2 Userland Packages

N/A

### 4.3 validation
The following objects are not validated because the hardware of the test environment does not support them:

#### 4.3.1 X86_64
- ipmi
- tcsd
- edac-util

#### 4.3.2 Armv8, Armv7
- smartd
- hostapd
- ipmi
- resizecons
- lm_sensors
- cpufreq-aperf
- busybox devmem
- busybox setkeycodes
- cransh-cross-canadian

## 5. Known Security Issues
The following security issues were known in this release:

bash:
- CVE-2016-7543
- CVE-2016-9401
- CVE-2019-18276
- CVE-2019-9924

coreutils:
- CVE-2009-4135
- CVE-2014-9471
- CVE-2015-4041
- CVE-2015-4042
- CVE-2016-2781
- CVE-2017-18018

cpio:
- CVE-2019-14866
- CVE-2021-38185

db:
- CVE-2016-0682
- CVE-2016-0689
- CVE-2016-0692
- CVE-2016-0694
- CVE-2016-3418

dovecot:
- CVE-2020-28200
- CVE-2021-29157
- CVE-2021-33515

ecryptfs-utils:
- CVE-2016-1572

exiv2:
- CVE-2007-6353
- CVE-2021-29623
- CVE-2021-31292
- CVE-2021-32617
- CVE-2021-32815
- CVE-2021-34334
- CVE-2021-34335
- CVE-2021-37615
- CVE-2021-37616
- CVE-2021-37618
- CVE-2021-37619
- CVE-2021-37620
- CVE-2021-37621
- CVE-2021-37622
- CVE-2021-37623

fetchmail:
- CVE-2021-39272

glibc:
- CVE-2010-4756

groff:
- CVE-2009-5044
- CVE-2009-5078
- CVE-2009-5079
- CVE-2009-5080
- CVE-2009-5081

gzip:
- CVE-2009-2624
- CVE-2010-0001

hdf5:
- CVE-2018-17233
- CVE-2018-17234
- CVE-2018-17237
- CVE-2018-17432
- CVE-2018-17433
- CVE-2018-17434
- CVE-2018-17435
- CVE-2018-17436
- CVE-2018-17437
- CVE-2018-17438
- CVE-2019-8396 
- CVE-2020-10809
- CVE-2020-10810
- CVE-2020-10811
- CVE-2020-10812

jansson:
- CVE-2020-36325

libarchive:
- CVE-2021-36976

libesmtp:
- CVE-2019-19977

libsdl:
- CVE-2020-14409
- CVE-2020-14410

libuser:
- CVE-2012-5644

libzip:
- CVE-2017-12858

lua:
- CVE-2020-15945

ncurses:
- CVE-2021-39537

ntp:
- CVE-2015-5146
- CVE-2015-5300
- CVE-2015-7975
- CVE-2015-7976
- CVE-2015-7977
- CVE-2015-7978
- CVE-2015-7979
- CVE-2015-8138
- CVE-2015-8139
- CVE-2015-8140
- CVE-2015-8158
- CVE-2016-1547
- CVE-2016-2516
- CVE-2016-2517
- CVE-2016-2519
- CVE-2016-7429
- CVE-2016-7433
- CVE-2016-9310
- CVE-2016-9311
- CVE-2019-11331

openjpeg:
- CVE-2016-7163
- CVE-2016-9675
- CVE-2021-29338

openssh:
- CVE-2016-20012
- CVE-2021-41617

openvswitch:
- CVE-2020-27827
- CVE-2020-35498
- CVE-2021-36980

php:
- CVE-2007-2728
- CVE-2007-3205
- CVE-2007-4596
- CVE-2021-21703
- CVE-2021-21706

polkit:
- CVE-2016-2568

procmail:
- CVE-1999-0475
- CVE-2014-3618
- CVE-2017-16844

qtbase:
- CVE-2021-38593

quagga:
- CVE-2016-4049
- CVE-2017-3224

samba:
- CVE-2018-1050
- CVE-2018-1057

sblim-sfcb:
- CVE-2012-3381

strace:
- CVE-2000-0006

tcl:
- CVE-2021-35331

tigervnc:
- CVE-2014-8241

ubinux-kernel:
- CVE-1999-0524
- CVE-1999-0656
- CVE-2007-4998
- CVE-2008-4609
- CVE-2010-4563
- CVE-2011-0640
- CVE-2017-1000377
- CVE-2019-14899
- CVE-2020-16119
- CVE-2020-16120
- CVE-2021-20226
- CVE-2021-32078
- CVE-2021-3655
- CVE-2021-42327
- CVE-2021-42739

ubinux-kernel-lsdk:
- CVE-1999-0524
- CVE-1999-0656
- CVE-2007-4998
- CVE-2008-4609
- CVE-2010-4563
- CVE-2011-0640
- CVE-2017-1000377
- CVE-2019-14899
- CVE-2020-16119
- CVE-2020-16120
- CVE-2021-20226
- CVE-2021-23133
- CVE-2021-23134
- CVE-2021-28691
- CVE-2021-32078
- CVE-2021-32399
- CVE-2021-33034
- CVE-2021-33200
- CVE-2021-33624
- CVE-2021-33909
- CVE-2021-34556
- CVE-2021-34693
- CVE-2021-3489
- CVE-2021-3490
- CVE-2021-3491
- CVE-2021-35039
- CVE-2021-3506
- CVE-2021-35477
- CVE-2021-3564
- CVE-2021-3573
- CVE-2021-3653
- CVE-2021-3655
- CVE-2021-3679
- CVE-2021-37159
- CVE-2021-38160
- CVE-2021-38166
- CVE-2021-38198
- CVE-2021-38199
- CVE-2021-38204
- CVE-2021-38205
- CVE-2021-38206
- CVE-2021-38207
- CVE-2021-38208
- CVE-2021-40490
- CVE-2021-41073
- CVE-2021-41864
- CVE-2021-42008
- CVE-2021-42252
- CVE-2021-42327
- CVE-2021-42739

uw-imap:
- CVE-2005-0198
- CVE-2018-19518

xdg-utils:
- CVE-2020-27748

xterm:
- CVE-1999-0965

## 6. Contact us
If you find an issue in ubinux, you should report it in the issue tracker on GitHub.
