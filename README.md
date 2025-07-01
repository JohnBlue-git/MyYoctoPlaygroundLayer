## About MyYoctoPlaygroundLayer
A playground for using yocto, customizing, or running qemu.

## How to clone
```bash
# Init repo
repo init -u https://github.com/JohnBlue-git/MyYoctoPlaygroundLayer.git -b main -m manifest_master.xml

# Run repo sync
repo sync
```

## How to build
```bash
~/MyYoctoPlaygroundLayer$ source poky/oe-init-build-env

~/MyYoctoPlaygroundLayer/build$ bitbake <target> 
~/MyYoctoPlaygroundLayer/build$ bitbake johnblue-image
```

## ...



