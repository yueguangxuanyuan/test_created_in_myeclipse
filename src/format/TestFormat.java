package format;

import java.io.UnsupportedEncodingException;

public class TestFormat {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		System.out.println(-10004 % 10003 );
		System.out.println(((String)null) == null);
//        System.out.format("%2.2f", 1.2121);
        double  A = 1212.121;
        System.out.println(String.format("%2.2f", A));
        System.out.println(10);
        System.out.println(new String("赵铁柱".getBytes("UTF8"), "UTF8"));
	}

}
