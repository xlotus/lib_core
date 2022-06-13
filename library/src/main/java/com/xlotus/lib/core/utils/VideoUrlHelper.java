package com.xlotus.lib.core.utils;

import android.net.Uri;
import android.text.TextUtils;

import com.xlotus.lib.core.io.FileUtils;
import com.xlotus.lib.core.io.sfile.SFile;
import com.xlotus.lib.core.lang.StringUtils;

public class VideoUrlHelper {

    public static boolean isLocalPath(String url) {
        return !isNetUrl(url) && isFileExists(url);
    }

    public static boolean isLocalDeletedPath(String url) {
        boolean isLocal = !StringUtils.isEmpty(url) && !isNetUrl(url);
        return isLocal && !isFileExists(url);
    }

    public static boolean isFileExists(String filePath) {
        if (TextUtils.isEmpty(filePath))
            return false;
        if (FileUtils.isAssetFile(filePath))
            return true;
        SFile file = SFile.create(filePath);
        return file.exists() && file.length() > 0;
    }

    public static boolean isNetUrl(String url) {
        if (StringUtils.isEmpty(url))
            return false;

        Uri uri = Uri.parse(url);
        if (uri == null || StringUtils.isEmpty(uri.getScheme()))
            return false;

        String scheme = uri.getScheme();
        return Utils.isEquals(scheme, "http") || Utils.isEquals(scheme, "https");
    }

    // fix url contain special character (such as #) truncation use uri.getPath
    public static String parseFilePathByUri(Uri uri) {
        String scheme = uri.getScheme();
        String path = uri.getPath();
        String urlString = uri.toString();
        if (TextUtils.isEmpty(scheme) && !urlString.equals(path)) {
            return uri.toString();
        }
        return path;
    }

}
