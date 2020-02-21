package com.lianxun.utils;

import java.util.Random;

public class GetRandomUtil {

    public static void main(String[] args) {
        System.out.println(GetRandomUtil.getString(8));
    }

    /**
     * 生成数字加字母的随机字符串
     * 
     * @param len
     * @return
     */
    public static String getString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        int randomNum;
        char randomChar;
        Random random = new Random();
        // StringBuffer类型的可以append增加字符
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < length; i++) {
            // 可生成[0,n)之间的整数，获得随机位置
            randomNum = random.nextInt(base.length());
            // 获得随机位置对应的字符
            randomChar = base.charAt(randomNum);
            // 组成一个随机字符串
            str.append(randomChar);
        }
        return str.toString();
    }

    /**
     * 生成随机数
     * 
     * @param len
     * @return
     */
    public static String getNumber(int len) {

        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < len; i++) {
            captcha.append(new Random().nextInt(10));
        }
        return captcha.toString();
    }
    
    public static String formartStr(String str) {
        String newStr = str.replace("\"{", "{").replace("}\"", "}").replace("\"[", "[")
                .replace("]\"", "]").replace("\\", "");
        return newStr;
    }
}
