package com.bjsxt.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象替换动作
 * 
 */
public class Demo03 {
    public static void main(String[] args) {
        //表达式对象
        Pattern p = Pattern.compile("[0-9]");
        //创建Matcher对象
        Matcher m = p.matcher("afa232**ss32326*sds233");

        //替换
        String newStr = m.replaceAll("#");
        System.out.println(newStr);
    }


}
