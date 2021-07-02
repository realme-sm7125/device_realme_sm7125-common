#!/sbin/sh

# Delete any existing FOD icons
if [ -e /sdcard/SSOSFOD ]; then
    rm -rf /sdcard/SSOSFOD
elif [ -e /sdcard/DerpFOD ]; then
    rm -rf /sdcard/DerpFOD
fi

# Move FOD icons
mv /tmp/install/bin/FODicons /sdcard/SSOSFOD
