package com.bjsxt.regex.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫取链接
 */
public class WebSpiderTest {
    /**
     * 获得urlStr对应的网页源码内容
     * @param urlStr
     * @return
     */
    public static String getURLContent(String urlStr,String charset){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL("https://www.kugou.com/song-36/mpu0ye0.html?from_360#hash=B1EC3E9CD29F6A893150C95A37679DEE&album_id=19202059");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("utf-8")));
            String temp = "";
            while((temp=reader.readLine())!=null){
               sb.append(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
   return sb.toString();
    }

    public static List<String> getMatherSubstrs(String destStr,String regexStr){
        Pattern p = Pattern.compile(regexStr);//取到的超链接的地址
        Matcher m = p.matcher(destStr);
        List<String> result = new ArrayList<String>();
        while(m.find()){
          result.add(m.group(1));
        }
        return result;
    }


    public static void main(String[] args) {
        String destStr = getURLContent("https://www.kugou.com/song-36/mpu0ye0.html?from_360#hash=B1EC3E9CD29F6A893150C95A37679DEE&album_id=19202059","utf-8");

    //    Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");//渠道的超链接的整个内容
      List<String> result =  getMatherSubstrs(destStr,"href=\"([\\w\\s./:]+?)\"");
        for (String temp :result) {
            System.out.println(temp);
        }  

    }

}
