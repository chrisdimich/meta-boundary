# ti351-firmware recipe provides firmware files for TI351, so cc33xx-fw conflicts and needs to be removed
RDEPENDS:${PN}:remove = "cc33xx-fw"
