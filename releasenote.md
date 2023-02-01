# ubinux-2023.01 Release Notes

Appliance Engineering Dept. Linux Development Div.  
Fujitsu Limited  

## 1. Basic Information
### 1.1 Version Information
- Yocto: 4.1
- Kernel: 5.15.84
- Toolchain
  - GCC: 12.2.0
  - Binutils: 2.39
  - glibc: 2.36
  - GDB: 12.1
- License Files Format: SPDX 2.2

### 1.2 CPU Architecture Support
- x86 (64bit, 32bit Mulitlib)
- Armv8 (64bit EL, 32bit Mulitlib)

### 1.3 Tested reference boards
- NXP Layerscape LS1043A custom board
- NXP Layerscape LX2160A-RDB
- Lenovo QiTian M4550 (Processor: Core i5-4570)
- Xilinx Zynq UltraScale+ MPSoC custom board

Armv8 packages are not tested due to a hardware failure in the test environment. Only tested booting the board with minimal configuration.

### 1.4 Host OS Support
- Ubuntu 20.04 LTS (64bit)

### 1.5 U-Boot and firmware Support
- NXP Layerscape SDK v21.08 (U-Boot v2021.04)
- Xilinx PetaLinux 2022.2 (U-Boot v2022.01)

## 2. Features
### 2.1 Security Fixes
Following security issues have been fixed from ubinux-2022.12.

qtbase:
- CVE-2021-38593

sudo:
- CVE-2022-43995

ubinux-kernel:
- CVE-2022-3344
- CVE-2022-3435
- CVE-2022-3521
- CVE-2022-3543
- CVE-2022-3545
- CVE-2022-3564
- CVE-2022-3619
- CVE-2022-3623
- CVE-2022-3640

xterm:
- CVE-2022-45063

### 2.2 Added packages
- libtest-fatal-perl
- libtest-warnings-perl
- libtry-tiny-perl

### 2.3 Removed packages
- python3-tomli
- atk (Merged into at-spi2-core)
- at-spi2-atk (Merged into at-spi2-core)
- libjitterentropy
- rng-tools

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2023.01 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL)|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2023.01.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL)|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2023.01/environment-setup-[TYPE2]`

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

#### 4.4.2 Armv8
Armv8 are not tested due to a hardware failure in the test environment.

## 5. Known Security Issues
The following security issues were known in this release:

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

hdf5:
- CVE-2018-17433
- CVE-2018-17436
- CVE-2019-8396
- CVE-2020-10809
- CVE-2020-10812

libsdl:
- CVE-2020-14409
- CVE-2020-14410
- CVE-2022-34568

libuser:
- CVE-2012-5644

mariadb:
- CVE-2018-25032
- CVE-2022-32081
- CVE-2022-32082
- CVE-2022-32084
- CVE-2022-32089
- CVE-2022-32091
- CVE-2022-38791

multipath-tools:
- CVE-2022-41973
- CVE-2022-41974

nautilus:
- CVE-2022-37290

net-snmp:
- CVE-2022-44792
- CVE-2022-44793

nss:
- CVE-2022-3479

ntp:
- CVE-2019-11331

openjpeg:
- CVE-2015-1239
- CVE-2016-9675

openssl:
- CVE-2022-3996

openvswitch:
- CVE-2019-25076

php:
- CVE-2022-37454

polkit:
- CVE-2016-2568

procmail:
- CVE-1999-0475
- CVE-2014-3618
- CVE-2017-16844

python3:
- CVE-2022-45061

qtbase:
- CVE-2022-25255

quagga:
- CVE-2017-3224
- CVE-2021-44038

rpm:
- CVE-2021-35937

samba:
- CVE-2021-20316
- CVE-2021-3670
- CVE-2021-44141
- CVE-2022-1615
- CVE-2022-32743

sqlite3:
- CVE-2022-46908

strace:
- CVE-2000-0006

sysstat:
- CVE-2022-39377

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
- CVE-2020-35501
- CVE-2021-3669
- CVE-2021-3714
- CVE-2021-3847
- CVE-2021-3864
- CVE-2021-4095
- CVE-2022-0400
- CVE-2022-0480
- CVE-2022-1247
- CVE-2022-1462
- CVE-2022-1882
- CVE-2022-25265
- CVE-2022-2873
- CVE-2022-2961
- CVE-2022-3114
- CVE-2022-3522
- CVE-2022-3523
- CVE-2022-3534
- CVE-2022-3566
- CVE-2022-3567
- CVE-2022-3606
- CVE-2022-36402
- CVE-2022-38096
- CVE-2022-38457
- CVE-2022-40133
- CVE-2022-41218
- CVE-2022-41848
- CVE-2022-43945
- CVE-2022-44032
- CVE-2022-44033
- CVE-2022-44034
- CVE-2022-45884
- CVE-2022-45885
- CVE-2022-45886
- CVE-2022-45887
- CVE-2022-45888
- CVE-2022-45919
- CVE-2022-45934

uw-imap:
- CVE-2018-19518

xdg-utils:
- CVE-2022-4055

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

xterm:
- CVE-1999-0965

zabbix:
- CVE-2022-43516

## 6. Contact us
If you find an issue in ubinux, you should report it in the issue tracker on GitHub.
