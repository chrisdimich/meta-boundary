IMAGE_INSTALL:append = " \
    u-boot-script-ezurio \
"

IMAGE_INSTALL:append = "${@bb.utils.contains("WIFI_BT_ENABLE", "1", "kernel-module-ti-backports ti351-firmware networkmanager networkmanager-nmcli", "", d)}"
