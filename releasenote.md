# ubinux-2025.04 Release Notes

OSS x AI Technology Div.  
Fujitsu Limited  

## 1. Basic Information
### 1.1 Version Information
- Yocto: 5.2
- Kernel: 6.6.83
- Toolchain
  - GCC: 14.2.0
  - Binutils: 2.44
  - glibc: 2.41
  - GDB: 16.2
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
Following security issues have been fixed from ubinux-2025.03.

qtbase:
- CVE-2023-43114

ubinux-kernel:
- CVE-2024-24857
- CVE-2024-24858
- CVE-2024-26913

### 2.2 Added packages

N/A

### 2.3 Removed packages

- uw-imap

## 3. Installation guide
### 3.1 Install Toolchain
Run as root privilege the Toolchain installer at arbitrary directory, and Toolchain will be installed into /opt/ubinux/2025.04 directory.


[TYPE1] in the description, please read as shown below.


|CPU|[TYPE1]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-x86-64|
|Armv8 (32bit EL, 64bit EL)|aarch64-ubinux-armv8|


`$ sudo sh ubinux-glibc-x86_64-meta-toolchain-[TYPE1]-toolchain-2025.04.sh`


### 3.2 Set up Environment Variables
Run the following commands.


[TYPE2] in the description, please read as shown below.


|CPU|[TYPE2]|
|---|--------|
|x86 (64bit)|core2-64-ubinux-linux|
|Armv8 (64bit EL)|aarch64-ubinux-linux|
|Armv8 (32bit EL)|armv7ahf-neon-ubinuxmllib32-linux-gnueabi|


`$ . /opt/ubinux/2025.04/environment-setup-[TYPE2]`

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

- qtbase, qtdeclarative  
  - Although the package names for qtbase and qtdeclarative are labeled as version 5.15.13,  
    the actual version is 5.15.16.

- busybox
  - The following sub commands of busybox have been removed.
    - busybox ifconfig
    - busybox netstat
    - busybox route  

- tiptop
  - The command tiptop cannot be used normally  

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
db:
- CVE-2016-0682
- CVE-2016-0689
- CVE-2016-0692
- CVE-2016-0694
- CVE-2016-3418

dovecot:
- CVE-2022-30550

glibc:
- CVE-2010-4756

hdf5:
- CVE-2018-17433
- CVE-2018-17436
- CVE-2019-8396
- CVE-2020-10809
- CVE-2020-10812

libsndfile1:
- CVE-2024-50613

libuser:
- CVE-2012-5644

libvirt:
- CVE-2023-3750

openvswitch:
- CVE-2019-25076

polkit:
- CVE-2016-2568

qemu:
- CVE-2023-1386
- CVE-2024-8354

qtbase:
- CVE-2023-51714
- CVE-2024-39936

rpm:
- CVE-2021-35937

