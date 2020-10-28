# ubinux-2020.10 Release Notes

FUJITSU COMPUTER TECHNOLOGIES LIMITED
Solution Development Dept. Software Div.

## 1. Basic Information
### 1.1 Version Information
- Yocto: 3.1
- Kernel: 5.4.71
- Kernel for Layerscape: 5.4.3
- Toolchain
  - GCC: 10.2.0
  - Binutils: 2.35
  - glibc: 2.32
  - GDB: 9.2
- License Files Format: SPDX 2.1

### 1.2 CPU Architecture Support
- x86 (64bit)
- Armv8 (64bit EL, 32bit EL)
- Armv7

### 1.3 Host OS Support
- Ubuntu 20.04 LTS (64bit)

### 1.4 U-Boot for Layerscape Support
- NXP Layerscape SDK v20.04 (U-Boot v2019.10)

## 2. Features
### 2.1 Security Fixes
Following security issues have been fixed from ubinux-2020.09.

bind:
- CVE-2020-8620
- CVE-2020-8622
- CVE-2020-8623
- CVE-2020-8624

cifs-utils:
- CVE-2020-14342

ghostscript:
- CVE-2019-10216

gnupg:
- CVE-2020-25125

gnutls:
- CVE-2020-24659

libxml2:
- CVE-2020-24977

php:
- CVE-2020-7065

postgresql:
- CVE-2020-14349
- CVE-2020-14350

ubinux-kernel:
- CVE-2018-1000026
- CVE-2020-8647

ubinux-kernel-lsdk:
- CVE-2018-1000026

