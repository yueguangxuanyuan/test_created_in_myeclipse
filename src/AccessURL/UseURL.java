package AccessURL;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//使用URL或者文件地址去解析内部css文件中涉及到font内容的东西并输出进文件
public class UseURL {
	public static void main(String[] args) throws IOException {

		// String urlStrOrDN = "http://www.baidu.com";
		 String urlStrOrDN ="baidusource.txt";
		 String outPutFileName="度娘";
		 getWebPageFont(urlStrOrDN,outPutFileName);
		// String content = getTheRquestedPage(
		// "http://www.iqiyi.com/v_19rrnu7cn4.html?src=focustat_4_20130527_21");
		// FileWriter fileWriter=new FileWriter("iqiyi.txt");
		// fileWriter.write(content);
		// fileWriter.close();

//		String content = getTheRquestedPage("http://www.baidu.com");
//		System.out.println(content);
//		FileWriter fileWriter = new FileWriter("baidu.txt");
//		fileWriter.write(content);
//		fileWriter.close();
	}

	public static void getWebPageFont(String urlStrOrDN, String outPutFileName)
			throws IOException {
//		String sTotalString = getTheRquestedPage(urlStrOrDN);
		 String sTotalString = getFile(urlStrOrDN);
		parseAndWrite(sTotalString, outPutFileName);
	}

	public static void parseAndWrite(String sTotalString, String outPutFileName)
			throws IOException {
		FileWriter fileWriter = new FileWriter(
				new File(outPutFileName + ".txt"));
		// 解析行内样式表
		fileWriter.write("parse inline css\n");
		Pattern InlineStylePattern = Pattern
				.compile("style=\"[^\"]*(font)[^\"]*\"");
		Matcher InlineStyleMatcher = InlineStylePattern.matcher(sTotalString);
		while (InlineStyleMatcher.find()) {
			fileWriter.write(InlineStyleMatcher.group() + "\n");
		}
		// 解析内部样式表
		fileWriter.write("parse Inner css\n");
		Pattern InnerStylePattern = Pattern
				.compile("<style[^<]*(font)[^<]*</style>");
		Matcher InnerStyleMatcher = InnerStylePattern.matcher(sTotalString);
		while (InnerStyleMatcher.find()) {
//			fileWriter.write(InnerStyleMatcher.group() + "\n");
			Pattern ruleWithFontPattern = Pattern
					.compile("[^{}]+\\{[^}]*font[^}]*?\\}");
			Matcher ruleWithFontMatcher = ruleWithFontPattern
					.matcher(InnerStyleMatcher.group());
			while (ruleWithFontMatcher.find()) {
				fileWriter.write(ruleWithFontMatcher.group() + "\n");
			}
		}
		// 解析外部样式表
		fileWriter.write("parse Outer css\n");
		Pattern OuterStylePattern = Pattern
				.compile("<link[^>]*rel=\"stylesheet\"[^>]*>");
		Matcher OuterStyleMatcher = OuterStylePattern.matcher(sTotalString);

		while (OuterStyleMatcher.find()) {
			System.out.println(OuterStyleMatcher.group());
			Pattern CSSurlPattern = Pattern.compile("href=\"([^\"]+)\"");
			Matcher cssUrlMatcher = CSSurlPattern.matcher(OuterStyleMatcher
					.group());
			while (cssUrlMatcher.find()) {
				System.out.println(cssUrlMatcher.group(1));
				fileWriter.write("source : " + cssUrlMatcher.group(1) + "\n");
				String cssFile = getTheRquestedPage(cssUrlMatcher.group(1));
				
//				fileWriter.write(cssFile+"\n");
				
				Pattern ruleWithFontPattern = Pattern
						.compile("[^{}]+\\{[^}]*font[^}]*?\\}");
				Matcher ruleWithFontMatcher = ruleWithFontPattern
						.matcher(cssFile);
				while (ruleWithFontMatcher.find()) {
					fileWriter.write(ruleWithFontMatcher.group() + "\n");
				}
			}
		}
		fileWriter.close();
	}

	public static String getFile(String url) throws IOException {
		StringBuilder stotal = new StringBuilder();
		File file = new File(url);
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(fileInputStream, "UTF-8"));
		String nextLine = "";
		while ((nextLine = bufferedReader.readLine()) != null) {
			stotal.append(nextLine);
		}
		return stotal.toString();
	}

	public static String getTheRquestedPage(String urlStrOrDN)
			throws IOException {
		URL url = new URL(urlStrOrDN);
		URLConnection URLconnection = url.openConnection();
//		URLconnection.setDoOutput(true);
		URLconnection.setReadTimeout(100 * 1000);
		URLconnection.setRequestProperty("Host", "www.baidu.com");
		URLconnection
				.setRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 6.3; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
		URLconnection.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		URLconnection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		URLconnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
		URLconnection
				.setRequestProperty(
						"Cookie",
						"BAIDUID=CEA5100BDF424DDE7D5A4BEA11EBB9CA:FG=1; BD_UPN=13314552; MCITY=-%3A; BAIDUPSID=CEA5100BDF424DDE7D5A4BEA11EBB9CA; BIDUPSID=CEA5100BDF424DDE7D5A4BEA11EBB9CA; BD_HOME=0; H_PS_PSSID=13454_13782_11076_1433_13720_13075_12824_12868_13323_12691_13691_10562_12722_13210_13256_13781_12279_13086_8498; sug=3; sugstore=0; ORIGIN=2; bdime=0; __bsi=9292565461875788083_31_0_I_R_16_0303_C02F_N_I_I");
        URLconnection.setRequestProperty("Connection", "keep-alive");
		HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
		int responseCode = httpConnection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			InputStream urlStream = httpConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(urlStream));
			String sCurrentLine = "";
			StringBuilder sTotalString = new StringBuilder();
			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				sTotalString.append(sCurrentLine);
			}
			return sTotalString.toString();
		}

		return responseCode+"";
	}
}
