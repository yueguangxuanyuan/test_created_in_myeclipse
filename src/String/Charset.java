package String;

public class Charset {
	public static void main(String[] args) {
//		String a = "难得";
//		byte[] bytes = a.getBytes();
//		System.out.println(a);
//		try {
//			a = new String(bytes, "UTF8");
//			System.out.println(a);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String s = "21-14-不好";
		System.out.println(s.split("\\|").length);
		
		String temp ="tour/eee/sss";
		
		System.out.println(temp.replace('/','-'));
	}
}
