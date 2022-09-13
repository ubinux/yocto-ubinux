# ubinux-2022.09 Release Notes

FUJITSU LIMITED
LINUX DEVELOPMENT DIV. APPLIANCE ENGINEERING DEPT.

## 1. Basic Information
### 1.1 Version Information
- Yocto: 4.1
- Kernel: 5.10.136
- Kernel for Layerscape: 5.10.35
- Kernel for MPSoC: 5.10.0
- Toolchain
  - GCC: 12.1.0
  - Binutils: 2.38
  - glibc: 2.35
  - GDB: 12.1
- License Files Format: SPDX 2.2

### 1.2 CPU Architecture Support
- x86 (64bit, 32bit Mulitlib)
- Armv8 (64bit EL, 32bit EL)
- Armv7

### 1.3 Tested reference boards
- NXP Layerscape LS1043A-RDB
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
Following security issues have been fixed from ubinux-2022.08.

gnupg:
- CVE-2022-34903

lua:
- CVE-2022-33099

mariadb:
- CVE-2022-27444
- CVE-2022-27446
- CVE-2022-27452

php:
- CVE-2007-2728
- CVE-2007-3205
- CVE-2007-4596

protobuf-c:
- CVE-2022-33070

sblim-sfcb:
- CVE-2012-3381

tiff:
- CVE-2022-2056
- CVE-2022-2057
- CVE-2022-2058

uw-imap:
- CVE-2005-0198

xrdp:
- CVE-2022-23613

### 2.2 Added packages

N/A

### 2.3 Removed packages

