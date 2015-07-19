package regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuleOutNumbersInAcmCode {
   public static void main(String[] args) throws FileNotFoundException{
	   StringBuffer sb = new StringBuffer();
	   File file = new File("D:\\数据文件\\acm源码\\acm311java.java");
	   Scanner in = new Scanner(file);
	   String temp="";
	   Pattern pattern = Pattern.compile("\\d{2}\\.");
	   Matcher matcher=null;
	   while(in.hasNext()){
		   temp = in.nextLine();
		   matcher = pattern.matcher(temp);
		   while(matcher.find()){
			   matcher.appendReplacement(sb, "");
		   }
		   matcher.appendTail(sb);
		   sb.append("\n");
	   }
	   
	   System.out.println(sb.toString());
	   try {
		FileWriter fw = new FileWriter(file);
		fw.write(sb.toString());
		fw.flush();
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
}
