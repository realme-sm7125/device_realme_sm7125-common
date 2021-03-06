LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE       := init.oppo.wifi.sh
LOCAL_MODULE_TAGS  := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := bin/init.oppo.wifi.sh
LOCAL_MODULE_PATH  := $(TARGET_OUT_EXECUTABLES)
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := init.recovery.qcom.sh
LOCAL_MODULE_TAGS  := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := bin/init.recovery.qcom.sh
LOCAL_MODULE_PATH  := $(TARGET_RECOVERY_ROOT_OUT)
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := vendor.autochmod.sh
LOCAL_MODULE_TAGS  := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := bin/vendor.autochmod.sh
LOCAL_MODULE_PATH  := $(TARGET_OUT_EXECUTABLES)
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := fstab.default
LOCAL_MODULE_TAGS  := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := etc/fstab.default
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := oplus.fstab
LOCAL_MODULE_TAGS  := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := etc/oplus.fstab
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := init.qcom.rc
LOCAL_MODULE_TAGS  := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := etc/init.qcom.rc
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/init
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := init.recovery.qcom.rc
LOCAL_MODULE_TAGS  := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := etc/init.recovery.qcom.rc
LOCAL_MODULE_PATH  := $(TARGET_RECOVERY_ROOT_OUT)
include $(BUILD_PREBUILT)
