package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddHref {
	public static void main(String[] args){
		Scanner in = new  Scanner(System.in);
		System.out.println(AddLinkToText(in.next()));
	}
    /** 
     * ��һ���ַ�������� 
     * @param text Ҫ������ӵ��ַ� 
     * @param url ���ӵ�URL 
     * @return ������Ӻ���ַ� 
     */  
    public static String AddHref(String text, String url) {  
        return  "<a href=\"" + url +  "\">" + text + "</a>";  
    }  
      
    /** 
     * �����ı��е�URL�ַ�������������� 
     * @param text ��Ҫ���ҵ��ı� 
     * @return ������Ӻ���ı� 
     */  
    public static String AddLinkToText(String text) {  
        Pattern pattern = Pattern.compile("http://([\\w-]+.)+[\\w-]+(/[\\w-./?%&=#]*)?");  
        Matcher matcher = pattern.matcher(text);  
        StringBuffer sb = new StringBuffer();           //����һ���ַ�������ڱ����µ��ı�  
        while (matcher.find()) {  
            String matchedSubStr = matcher.group();     //��ȡ�����ҵ����Ӵ�  
            matcher.appendReplacement(sb, AddHref(matchedSubStr, matchedSubStr));   //���ҵ����Ӵ�������Ӻ����ַ������  
        }  
        matcher.appendTail(sb);  
        return sb.toString();  
    }     
}