samba:
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
- CVE-2025-26594
- CVE-2025-26595
- CVE-2025-26596
- CVE-2025-26597
- CVE-2025-26598
- CVE-2025-26599
- CVE-2025-26600
- CVE-2025-26601

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
- CVE-2023-3397
- CVE-2023-3640
- CVE-2023-37454
- CVE-2023-4010
- CVE-2023-4155
- CVE-2023-52485
- CVE-2023-52586
- CVE-2023-52590
- CVE-2023-52624
- CVE-2023-52625
- CVE-2023-52634
- CVE-2023-6238
- CVE-2023-6240
- CVE-2023-6535
- CVE-2024-21803
- CVE-2024-23848
- CVE-2024-24859
- CVE-2024-24864
- CVE-2024-25739
- CVE-2024-25740
- CVE-2024-26596
- CVE-2024-26699
- CVE-2024-26756
- CVE-2024-26900
- CVE-2024-26944
- CVE-2024-26945
- CVE-2024-26954
- CVE-2024-26962
- CVE-2024-27010
- CVE-2024-27011
- CVE-2024-27012
- CVE-2024-27017
- CVE-2024-27079
- CVE-2024-35788
- CVE-2024-35968
- CVE-2024-36478
- CVE-2024-38608
- CVE-2024-40965
- CVE-2024-40972
- CVE-2024-41012
- CVE-2024-41023
- CVE-2024-41061
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
- CVE-2024-42107
- CVE-2024-42122
- CVE-2024-42123
- CVE-2024-42134
- CVE-2024-42139
- CVE-2024-42151
- CVE-2024-42155
- CVE-2024-42156
- CVE-2024-42158
- CVE-2024-42162
- CVE-2024-42227
- CVE-2024-42252
- CVE-2024-43819
- CVE-2024-43835
- CVE-2024-43840
- CVE-2024-43886
- CVE-2024-43899
- CVE-2024-43901
- CVE-2024-43904
- CVE-2024-43911
- CVE-2024-43913
- CVE-2024-44950
- CVE-2024-44951
- CVE-2024-44955
- CVE-2024-44956
- CVE-2024-44963
- CVE-2024-46681
- CVE-2024-46727
- CVE-2024-46730
- CVE-2024-46751
- CVE-2024-46772
- CVE-2024-46774
- CVE-2024-46775
- CVE-2024-46778
- CVE-2024-46808
- CVE-2024-46813
- CVE-2024-46823
- CVE-2024-46833
- CVE-2024-46834
- CVE-2024-46841
- CVE-2024-46842
- CVE-2024-46863
- CVE-2024-46870
- CVE-2024-47661
- CVE-2024-47662
- CVE-2024-47702
- CVE-2024-47703
- CVE-2024-47726
- CVE-2024-47736
- CVE-2024-49854
- CVE-2024-49885
- CVE-2024-49888
- CVE-2024-49891
- CVE-2024-49893
- CVE-2024-49897
- CVE-2024-49898
- CVE-2024-49899
- CVE-2024-49904
- CVE-2024-49906
- CVE-2024-49908
- CVE-2024-49909
- CVE-2024-49910
- CVE-2024-49911
- CVE-2024-49914
- CVE-2024-49915
- CVE-2024-49916
- CVE-2024-49917
- CVE-2024-49918
- CVE-2024-49919
- CVE-2024-49920
- CVE-2024-49921
- CVE-2024-49922
- CVE-2024-49923
- CVE-2024-49926
- CVE-2024-49928
- CVE-2024-49932
- CVE-2024-49934
- CVE-2024-49940
- CVE-2024-49945
- CVE-2024-49968
- CVE-2024-49970
- CVE-2024-49971
- CVE-2024-49972
- CVE-2024-49974
- CVE-2024-49990
- CVE-2024-49994
- CVE-2024-49998
- CVE-2024-50004
- CVE-2024-50009
- CVE-2024-50010
- CVE-2024-50014
- CVE-2024-50017
- CVE-2024-50027
- CVE-2024-50028
- CVE-2024-50090
- CVE-2024-50091
- CVE-2024-50102
- CVE-2024-50106
- CVE-2024-50137
- CVE-2024-50138
- CVE-2024-50146
- CVE-2024-50157
- CVE-2024-50177
- CVE-2024-50178
- CVE-2024-50217
- CVE-2024-50221
- CVE-2024-50225
- CVE-2024-50277
- CVE-2024-50304
- CVE-2024-53050
- CVE-2024-53051
- CVE-2024-53056
- CVE-2024-53084
- CVE-2024-53085
- CVE-2024-53089
- CVE-2024-53090
- CVE-2024-53096
- CVE-2024-53098
- CVE-2024-53114
- CVE-2024-53124
- CVE-2024-53128
- CVE-2024-53133
- CVE-2024-53141
- CVE-2024-53142
- CVE-2024-53170
- CVE-2024-53179
- CVE-2024-53187
- CVE-2024-53201
- CVE-2024-53203
- CVE-2024-53204
- CVE-2024-53205
- CVE-2024-53209
- CVE-2024-53221
- CVE-2024-53222
- CVE-2024-56544
- CVE-2024-56549
- CVE-2024-56582
- CVE-2024-56588
- CVE-2024-56599
- CVE-2024-56608
- CVE-2024-56620
- CVE-2024-56647
- CVE-2024-56702
- CVE-2024-56710
- CVE-2024-56712
- CVE-2024-56742
- CVE-2024-56757
- CVE-2024-56758
- CVE-2024-56759
- CVE-2024-56761
- CVE-2024-56775
- CVE-2024-56782
- CVE-2024-56784
- CVE-2024-57872
- CVE-2024-57950
- CVE-2024-57982
- CVE-2024-58012
- CVE-2024-58089
- CVE-2025-21634
- CVE-2025-21635
- CVE-2025-21649
- CVE-2025-21650
- CVE-2025-21672
- CVE-2025-21682
- CVE-2025-21696
- CVE-2025-21723
- CVE-2025-21861

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
