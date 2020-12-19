LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := RemovePackages
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_TAGS := optional
LOCAL_OVERRIDES_PACKAGES := AppDirectedSMSService CarrierSetup ConnMO DCMO Drive FM2 Maps MyVerizonServices OBDM_Permissions OemDmTrigger PrebuiltGmail Showcase SprintDM SprintHM USCCDM VZWAPNLib VzwOmaTrigger YouTube YouTubeMusicPrebuilt libqcomfm_jni obdm_stub qcom.fmradio
LOCAL_UNINSTALLABLE_MODULE := true
LOCAL_CERTIFICATE := PRESIGNED
LOCAL_SRC_FILES := /dev/null
include $(BUILD_PREBUILT)
