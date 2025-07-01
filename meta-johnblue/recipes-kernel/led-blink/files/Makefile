obj-m += led_blink_timer.o

KDIR := /lib/modules/$(shell uname -r)/build
PWD := $(shell pwd)

all:
	$(MAKE) -C $(KDIR) M=$(PWD) modules


modules_install:
	# Dummy target to satisfy BitBake's expectations
	@echo "Skipping modules_install (handled manually in the recipe or not needed)"

clean:
	$(MAKE) -C $(KDIR) M=$(PWD) clean

