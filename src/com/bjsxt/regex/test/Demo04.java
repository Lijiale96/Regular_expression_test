package com.bjsxt.regex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象分割动作
 * 
 */
public class Demo04 {
    public static void main(String[] args) {
       String str = ("a,b,c,d");
       String[] arrs = str.split("\\d+");
        System.out.println(Arrays.toString(arrs));
    }
}
