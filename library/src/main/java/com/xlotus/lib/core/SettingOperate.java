package com.xlotus.lib.core;

import android.content.Context;

import com.xlotus.lib.core.lang.ObjectStore;

public class SettingOperate {

    private static Settings getSettings() {
        return new Settings(ObjectStore.getContext());
    }

    public static boolean contains(String key) {
        return getSettings().contains(key);
    }

    public static void remove(String key) {
        getSettings().remove(key);
    }

    public static boolean setBoolean(String key, boolean value) {
        return getSettings().setBoolean(key, value);
    }

    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return getSettings().getBoolean(key, defaultValue);
    }

    public static void setString(String key, String value) {
        getSettings().set(key, value);
    }

    public static String getString(String key) {
        return getString(key, "");
    }

    public static String getString(String key, String defaultValue) {
        return getSettings().get(key, defaultValue);
    }

    public static String getString(Context context, String key, String defaultValue) {
        return getSettings().get(key, defaultValue);
    }

    public static void setInt(String key, int value) {
        getSettings().setInt(key, value);
    }

    public static int getInt(String key) {
        return getInt(key, 0);
    }

    public static int getInt(String key, int defaultValue) {
        return getSettings().getInt(key, defaultValue);
    }

    public static void setLong(String key, long value) {
        getSettings().setLong(key, value);
    }

    public static long getLong(String key) {
        return getLong(key, 0L);
    }

    public static long getLong(String key, long defaultValue) {
        return getSettings().getLong(key, defaultValue);
    }

    public static int increaseInt(String key) {
        int anInt = getSettings().getInt(key, 0);
        anInt += 1;
        getSettings().setInt(key, anInt);
        return anInt;
    }

    public static long increaseLong(String key) {
        long anLong = getSettings().getLong(key, 0);
        anLong += 1;
        getSettings().setLong(key, anLong);
        return anLong;
    }
}
