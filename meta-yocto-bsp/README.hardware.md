                  Yocto Project Hardware Reference BSPs README
                  ============================================

This file gives details about using the Yocto Project hardware reference BSPs.
The machines supported can be seen in the conf/machine/ directory and are listed 
below. There is one per supported hardware architecture and these are primarily
used to validate that the Yocto Project works on the hardware arctectures of 
those machines.

If you are in doubt about using Poky/OpenEmbedded/Yocto Project with your hardware, 
consult the documentation for your board/device.

Support for additional devices is normally added by adding BSP layers to your 
configuration. For more information please see the Yocto Board Support Package 
(BSP) Developer's Guide - documentation source is in documentation/bspguide or 
download the PDF from:

   https://docs.yoctoproject.org/

Note that these reference BSPs use the linux-yocto kernel and in general don't
pull in binary module support for the platforms. This means some device functionality
may be limited compared to a 'full' BSP which may be available.


Hardware Reference Boards
=========================

The following boards are supported by the meta-yocto-bsp layer:

  * Texas Instruments Beaglebone (beaglebone-yocto)
  * General IA platforms (genericx86 and genericx86-64)

For more information see the board's section below. The appropriate MACHINE
variable value corresponding to the board is given in brackets.

Reference Board Maintenance
===========================

Send pull requests, patches, comments or questions about meta-yocto-bsps to poky@lists.yoctoproject.org

Maintainers: Kevin Hao <kexin.hao@windriver.com>
             Bruce Ashfield <bruce.ashfield@gmail.com>

Consumer Devices
================

The following consumer devices are supported by the meta-yocto-bsp layer:

  * Intel x86 based PCs and devices (genericx86)

For more information see the device's section below. The appropriate MACHINE
variable value corresponding to the device is given in brackets.



                      Specific Hardware Documentation
                      ===============================


Intel x86 based PCs and devices (genericx86*)
=============================================

The genericx86 and genericx86-64 MACHINE are tested on the following platforms:

Intel Xeon/Core i-Series:
  + Intel NUC5 Series - ix-52xx Series SOC (Broadwell)
  + Intel NUC6 Series - ix-62xx Series SOC (Skylake)
  + Intel Shumway Xeon Server

Intel Atom platforms:
  + MinnowBoard MAX - E3825 SOC (Bay Trail)
  + MinnowBoard MAX - Turbot (ADI Engineering) - E3826 SOC (Bay Trail)
    - These boards can be either 32bot or 64bit modes depending on firmware
    - See minnowboard.org for details 
  + Intel Braswell SOC

and is likely to work on many unlisted Atom/Core/Xeon based devices. The MACHINE
type supports ethernet, wifi, sound, and Intel/vesa graphics by default in
addition to common PC input devices, busses, and so on.

Depending on the device, it can boot from a traditional hard-disk, a USB device,
or over the network. Writing generated images to physical media is
straightforward with a caveat for USB devices. The following examples assume the
target boot device is /dev/sdb, be sure to verify this and use the correct
device as the following commands are run as root and are not reversable.

USB Device:
  1. Build a live image. This image type consists of a simple filesystem
     without a partition table, which is suitable for USB keys, and with the
     default setup for the genericx86 machine, this image type is built
     automatically for any image you build. For example:

     $ bitbake core-image-minimal

  2. Use the "dd" utility to write the image to the raw block device. For
     example:

     # dd if=core-image-minimal-genericx86.hddimg of=/dev/sdb

  If the device fails to boot with "Boot error" displayed, or apparently
  stops just after the SYSLINUX version banner, it is likely the BIOS cannot
  understand the physical layout of the disk (or rather it expects a
  particular layout and cannot handle anything else). There are two possible
  solutions to this problem:

  1. Change the BIOS USB Device setting to HDD mode. The label will vary by
     device, but the idea is to force BIOS to read the Cylinder/Head/Sector
     geometry from the device.

  2. Use a ".wic" image with an EFI partition

     a) With a default grub-efi bootloader:
     # dd if=core-image-minimal-genericx86-64.wic of=/dev/sdb

     b) Use systemd-boot instead
     - Build an image with EFI_PROVIDER="systemd-boot" then use the above
       dd command to write the image to a USB stick.


Texas Instruments Beaglebone (beaglebone-yocto)
===============================================

The Beaglebone is an ARM Cortex-A8 development board with USB, Ethernet, 2D/3D
accelerated graphics, audio, serial, JTAG, and SD/MMC. The Black adds a faster
CPU, more RAM, eMMC flash and a micro HDMI port. The beaglebone MACHINE is
tested on the following platforms:

  o Beaglebone Black A6
  o Beaglebone A6 (the original "White" model)

The Beaglebone Black has eMMC, while the White does not. Pressing the USER/BOOT
button when powering on will temporarily change the boot order. But for the sake
of simplicity, these instructions assume you have erased the eMMC on the Black,
so its boot behavior matches that of the White and boots off of SD card. To do
this, issue the following commands from the u-boot prompt:

    # mmc dev 1
    # mmc erase 0 512

To further tailor these instructions for your board, please refer to the
documentation at http://www.beagleboard.org/bone and http://www.beagleboard.org/black

From a Linux system with access to the image files perform the following steps:

  1. Build an image. For example:

     $ bitbake core-image-minimal

  2. Use the "dd" utility to write the image to the SD card. For example:

     # dd if=core-image-minimal-beaglebone-yocto.wic of=/dev/sdb

  3. Insert the SD card into the Beaglebone and boot the board.
