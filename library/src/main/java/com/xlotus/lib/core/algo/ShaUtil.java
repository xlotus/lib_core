package com.xlotus.lib.core.algo;

import com.xlotus.lib.core.lang.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ShaUtil {

    /**
     * SHA加密数据
     * @param key 私钥
     * @param data 加密字符串
     * @return 返回加密结果
     */
    public static String HMACSHA256(String key, String data){
        try {
            Mac sha256HMAC = Mac.getInstance("HmacSHA256");
            byte[] PRIVATE_KEY = StringUtils.stringToByte(key);
            SecretKeySpec secretKey = new SecretKeySpec(PRIVATE_KEY, "HmacSHA256");
            sha256HMAC.init(secretKey);
            byte[] array = sha256HMAC.doFinal(data.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            String aesKey = sb.toString().toLowerCase();
            return aesKey.substring(25, 41);
        }catch (Exception exception){

        }
        return null;
    }
}
