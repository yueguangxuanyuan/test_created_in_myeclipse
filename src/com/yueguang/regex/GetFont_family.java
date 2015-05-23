package com.yueguang.regex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetFont_family {

	public static void main(String[] args) throws IOException {
		Pattern pattern = Pattern
				.compile("[^{]+\\{[^}]*(font\\-family)[^}]*?\\}");
		// "[^{]+\\{[^\\}]+font\\-family[^\\}]\\}"
		// #test{font-family:haha}#test{font-family:haha}
		File file = new File("cache.txt");
		FileWriter fileWriter = new FileWriter("font.txt" , true);
		fileWriter.append("\n");
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream,"GB2312"));
		String nextLine="";
		while((nextLine=bufferedReader.readLine())!=null){
			Matcher matcher = pattern.matcher(nextLine);
			while (matcher.find()) {
				System.out.println(matcher.group(0));
				fileWriter.append(matcher.group(0) + "\n");
			}
		}
		
		fileWriter.flush();
		fileWriter.close();
	}
}
