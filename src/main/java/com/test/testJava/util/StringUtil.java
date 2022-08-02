package com.test.testJava.util;

public class StringUtil {

    public static String repeat(String str, int times){
        if(times < 0){
            throw new IllegalArgumentException("neagtive times not allowed");
        }
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

    public static boolean isEmpty(String str){
        if(str == null || str == "" || str.trim().length() <= 0){
            return true;
        }else {
            return false;
        }
    }

}
