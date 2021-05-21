# ubinux-2021.05 Release Notes

FUJITSU COMPUTER TECHNOLOGIES LIMITED
Solution Development Dept. Software Div.

## 1. Basic Information
### 1.1 Version Information
- Yocto: 3.3
- Kernel: 5.4.113
- Kernel for Layerscape: 5.4.47
- Toolchain
  - GCC: 10.2.0
  - Binutils: 2.36.1
  - glibc: 2.33
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
Following security issues have been fixed from ubinux-2021.04.

bind:
- CVE-2020-8625

glibc:
- CVE-2021-27645

gnome-autoar:
- CVE-2020-36241

openldap:
- CVE-2021-27212

openssh:
- CVE-2021-28041

ubinux-kernel:
- CVE-2020-25639
- CVE-2020-27152
- CVE-2020-29372
- CVE-2021-26932
- CVE-2021-28038
- CVE-2021-3347

ubinux-kernel-lsdk:
- CVE-2020-27152
- CVE-2020-29372

xterm:
- CVE-2021-27135

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2021.05 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL) and Arm7|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2021.05.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL) and Arm7|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2021.05/environment-setup-[TYPE2]`

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
#### 4.2.1 uftrace (Affect only Armv8)
- Issue  
    $ cat test2.cpp  
    #include <iostream>  
    using namespace std;  
    int main() {  
        cout << "Hello World!\n";  
        return 0;  
    }  
    $ g++ test2.cpp -pg  
    $ uftrace --debug record a.out  
    ...  
    WARN: child terminated by signal: 11: Segmentation fault   

- cause  
    After binutils 2.35.1, uftrace will be unable to read record data (the file that records trace log).

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

bind:
- CVE-2017-3139
- CVE-2019-6470

bluez5:
- CVE-2020-12352
- CVE-2020-24490

c-ares:
- CVE-2020-8277

cairo:
- CVE-2020-35492

coreutils:
- CVE-2009-4135
- CVE-2014-9471
- CVE-2015-4041
- CVE-2015-4042
- CVE-2016-2781
- CVE-2017-18018

cpio:
- CVE-2019-14866

curl:
- CVE-2021-22876
- CVE-2021-22890

db:
- CVE-2016-0682
- CVE-2016-0689
- CVE-2016-0692
- CVE-2016-0694
- CVE-2016-3418

ecryptfs-utils:
- CVE-2016-1572

flex:
- CVE-2019-6293

ghostscript:
- CVE-2013-6629

glib-2.0:
- CVE-2021-28153

glibc:
- CVE-2010-4756
- CVE-2019-1010022
- CVE-2019-1010023
- CVE-2019-1010024
- CVE-2019-1010025

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

hostapd:
- CVE-2021-30004

libesmtp:
- CVE-2019-19977

libsdl:
- CVE-2019-13616
- CVE-2020-14409
- CVE-2020-14410

libuser:
- CVE-2012-5644

nettle:
- CVE-2021-20305

ntp:
- CVE-2015-5146
- CVE-2015-5300
- CVE-2015-7973
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
- CVE-2016-2518
- CVE-2016-2519
- CVE-2016-7429
- CVE-2016-7433
- CVE-2016-9310
- CVE-2016-9311
- CVE-2019-11331

openvswitch:
- CVE-2020-27827
- CVE-2020-35498

php:
- CVE-2007-2728
- CVE-2020-7071
- CVE-2021-21702

polkit:
- CVE-2016-2568

procmail:
- CVE-1999-0475
- CVE-2014-3618
- CVE-2017-16844

quagga:
- CVE-2016-4049

rpm:
- CVE-2021-20271

samba:
- CVE-2018-1050
- CVE-2018-1057

strace:
- CVE-2000-0006

tiff:
- CVE-2015-7313

ubinux-kernel:
- CVE-1999-0524
- CVE-1999-0656
- CVE-2007-4998
- CVE-2008-4609
- CVE-2010-4563
- CVE-2011-0640
- CVE-2017-1000377
- CVE-2019-14899
- CVE-2019-20794
- CVE-2020-11725
- CVE-2020-16119
- CVE-2020-16120
- CVE-2020-26541
- CVE-2020-27194
- CVE-2021-20194
- CVE-2021-20226
- CVE-2021-26934

ubinux-kernel-lsdk:
- CVE-1999-0524
- CVE-1999-0656
- CVE-2007-4998
- CVE-2008-4609
- CVE-2010-4563
- CVE-2011-0640
- CVE-2017-1000377
- CVE-2019-14899
- CVE-2019-20794
- CVE-2019-20810
- CVE-2020-10781
- CVE-2020-11725
- CVE-2020-12351
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
- CVE-2020-15393
- CVE-2020-15436
- CVE-2020-15437
- CVE-2020-15780
- CVE-2020-16119
- CVE-2020-16120
- CVE-2020-16166
- CVE-2020-24394
- CVE-2020-25211
- CVE-2020-25212
- CVE-2020-25284
- CVE-2020-25285
- CVE-2020-25639
- CVE-2020-25641
- CVE-2020-25643
- CVE-2020-25645
- CVE-2020-25656
- CVE-2020-25704
- CVE-2020-25705
- CVE-2020-26088
- CVE-2020-26541
- CVE-2020-27170
- CVE-2020-27171
- CVE-2020-27194
- CVE-2020-27673
- CVE-2020-27675
- CVE-2020-27777
- CVE-2020-28374
- CVE-2020-28915
- CVE-2020-28941
- CVE-2020-28974
- CVE-2020-29368
- CVE-2020-29369
- CVE-2020-29371
- CVE-2020-29569
- CVE-2020-29660
- CVE-2020-29661
- CVE-2020-35508
- CVE-2020-36158
- CVE-2021-20194
- CVE-2021-20226
- CVE-2021-26930
- CVE-2021-26931
- CVE-2021-26932
- CVE-2021-26934
- CVE-2021-27363
- CVE-2021-27364
- CVE-2021-27365
- CVE-2021-28038
- CVE-2021-28375
- CVE-2021-28660
- CVE-2021-28964
- CVE-2021-28971
- CVE-2021-28972
- CVE-2021-29264
- CVE-2021-29265
- CVE-2021-29647
- CVE-2021-29650
- CVE-2021-30002
- CVE-2021-3178
- CVE-2021-3347
- CVE-2021-3348
- CVE-2021-3444

uw-imap:
- CVE-2005-0198

wpa-supplicant:
- CVE-2021-30004

xterm:
- CVE-1999-0965

## 6. Contact us
If you find an issue in ubinux, you should report it in the issue tracker on GitHub.
