package com.yueguang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p=Pattern.compile("([a-z]+)(\\d+(\\w+))"); 
		Matcher m=p.matcher("aaa2223bb-aaa2223cc"); 
		m.find();   //匹配aaa2223 
		m.find();
		System.out.println(m.group(3));
		System.out.println(m.groupCount());   //返回2,因为有2组 
		m.start(1);   //返回0 返回第一组匹配到的子字符串在字符串中的索引号 
		System.out.println(m.start(2));   //返回3 
		m.end(1);   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置. 
		m.end(2);   //返回7 
		m.group(1);   //返回aaa,返回第一组匹配到的子字符串 
		m.group(2);   //返回2223,返回第二组匹配到的子字符串 
		for(int i = 0 ; i <= m.groupCount();i++){
			System.out.println(m.group(i));
		}
	}
}
