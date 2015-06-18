package String;

import java.util.Date;

public class ValueOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaaa.jpg";
		System.out.println(a.replaceFirst(".+\\.",String.valueOf(new Date().getTime())+"."));
	}
}
