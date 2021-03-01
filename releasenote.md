# ubinux-2021.02 Release Notes

FUJITSU COMPUTER TECHNOLOGIES LIMITED
Solution Development Dept. Software Div.

## 1. Basic Information
### 1.1 Version Information
- Yocto: 3.2
- Kernel: 5.4.91
- Kernel for Layerscape: 5.4.47
- Toolchain
  - GCC: 10.2.0
  - Binutils: 2.35
  - glibc: 2.32
  - GDB: 10.1
- License Files Format: SPDX 2.2

### 1.2 CPU Architecture Support
- x86 (64bit)
- Armv8 (64bit EL, 32bit EL)
- Armv7

### 1.3 Host OS Support
- Ubuntu 20.04 LTS (64bit)

### 1.4 U-Boot for Layerscape Support
- NXP Layerscape SDK v20.12 (U-Boot v2020.04)

## 2. Features
### 2.1 Security Fixes
Following security issues have been fixed from ubinux-2021.01.

curl:
- CVE-2020-8285
- CVE-2020-8286

f2fs-tools:
- CVE-2020-6104
- CVE-2020-6105
- CVE-2020-6106
- CVE-2020-6107
- CVE-2020-6108

glibc:
- CVE-2020-29562

librsvg:
- CVE-2019-20446

lua:
- CVE-2020-15889

mcpp:
- CVE-2019-14274

openjpeg:
- CVE-2019-12973

openssl:
- CVE-2020-1971

patch:
- CVE-2019-20633

php:
- CVE-2020-7069
- CVE-2020-7070

postgresql:
- CVE-2020-25694
- CVE-2020-25695
- CVE-2020-25696

pulseaudio:
- CVE-2020-15710

qemu:
- CVE-2020-15863
- CVE-2020-25723
- CVE-2020-25742
- CVE-2020-25743
- CVE-2020-27821

samba:
- CVE-2020-14318
- CVE-2020-14383

ubinux-kernel:
- CVE-2019-3016
- CVE-2019-20794
- CVE-2020-11725
- CVE-2020-12656
- CVE-2020-12888
- CVE-2020-14351
- CVE-2020-25211
- CVE-2020-25284
- CVE-2020-26541
- CVE-2020-27152
- CVE-2020-27194
- CVE-2020-27673
- CVE-2020-27675
- CVE-2020-28941
- CVE-2020-29372
- CVE-2020-29660

ubinux-kernel-lsdk:
- CVE-2019-3016
- CVE-2019-20794
- CVE-2019-20810
- CVE-2020-10781
- CVE-2020-11725
- CVE-2020-12655
- CVE-2020-12656
- CVE-2020-12771
- CVE-2020-12888
- CVE-2020-14314
- CVE-2020-14331
- CVE-2020-14351
- CVE-2020-14356
- CVE-2020-14385
- CVE-2020-14386
- CVE-2020-14390
- CVE-2020-14416
- CVE-2020-15393
- CVE-2020-15436
- CVE-2020-15437
- CVE-2020-15780
- CVE-2020-16166
- CVE-2020-24394
- CVE-2020-25211
- CVE-2020-25212
- CVE-2020-25284
- CVE-2020-25285
- CVE-2020-25641
- CVE-2020-25643
- CVE-2020-25645
- CVE-2020-25656
- CVE-2020-25704
- CVE-2020-25705
- CVE-2020-26088
- CVE-2020-26541
- CVE-2020-27152
- CVE-2020-27194
- CVE-2020-27673
- CVE-2020-27675
- CVE-2020-28915
- CVE-2020-28941
- CVE-2020-28974
- CVE-2020-29368
- CVE-2020-29369
- CVE-2020-29371
- CVE-2020-29372
- CVE-2020-29660
- CVE-2020-29661

xrdp:
- CVE-2020-4044

