package com.forum.utils;


import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by haitang on 2017/6/5.
 */
public class StringUtils {


    /**
     * 空字符串
     */
    public static final String EMPTY_STRING = "";
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    /**
     * 字符串MD5加密
     * @param str
     * @return
     */
    public final static String MD5(String str) {
        try {
            if (!StringUtils.isEmpty(str)) {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] digest = messageDigest.digest(str.getBytes("utf-8"));
                return new BigInteger(digest).toString(16);
            } else {
                return StringUtils.EMPTY_STRING;
            }
        } catch (Exception e) {
            throw new RuntimeException("字符串加密失败!" + e);
        }
    }
//    public static void main(String[] args){
//        System.out.println(MD5("a1"));
//    }
}
