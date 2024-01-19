# ubinux-2024.01 Release Notes

Linux Appliance Engineering Dept. Data Center Div.  
Fujitsu Limited  

## 1. Basic Information
### 1.1 Version Information
- Yocto: 4.3
- Kernel: 6.1.68
- Toolchain
  - GCC: 13.2.0
  - Binutils: 2.41
  - glibc: 2.38
  - GDB: 13.2
- License Files Format: SPDX 2.3

### 1.2 CPU Architecture Support
- x86 (64bit, 32bit Mulitlib)
- Armv8 (64bit EL, 32bit Mulitlib)

### 1.3 Tested reference boards
- NXP Layerscape LS1043A custom board
- NXP Layerscape LX2160A-RDB
- Lenovo QiTian M4550 (Processor: Core i5-4570)
- Xilinx Zynq UltraScale+ MPSoC (Qemu, Ultra96 board)

### 1.4 Host OS Support
- Ubuntu 22.04 LTS (64bit)

### 1.5 U-Boot and firmware Support
- NXP Layerscape SDK v21.08 (U-Boot v2021.04)
- Xilinx PetaLinux 2023.1 (U-Boot v2023.01)

## 2. Features
### 2.1 Security Fixes
Following security issues have been fixed from ubinux-2023.12.

avahi:
- CVE-2023-38469
- CVE-2023-38470
- CVE-2023-38471
- CVE-2023-38472
- CVE-2023-38473

frr:
- CVE-2023-46752
- CVE-2023-46753
- CVE-2023-47234
- CVE-2023-47235

openssl:
- CVE-2023-5678

### 2.2 Added packages

- freeglut
- hwloc

### 2.3 Removed packages

- bats
- netkit-rsh (There is no replacement package. The telnet command was removed.)
- netkit-telnet (There is no replacement package. The rsh command was removed.)

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2024.01 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL)|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2024.01.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL)|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2024.01/environment-setup-[TYPE2]`

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

busybox:
- CVE-2023-42363
- CVE-2023-42364
- CVE-2023-42365
- CVE-2023-42366

curl:
- CVE-2023-46218
- CVE-2023-46219

db:
- CVE-2016-0682
- CVE-2016-0689
- CVE-2016-0692
- CVE-2016-0694
- CVE-2016-3418

dovecot:
- CVE-2022-30550

exiv2:
- CVE-2007-6353
- CVE-2023-44398

giflib:
- CVE-2022-28506
- CVE-2023-39742
- CVE-2023-48161

glibc:
- CVE-2010-4756
- CVE-2023-0687

gnupg:
- CVE-2022-3219

grpc:
- CVE-2023-44487

hdf5:
- CVE-2018-17433
- CVE-2018-17436
- CVE-2019-8396
- CVE-2020-10809
- CVE-2020-10812

jq:
- CVE-2023-50246
- CVE-2023-50268

libmemcached:
- CVE-2023-27478

libraw:
- CVE-2023-1729

libsdl:
- CVE-2020-14409
- CVE-2020-14410

libuser:
- CVE-2012-5644

libvirt:
- CVE-2023-3750

openjpeg:
- CVE-2015-1239

opensc:
- CVE-2023-40660
- CVE-2023-40661
- CVE-2023-4535

openvswitch:
- CVE-2019-25076

perl:
- CVE-2023-47100

polkit:
- CVE-2016-2568

postgresql:
- CVE-2023-5868
- CVE-2023-5869
- CVE-2023-5870

procmail:
- CVE-1999-0475
- CVE-2014-3618
- CVE-2017-16844

qemu:
- CVE-2023-1386
- CVE-2023-3019
- CVE-2023-5088

qtbase:
- CVE-2023-43114

rpm:
- CVE-2021-35937

samba:
- CVE-2018-14628
- CVE-2021-3670
- CVE-2022-1615
- CVE-2022-32743
- CVE-2022-38023
- CVE-2023-37369
- CVE-2023-5568

strace:
- CVE-2000-0006

sysstat:
- CVE-2022-39377

tiff:
- CVE-2023-1916

tigervnc:
- CVE-2014-8241

ubinux-kernel:
- CVE-1999-0524
- CVE-1999-0656
- CVE-2007-4998
- CVE-2008-4609
- CVE-2010-4563
- CVE-2019-14899
- CVE-2020-35501
- CVE-2021-3714
- CVE-2021-3847
- CVE-2021-3864
- CVE-2022-0400
- CVE-2022-0480
- CVE-2022-1247
- CVE-2022-25265
- CVE-2022-2961
- CVE-2022-3606
- CVE-2022-36402
- CVE-2022-38096
- CVE-2022-41848
- CVE-2022-44032
- CVE-2022-44033
- CVE-2022-44034
- CVE-2022-4543
- CVE-2022-45884
- CVE-2022-45885
- CVE-2022-45888
- CVE-2023-1192
- CVE-2023-1193
- CVE-2023-1206
- CVE-2023-2176
- CVE-2023-23039
- CVE-2023-26242
- CVE-2023-3347
- CVE-2023-3397
- CVE-2023-34966
- CVE-2023-34967
- CVE-2023-34968
- CVE-2023-3640
- CVE-2023-37454
- CVE-2023-39191
- CVE-2023-4010
- CVE-2023-4133
- CVE-2023-4155
- CVE-2023-4244
- CVE-2023-4611
- CVE-2023-47233
- CVE-2023-4921
- CVE-2023-50431
- CVE-2023-6039
- CVE-2023-6238
- CVE-2023-6560
- CVE-2023-6606
- CVE-2023-6610

uw-imap:
- CVE-2018-19518

wireshark:
- CVE-2023-6174

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

xserver-xorg:
- CVE-2023-1393
- CVE-2023-5574

xterm:
- CVE-1999-0965

## 6. Contact us
If you find an issue in ubinux, you should report it in the issue tracker on GitHub.
