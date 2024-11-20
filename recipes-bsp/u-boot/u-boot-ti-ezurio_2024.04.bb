require u-boot-ti.inc

include ${@ 'recipes-bsp/u-boot/ti-extras.inc' if d.getVar('TI_EXTRAS') else ''}

PR = "r0"

BRANCH = "ezurio-pre-ti-2024.04"
UBOOT_GIT_URI = "git://github.com/boundarydevices/u-boot.git"
SRCREV = "f9a2c80e75a90837776a79670472265c9b9b483c"
