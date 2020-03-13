package com.graduate.club.util;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Description: Base64 工具类
 * @Author:Frederic-YYW
 * @Email:yuanyangwen@iristar.com.cn
 * @Date 2019/12/10 17:12
 */
@Slf4j
public class Base64Utils {


    static BASE64Decoder decoder;
    static BASE64Encoder encoder;

    static {
        decoder = new BASE64Decoder();
        encoder = new BASE64Encoder();
    }

    public static byte[] decode(String data) {
        try {
            return decoder.decodeBuffer(data);
        } catch (Exception e) {
            System.out.println("BASE64Decoder error " + e.getCause());
            return null;
        }

    }

    public static String encode(byte[] data) {
        if (data == null || data.length == 0) {
            log.error("base64 encode fail ");
            return null;
        }
        return encoder.encodeBuffer(data);
    }

    /**
     * URL解码
     *
     * @param arr
     * @return
     */
    public static String toURLDecoded(byte[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println(" url 解码时传入的数据为空");
            return null;
        }
        try {
            String str = new String(arr, "UTF-8");
            str = URLDecoder.decode(str, "UTF-8");
            return str;
        } catch (Exception localException) {
            System.out.println("URL 解码时错误 :" + localException.toString());
        }
        return null;
    }

    public static String getBASE64(String s) {
        if (s == null) return null;
        return (new BASE64Encoder()).encode(s.getBytes());
    }

    public static String urlDecoder(String constant) {
        if (StringUtils.isBlank(constant)) {
            return null;
        }
        return URLDecoder.decode(constant);
    }

    public static String urlEncoder(String constant) {
        try {
            if (StringUtils.isNotBlank(constant)) {
                return constant;
            }
            return URLEncoder.encode(constant, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