zabbix:
- CVE-2020-15803

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2021.02 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL) and Arm7|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2021.02.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL) and Arm7|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2021.02/environment-setup-[TYPE2]`

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

### 4.2 validation
The following objects are not validated because the hardware of the test environment does not support them:

#### 4.2.1 X86_64
- ipmi
- tcsd
- edac-util

#### 4.2.2 Armv8, Armv7
- smartd
- hostapd
- ipmi
- resizecons
- lm_sensors
- cpufreq-aperf
- busybox devmem
- busybox setkeycodes

## 5. Known Security Issues
The following security issues were known in this release:

bash:
- CVE-2016-7543
- CVE-2016-9401
- CVE-2019-18276
- CVE-2019-9924

bind:
- CVE-2017-3139
- CVE-2019-6470

bluez5:
- CVE-2020-12351
- CVE-2020-12352

cairo:
- CVE-2013-0800

coreutils:
- CVE-2009-4135
- CVE-2014-9471
- CVE-2015-4041
- CVE-2015-4042
- CVE-2016-2781
- CVE-2017-18018

cpio:
- CVE-2019-14866

db:
- CVE-2016-0682
- CVE-2016-0689
- CVE-2016-0692
- CVE-2016-0694
- CVE-2016-3418

dovecot:
- CVE-2019-19722
- CVE-2020-10957
- CVE-2020-10958
- CVE-2020-10967
- CVE-2020-12100
- CVE-2020-12673
- CVE-2020-12674
- CVE-2020-24386
- CVE-2020-25275

ecryptfs-utils:
- CVE-2016-1572

ffmpeg:
- CVE-2020-35964
- CVE-2020-35965

flex:
- CVE-2019-6293

fuse:
- CVE-2019-14860

ghostscript:
- CVE-2013-6629

glibc:
- CVE-2010-4756
- CVE-2019-1010022
- CVE-2019-1010023
- CVE-2019-1010024
- CVE-2019-1010025
- CVE-2020-1752

groff:
- CVE-2000-0803
- CVE-2009-5044
- CVE-2009-5080
- CVE-2009-5081

gzip:
- CVE-2010-0001

hdf5:
- CVE-2020-10809
- CVE-2020-10810
- CVE-2020-10811
- CVE-2020-10812

libcroco:
- CVE-2020-12825

libesmtp:
- CVE-2019-19977

libuser:
- CVE-2012-5644

libvirt:
- CVE-2014-8135
- CVE-2014-8136
- CVE-2015-5313
- CVE-2018-5748
- CVE-2020-25637

libxcrypt:
- CVE-2008-3188

lua:
- CVE-2019-6706
- CVE-2020-24342

mariadb:
- CVE-2020-28912

ntp:
- CVE-2019-11331

php:
- CVE-2007-2728

pixman:
- CVE-2013-0800

polkit:
- CVE-2016-2568

poppler:
- CVE-2020-35702

procmail:
- CVE-1999-0475
- CVE-2014-3618
- CVE-2017-16844

qemu:
- CVE-2018-18438

qtbase:
- CVE-2020-17507

qtdeclarative:
- CVE-2020-17507

qtlocation:
- CVE-2020-17507

qtmultimedia:
- CVE-2020-17507

qtquickcontrols:
- CVE-2020-17507

qtscript:
- CVE-2020-17507

qtsensors:
- CVE-2020-17507

qtsvg:
- CVE-2020-17507

qttools:
- CVE-2020-17507

qtwebchannel:
- CVE-2020-17507

qtwebkit:
- CVE-2020-17507

qtwebsockets:
- CVE-2020-17507

qtxmlpatterns:
- CVE-2020-17507

quagga:
- CVE-2016-4049

samba:
- CVE-2018-1050
- CVE-2018-1057

shadow:
- CVE-2013-4235

strace:
- CVE-2000-0006

tcpdump:
- CVE-2020-8037

tiff:
- CVE-2015-7313

trousers:
- CVE-2019-18898
- CVE-2020-24330
- CVE-2020-24331
- CVE-2020-24332

ubinux-kernel:
- CVE-2017-1000377
- CVE-2019-14899
- CVE-2019-3016

ubinux-kernel-lsdk:
- CVE-2017-1000377
- CVE-2019-14899
- CVE-2019-3016
- CVE-2020-36158

uw-imap:
- CVE-2005-0198

wireshark:
- CVE-2020-26418
- CVE-2020-26420
- CVE-2020-26421
- CVE-2020-26575
- CVE-2020-28030

xterm:
- CVE-1999-0965

zip:
- CVE-2018-13410

## 7. Contact us
If you find an issue in ubinux, you should report it in the issue tracker on GitHub.