xserver-xorg:
- CVE-2020-14347

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2020.10 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL) and Arm7|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2020.10.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL) and Arm7|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2020.10/environment-setup-[TYPE2]`

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

** Unpatched list **
bash:
- CVE-2016-7543
- CVE-2016-9401
- CVE-2019-18276
- CVE-2019-9924

bind:
- CVE-2017-3139
- CVE-2019-6470

cairo:
- CVE-2013-0800
- CVE-2013-6425

coreutils:
- CVE-2009-4135
- CVE-2015-4041
- CVE-2015-4042
- CVE-2017-18018

cpio:
- CVE-2019-14866

cups:
- CVE-2012-6094

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

flex:
- CVE-2019-6293

fuse:
- CVE-2019-14860

ghostscript:
- CVE-2013-6629
- CVE-2018-18073

glibc:
- CVE-2019-1010022
- CVE-2019-1010023
- CVE-2019-1010024
- CVE-2019-1010025
- CVE-2020-1752

gnutls:
- CVE-2018-10844
- CVE-2018-10845
- CVE-2018-10846
- CVE-2018-16868

groff:
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

librsvg:
- CVE-2019-20446

libuser:
- CVE-2012-5644

libxml2:
- CVE-2016-4614
- CVE-2016-9598

linux-qoriq:
- CVE-2014-8171
- CVE-2017-1000377
- CVE-2017-5897
- CVE-2018-1000026
- CVE-2018-10840
- CVE-2018-10876
- CVE-2018-10882
- CVE-2018-10902
- CVE-2018-14625
- CVE-2018-16884
- CVE-2018-5873
- CVE-2019-10126
- CVE-2019-14899
- CVE-2019-19947
- CVE-2019-19965
- CVE-2019-20636
- CVE-2019-20794
- CVE-2019-20810
- CVE-2019-20812
- CVE-2019-3016
- CVE-2019-3819
- CVE-2019-3846
- CVE-2020-10690
- CVE-2020-10711
- CVE-2020-10732
- CVE-2020-10757
- CVE-2020-10766
- CVE-2020-10767
- CVE-2020-10768
- CVE-2020-10781
- CVE-2020-10942
- CVE-2020-11494
- CVE-2020-11565
- CVE-2020-11608
- CVE-2020-11609
- CVE-2020-11668
- CVE-2020-11725
- CVE-2020-12464
- CVE-2020-12465
- CVE-2020-12652
- CVE-2020-12653
- CVE-2020-12654
- CVE-2020-12655
- CVE-2020-12656
- CVE-2020-12657
- CVE-2020-12659
- CVE-2020-12768
- CVE-2020-12769
- CVE-2020-12770
- CVE-2020-12771
- CVE-2020-12826
- CVE-2020-12888
- CVE-2020-13143
- CVE-2020-13974
- CVE-2020-14314
- CVE-2020-14331
- CVE-2020-14356
- CVE-2020-14385
- CVE-2020-14386
- CVE-2020-14390
- CVE-2020-14416
- CVE-2020-15393
- CVE-2020-15780
- CVE-2020-16166
- CVE-2020-1749
- CVE-2020-24394
- CVE-2020-25211
- CVE-2020-25212
- CVE-2020-25284
- CVE-2020-25285
- CVE-2020-25641
- CVE-2020-26088
- CVE-2020-26541
- CVE-2020-8428
- CVE-2020-8647
- CVE-2020-8648
- CVE-2020-8649
- CVE-2020-8834
- CVE-2020-8992
- CVE-2020-9383

lua:
- CVE-2019-6706
- CVE-2020-15889
- CVE-2020-24342

lxc:
- CVE-2019-5736

mcpp:
- CVE-2019-14274

nettle:
- CVE-2016-6489
- CVE-2018-16869

ntp:
- CVE-2019-11331

openjpeg:
- CVE-2019-12973

opensc:
- CVE-2019-19479
- CVE-2019-19480
- CVE-2019-19481
- CVE-2020-26570
- CVE-2020-26571
- CVE-2020-26572

openssh:
- CVE-2014-9278

patch:
- CVE-2019-20633

php:
- CVE-2020-7064
- CVE-2020-7069
- CVE-2020-7070

pixman:
- CVE-2013-0800

procmail:
- CVE-2014-3618
- CVE-2017-16844

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
- CVE-2020-1472

shadow:
- CVE-2013-4235

tiff:
- CVE-2015-7313

trousers:
- CVE-2019-18898
- CVE-2020-24330
- CVE-2020-24331
- CVE-2020-24332

ubinux-kernel:
- CVE--2017-1000377
- CVE--2019-14899
- CVE--2019-20794
- CVE--2019-3016
- CVE--2020-11725
- CVE--2020-12656
- CVE--2020-12888
- CVE--2020-25211
- CVE--2020-25284
- CVE--2020-26541

ubinux-kernel-lsdk:
- CVE--2017-1000377
- CVE--2018-10840
- CVE--2018-10882
- CVE--2018-14625
- CVE--2019-3016
- CVE--2019-3819
- CVE--2019-10126
- CVE--2019-14899
- CVE--2019-19947
- CVE--2019-19965
- CVE--2019-20636
- CVE--2019-20794
- CVE--2019-20810
- CVE--2019-20812
- CVE--2020-1749
- CVE--2020-8428
- CVE--2020-8647
- CVE--2020-8648
- CVE--2020-8649
- CVE--2020-8992
- CVE--2020-9383
- CVE--2020-10690
- CVE--2020-10711
- CVE--2020-10732
- CVE--2020-10757
- CVE--2020-10766
- CVE--2020-10767
- CVE--2020-10768
- CVE--2020-10781
- CVE--2020-10942
- CVE--2020-11494
- CVE--2020-11565
- CVE--2020-11608
- CVE--2020-11609
- CVE--2020-11668
- CVE--2020-11725
- CVE--2020-12464
- CVE--2020-12465
- CVE--2020-12652
- CVE--2020-12653
- CVE--2020-12654
- CVE--2020-12655
- CVE--2020-12656
- CVE--2020-12657
- CVE--2020-12659
- CVE--2020-12768
- CVE--2020-12769
- CVE--2020-12770
- CVE--2020-12771
- CVE--2020-12826
- CVE--2020-12888
- CVE--2020-13143
- CVE--2020-13974
- CVE--2020-14314
- CVE--2020-14331
- CVE--2020-14356
- CVE--2020-14385
- CVE--2020-14386
- CVE--2020-14390
- CVE--2020-14416
- CVE--2020-15393
- CVE--2020-15780
- CVE--2020-16166
- CVE--2020-24394
- CVE--2020-25211
- CVE--2020-25212
- CVE--2020-25284
- CVE--2020-25285
- CVE--2020-25641
- CVE--2020-26088
- CVE--2020-26541

wireshark:
- CVE-2020-25862
- CVE-2020-25863
- CVE-2020-25866

xrdp:
- CVE-2020-4044

zabbix:
- CVE-2020-15803

zip:
- CVE-2018-13410

## 7. Contact us
If you find an issue in ubinux, you should report it in the issue tracker on GitHub.
