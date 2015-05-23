package com.yueguang.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddHref {
	public static void main(String[] args){
		Scanner in = new  Scanner(System.in);
		System.out.println(AddLinkToText(in.next()));
	}
    /** 
     * 给一个字符串添加链接 
     * @param text 要添加链接的字符串 
     * @param url 链接的URL 
     * @return 添加链接后的字符串 
     */  
    public static String AddHref(String text, String url) {  
        return  "<a href=\"" + url +  "\">" + text + "</a>";  
    }  
      
    /** 
     * 查找文本中的URL字符串，并将其添加链接 
     * @param text 需要查找的文本 
     * @return 添加链接后的文本 
     */  
    public static String AddLinkToText(String text) {  
        Pattern pattern = Pattern.compile("http://([\\w-]+.)+[\\w-]+(/[\\w-./?%&=#]*)?");  
        Matcher matcher = pattern.matcher(text);  
        StringBuffer sb = new StringBuffer();           //定义一个字符缓冲区，用于保存新的文本  
        while (matcher.find()) {  
            String matchedSubStr = matcher.group();     //提取出查找到的子串  
            matcher.appendReplacement(sb, AddHref(matchedSubStr, matchedSubStr));   //将找到的子串添加链接后塞到字符缓冲区内  
        }  
        matcher.appendTail(sb);  
        return sb.toString();  
    }     
}
