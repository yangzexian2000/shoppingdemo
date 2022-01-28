package com.computer.utils;

import java.util.Random;

/**
 * 生成字符串和数字的工具
 * @author : yangzexian
 * @date : 2021/12/20
 */
public class GetStringUtils {
    /**
     * 随机生成一个字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append("JWDX");
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
