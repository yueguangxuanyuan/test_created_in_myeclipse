package regex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseDIV {
	public static void main(String[] args) throws IOException {
		Pattern pattern = Pattern.compile("(<div>)([^<]*)(</div>)");
		File file = new File("overview.html");
		FileWriter fileWriter = new FileWriter(new File("output.txt"));
		Scanner in = new Scanner(file, "UTF8");
		// Scanner in = new Scanner(System.in,"UTF8");
		while (in.hasNextLine()) {
			String nextLine = in.nextLine();
			Matcher matcher = pattern.matcher(nextLine);
			// System.out.println(nextLine);
			// System.out.println(matcher);
			while (matcher.find()) {
//				System.out.println(matcher.group(2));
			    fileWriter.write(matcher.group(2)+"\n");
			}
		}
		fileWriter.flush();
		fileWriter.close();
	}
}
