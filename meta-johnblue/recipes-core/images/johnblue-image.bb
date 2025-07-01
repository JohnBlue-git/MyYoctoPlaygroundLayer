DESCRIPTION = "Custom image based on core-image-sato-sdk"
LICENSE = "MIT"

# - Place inherit early in the .bb file, typically after metadata definitions (DESCRIPTION, LICENSE, etc.).
# - If you need to override class-defined variables, palce after inherit (do_compile, do_install, etc, ...).
inherit core-image

# Choose image feature
IMAGE_FEATURES += "tools-debug tools-profile tools-sdk tools-testapps"

# Install our packages
IMAGE_INSTALL += "led-blink"

# Append packages
# IMAGE_INSTALL:append = " package"
#IMAGE_INSTALL:append = " kernel-dev kernel-devsrc kernel-modules"
#IMAGE_INSTALL:append = " make gcc g++ autoconf automake libtool pkgconfig"

# Depend packages (but not to install)
# DEPENDS = "package-name"
# - `kernel-devsrc` provides the full kernel source and headers.
# - `kernel-modules` ensures kernel modules are included.
#DEPENDS = " kernel-dev kernel-devsrc kernel-modules"
#DEPENDS = " make gcc g++ autoconf automake libtool pkgconfig"

