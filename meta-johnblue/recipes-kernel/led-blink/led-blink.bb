SUMMARY = "LED Blink Timer Kernel Module"
DESCRIPTION = "A simple kernel module that simulates LED blinking using a timer"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"
LIC_FILES_CHKSUM = "file://led_blink_timer.c;beginline=1;endline=1;md5=1991ad4d9249c62104b7b55e73afa655"

SRC_URI = "file://led_blink_timer.c \
           file://Makefile"

S = "${WORKDIR}"

inherit module

# For a kernel module recipe using inherit module, Yocto already handles most of the kernel-related dependencies. You typically only need:
DEPENDS = "virtual/kernel"

# install the module to /lib/modules
do_install:append() {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/extra
    install -m 0644 led_blink_timer.ko ${D}/lib/modules/${KERNEL_VERSION}/extra/
}

# load module at boot
pkg_postinst:led-blink() {
    if [ -n "$D" ]; then
        echo "modprobe led_blink_timer" >> $D/etc/init.d/led_blink_timer
        chmod +x $D/etc/init.d/led_blink_timer
    fi
}

