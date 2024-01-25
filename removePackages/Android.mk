LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := RemovePackages
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_TAGS := optional
LOCAL_OVERRIDES_PACKAGES := \
    AdaptiveVPNPrebuilt \
    AiWallpapers \
    AmbientStreaming \
    AmbientSensePrebuilt \
    AppDirectedSMSService \
    BetterBugStub \
    CarrierLocation \
    CarrierMetrics \
    CarrierWifi \
    CbrsNetworkMonitor \
    ConfigUpdater \
    Camera2 \
    ConnMO \
    DCMO \
    DevicePolicyPrebuilt \
    DMService \
    Drive \
    GCS \
    GoogleCamera \
    GoogleFeedback \
    KidsSupervisionStub \
    LocationHistoryPrebuilt \
    MaestroPrebuilt \
    Maps \
    Music \
    MyVerizonServices \
    OBDM_Permissions \
    obdm_stub \
    OdadPrebuilt \
    OemDmTrigger \
    OPScreenRecord \
    Ornament \
    PixelLiveWallpaperPrebuilt \
    PixelSupportPrebuilt \
    PixelWallpapers2020 \
    PixelWallpapers2021 \
    PixelWallpapers2022 \
    PixelWallpapers2022a \
    PixelWallpapers2023Tablet \
    PlayAutoInstallConfig \
    RecorderPrebuilt \
    SafetyHubPrebuilt \
    SafetyRegulatoryInfo \
    SCONE \
    ScribePrebuilt \
    Showcase \
    Snap \
    Snap2 \
    SnapdragonCamera \
    SoundAmplifierPrebuilt \
    SprintDM \
    SprintHM \
    Tycho \
    TipsPrebuilt \
    USCCDM \
    Videos \
    VZWAPNLib \
    VzwOmaTrigger \
    WallpapersBReel2020 \
    YouTube \
    YouTubeMusicPrebuilt \
    YTMusic
LOCAL_UNINSTALLABLE_MODULE := true
LOCAL_CERTIFICATE := PRESIGNED
LOCAL_SRC_FILES := /dev/null
include $(BUILD_PREBUILT)
