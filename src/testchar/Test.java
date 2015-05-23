package testchar;

import java.io.UnsupportedEncodingException;

public class Test {

	public static void main(String[] args) {
		String str = "中";
		char x = '中';
		byte[] bytes = null;
		byte[] bytes1 = null;
		try {
			bytes = str.getBytes("utf-8");
			bytes1 = charToByte(x);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("bytes 大小：" + bytes.length);
		System.out.println("bytes1大小：" + bytes1.length);
		System.out.println(bytes1[0] + "--" + bytes1[1]);
		System.out.println(byteToChar(bytes1) + "||");
	}

	public static byte[] charToByte(char c) {
		byte[] b = new byte[2];
		b[0] = (byte) ((c & 0xFF00) >> 8);
		b[1] = (byte) (c & 0xFF);
		return b;
	}

	public static char byteToChar(byte[] b) {
		int a =(b[0] << 8) + b[1];
		return (char) ((b[0] << 8) + b[1]);
	}
}
