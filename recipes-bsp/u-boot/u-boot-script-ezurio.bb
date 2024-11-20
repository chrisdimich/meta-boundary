SUMMARY = "U-boot boot script for CarbonAM62"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS = "u-boot-mkimage-native dtc-native"

inherit deploy

SRC_URI = "\
	file://boot.txt \
	file://uboot_script.its \
"

S = "${WORKDIR}"

do_compile()  {
    uboot-mkimage -f "${S}/uboot_script.its" ${S}/boot.scr.uimg
}

do_install () {
    install -d ${D}/boot
    install -m 0644 ${S}/boot.scr.uimg ${D}/boot
}

FILES:${PN} += "/boot /boot.scr.uimg"

# install bootscript to deploy directory to be installed via IMAGE_BOOT_FILES to the boot partition
do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 0644 ${S}/boot.scr.uimg ${DEPLOYDIR}
}

addtask deploy before do_build after do_unpack
