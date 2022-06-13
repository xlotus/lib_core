package com.xlotus.lib.core.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.xlotus.lib.core.lang.ObjectStore;
import com.xlotus.lib.core.BuildConfig;
import com.xlotus.lib.core.SettingOperate;

/**
 * this app's distributions:
 * different versions/builds/channels/languages may impact different features of this app.
 */
public final class AppDist {

    public static String getChannel() {
        return getChannel(ObjectStore.getContext());
    }

    public static String getChannel(Context context) {
        String defaultChannel = "default";

        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (info == null || info.metaData == null)
                return defaultChannel;

            String metaDataChannel = "";
            if (info.metaData.containsKey("channel"))
                metaDataChannel = Utils.getStringFromBundle(info.metaData, "channel");

            if (!TextUtils.isEmpty(metaDataChannel))
                return metaDataChannel;
        } catch (Exception e) {}

        return defaultChannel;
    }

    public static String getAppId() {
        return getAppId(ObjectStore.getContext());
    }

    public static String getAppId(Context context) {
        String defaultAppId = context.getPackageName();

        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (info == null || info.metaData == null)
                return defaultAppId;

            String appId = "";
            if (info.metaData.containsKey("CLOUD_APPID"))
                appId = Utils.getStringFromBundle(info.metaData, "CLOUD_APPID");

            if (!TextUtils.isEmpty(appId))
                return appId;
        } catch (Exception e) {}

        return defaultAppId;
    }

    public static String getMetaData(String name) {
        Context context = ObjectStore.getContext();
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (info == null || info.metaData == null)
                return null;

            return info.metaData.getString(name);
        } catch (Exception e) {}
        return null;
    }

    public static final String KEY_OVERRIDE_BUILD_TYPE = "override_build_type";
    public static BuildType getBuildType() {
        BuildType type = BuildType.fromString(SettingOperate.getString(KEY_OVERRIDE_BUILD_TYPE, BuildConfig.BUILD_TYPE));
        return (type != null) ? type : BuildType.fromString(BuildConfig.BUILD_TYPE);
    }
}
