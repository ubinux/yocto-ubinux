# ubinux-2024.09 Release Notes

FX Dept. UNIX & FX System Div.  
Fujitsu Limited  

## 1. Basic Information
### 1.1 Version Information
- Yocto: 5.0
- Kernel: 6.6.47
- Toolchain
  - GCC: 14.2.0
  - Binutils: 2.43.1
  - glibc: 2.40
  - GDB: 15.1
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
- Ubuntu 22.04 LTS (64bit)

### 1.5 U-Boot and firmware Support
- NXP Layerscape SDK v21.08 (U-Boot v2021.04)

## 2. Features
### 2.1 Security Fixes
Following security issues have been fixed from ubinux-2024.08.

busybox:
- CVE-2023-42364
- CVE-2023-42365
- CVE-2023-42366

gnupg:
- CVE-2022-3219

libyaml:
- CVE-2024-35328

openssh:
- CVE-2023-51767

poppler:
- CVE-2024-6239

### 2.2 Added packages

N/A

### 2.3 Removed packages

- cantarell-fonts 
- lastlog2 
- libdazzle 
- python3-atomicwrites 
- python3-more-itertools 
- python3-pathlib2 
- python3-py 
- python3-toml 

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2024.09 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL)|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2024.09.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL)|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2024.09/environment-setup-[TYPE2]`

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
- Screen display (X86_64)
  - After start the systemd, the tty screen maybe cannot be displayed.  
    You can execute startx normally,  or log in through ssh to run command line.

### 4.3 Tools
- SPDX
  - Does not contain vulnerability information for each package.

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
db:
- CVE-2016-0682
- CVE-2016-0689
- CVE-2016-0692
- CVE-2016-0694
- CVE-2016-3418

dovecot:
- CVE-2022-30550

expat:
- CVE-2024-45490
- CVE-2024-45491
- CVE-2024-45492

glibc:
- CVE-2010-4756

gnutls:
- CVE-2023-51257

hdf5:
- CVE-2018-17433
- CVE-2018-17436
- CVE-2019-8396
- CVE-2020-10809
- CVE-2020-10812

libmemcached:
- CVE-2023-27478

libuser:
- CVE-2012-5644

libvirt:
- CVE-2023-3750

openvswitch:
- CVE-2019-25076

polkit:
- CVE-2016-2568

procmail:
- CVE-2014-3618
- CVE-2017-16844

python3:
- CVE-2024-6232

qemu:
- CVE-2023-1386
- CVE-2024-6505

qtbase:
- CVE-2023-43114
- CVE-2023-51714
- CVE-2024-39936

rpm:
- CVE-2021-35937

samba:
- CVE-2018-14628
- CVE-2021-3670
- CVE-2022-1615
- CVE-2022-32743
- CVE-2022-38023
- CVE-2023-37369

strace:
- CVE-2000-0006

sysstat:
- CVE-2022-39377

tiff:
- CVE-2023-1916

tigervnc:
- CVE-2014-8241
- CVE-2023-6377
- CVE-2023-6478
- CVE-2024-0408
- CVE-2024-0409

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
- CVE-2022-38096
- CVE-2022-41848
- CVE-2022-44032
- CVE-2022-44033
- CVE-2022-44034
- CVE-2022-4543
- CVE-2022-45884
- CVE-2022-45885
- CVE-2022-45888
- CVE-2023-23039
- CVE-2023-26242
- CVE-2023-3347
- CVE-2023-3397
- CVE-2023-34966
- CVE-2023-34967
- CVE-2023-34968
- CVE-2023-3640
- CVE-2023-37454
- CVE-2023-4010
- CVE-2023-4155
- CVE-2023-6238
- CVE-2023-6240
- CVE-2023-6356
- CVE-2023-6535
- CVE-2024-21803
- CVE-2024-23848
- CVE-2024-24857
- CVE-2024-24858
- CVE-2024-24859
- CVE-2024-24864
- CVE-2024-25739
- CVE-2024-25740
- CVE-2024-26585
- CVE-2024-26596
- CVE-2024-26900
- CVE-2024-26913
- CVE-2024-26952
- CVE-2024-27012
- CVE-2024-27017
- CVE-2024-38608
- CVE-2024-41061
- CVE-2024-41071
- CVE-2024-41080
- CVE-2024-41085
- CVE-2024-42064
- CVE-2024-42065
- CVE-2024-42066
- CVE-2024-42071
- CVE-2024-42072
- CVE-2024-42075
- CVE-2024-42078
- CVE-2024-42081
- CVE-2024-42083
- CVE-2024-42123
- CVE-2024-42155
- CVE-2024-42156
- CVE-2024-42158
- CVE-2024-42162
- CVE-2024-42227
- CVE-2024-42252
- CVE-2024-43819
- CVE-2024-43824
- CVE-2024-43857
- CVE-2024-43872
- CVE-2024-43884
- CVE-2024-43886
- CVE-2024-43891
- CVE-2024-43899
- CVE-2024-43901
- CVE-2024-43904
- CVE-2024-43911
- CVE-2024-43913
- CVE-2024-44946
- CVE-2024-44956
- CVE-2024-44974
- CVE-2024-44985
- CVE-2024-44986
- CVE-2024-44987
- CVE-2024-44989
- CVE-2024-44990
- CVE-2024-44995
- CVE-2024-44997
- CVE-2024-44998
- CVE-2024-44999
- CVE-2024-45000
- CVE-2024-45002
- CVE-2024-45006

uw-imap:
- CVE-2018-19518

wireshark:
- CVE-2024-8250

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