- xf86-input-keyboard

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2022.09 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL) and Arm7|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2022.09.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL) and Arm7|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2022.09/environment-setup-[TYPE2]`

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

### 4.3 Tools

N/A

### 4.4 validation
The following objects are not validated because the hardware of the test environment does not support them:

#### 4.4.1 X86_64
- ipmi
- tcsd
- edac-util
- mdadm

#### 4.4.2 Armv8, Armv7
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

## 5. Known Security Issues
The following security issues were known in this release:

db:
- CVE-2016-0682
- CVE-2016-0689
- CVE-2016-0692
- CVE-2016-0694
- CVE-2016-3418

dnsmasq:
- CVE-2021-45951
- CVE-2021-45952
- CVE-2021-45953
- CVE-2021-45954
- CVE-2021-45955
- CVE-2021-45956
- CVE-2021-45957

dovecot:
- CVE-2020-28200
- CVE-2021-29157
- CVE-2021-33515
- CVE-2022-30550

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

glibc:
- CVE-2010-4756

gnutls:
- CVE-2022-2509

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

libsdl:
- CVE-2020-14409
- CVE-2020-14410
- CVE-2022-34568

libtirpc:
- CVE-2021-46828

libuser:
- CVE-2012-5644

libxml2:
- CVE-2016-3709

ntp:
- CVE-2019-11331

openjpeg:
- CVE-2015-1239
- CVE-2016-9675

polkit:
- CVE-2016-2568

procmail:
- CVE-1999-0475
- CVE-2014-3618
- CVE-2017-16844

qtbase:
- CVE-2021-38593
- CVE-2022-25255

quagga:
- CVE-2017-3224
- CVE-2021-44038

rsync:
- CVE-2022-29154

samba:
- CVE-2021-44141

sqlite3:
- CVE-2022-35737

strace:
- CVE-2000-0006

tiff:
- CVE-2022-34526

tigervnc:
- CVE-2014-8241

ubinux-kernel:
- CVE-1999-0524
- CVE-1999-0656
- CVE-2007-4998
- CVE-2008-4609
- CVE-2010-4563
- CVE-2017-1000377
- CVE-2019-14899
- CVE-2020-16119
- CVE-2020-16120
- CVE-2020-35501
- CVE-2021-32078
- CVE-2021-3655
- CVE-2021-3773
- CVE-2021-3847
- CVE-2021-4148
- CVE-2021-42327
- CVE-2021-44879
- CVE-2022-0500
- CVE-2022-0854
- CVE-2022-1462
- CVE-2022-1882
- CVE-2022-23222
- CVE-2022-25265

ubinux-kernel-lsdk:
- CVE-1999-0524
- CVE-1999-0656
- CVE-2007-4998
- CVE-2008-4609
- CVE-2010-4563
- CVE-2017-1000377
- CVE-2019-14899
- CVE-2020-16119
- CVE-2020-16120
- CVE-2020-24586
- CVE-2020-24587
- CVE-2020-26147
- CVE-2020-26558
- CVE-2020-27820
- CVE-2020-35501
- CVE-2021-20321
- CVE-2021-20322
- CVE-2021-22600
- CVE-2021-23133
- CVE-2021-23134
- CVE-2021-28691
- CVE-2021-28714
- CVE-2021-28715
- CVE-2021-32078
- CVE-2021-32399
- CVE-2021-33034
- CVE-2021-33200
- CVE-2021-33624
- CVE-2021-33656
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
- CVE-2021-3609
- CVE-2021-3640
- CVE-2021-3653
- CVE-2021-3655
- CVE-2021-3656
- CVE-2021-3679
- CVE-2021-37159
- CVE-2021-3732
- CVE-2021-3739
- CVE-2021-3744
- CVE-2021-3752
- CVE-2021-3753
- CVE-2021-3772
- CVE-2021-3773
- CVE-2021-38160
- CVE-2021-38166
- CVE-2021-38198
- CVE-2021-38199
- CVE-2021-38204
- CVE-2021-38205
- CVE-2021-38206
- CVE-2021-38207
- CVE-2021-38208
- CVE-2021-3847
- CVE-2021-4001
- CVE-2021-4002
- CVE-2021-40490
- CVE-2021-4083
- CVE-2021-41073
- CVE-2021-4135
- CVE-2021-4148
- CVE-2021-4149
- CVE-2021-4154
- CVE-2021-4157
- CVE-2021-41864
- CVE-2021-4197
- CVE-2021-42008
- CVE-2021-4202
- CVE-2021-4203
- CVE-2021-42252
- CVE-2021-42327
- CVE-2021-42739
- CVE-2021-43267
- CVE-2021-43389
- CVE-2021-43975
- CVE-2021-43976
- CVE-2021-44733
- CVE-2021-44879
- CVE-2021-45095
- CVE-2021-45402
- CVE-2021-45469
- CVE-2021-45485
- CVE-2021-45486
- CVE-2021-45868
- CVE-2021-46283
- CVE-2022-0185
- CVE-2022-0286
- CVE-2022-0322
- CVE-2022-0330
- CVE-2022-0435
- CVE-2022-0487
- CVE-2022-0492
- CVE-2022-0494
- CVE-2022-0500
- CVE-2022-0617
- CVE-2022-0847
- CVE-2022-0854
- CVE-2022-0995
- CVE-2022-0998
- CVE-2022-1011
- CVE-2022-1012
- CVE-2022-1048
- CVE-2022-1055
- CVE-2022-1195
- CVE-2022-1353
- CVE-2022-1462
- CVE-2022-1652
- CVE-2022-1734
- CVE-2022-1786
- CVE-2022-1882
- CVE-2022-1998
- CVE-2022-2078
- CVE-2022-2318
- CVE-2022-23222
- CVE-2022-2327
- CVE-2022-2380
- CVE-2022-24448
- CVE-2022-24958
- CVE-2022-24959
- CVE-2022-25258
- CVE-2022-25265
- CVE-2022-25375
- CVE-2022-26365
- CVE-2022-26490
- CVE-2022-26966
- CVE-2022-27223
- CVE-2022-27666
- CVE-2022-28356
- CVE-2022-28388
- CVE-2022-28389
- CVE-2022-28390
- CVE-2022-28893
- CVE-2022-29156
- CVE-2022-29581
- CVE-2022-29582
- CVE-2022-30594
- CVE-2022-32250
- CVE-2022-32296
- CVE-2022-33740
- CVE-2022-33741
- CVE-2022-33742
- CVE-2022-33743
- CVE-2022-33744
- CVE-2022-33981
- CVE-2022-34918
- CVE-2022-36879
- CVE-2022-36946

uw-imap:
- CVE-2018-19518

xterm:
- CVE-1999-0965

zlib:
- CVE-2022-37434

## 6. Contact us
If you find an issue in ubinux, you should report it in the issue tracker on GitHub.
