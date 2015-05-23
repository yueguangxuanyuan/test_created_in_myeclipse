package TestMath;

import java.text.DecimalFormat;

public class TestDecimalFormat {
	public static void main(String[] args) {
		double y = 0;
		double x = 64;
		int n = 3;

		y = java.lang.StrictMath.pow(x, 1.0 / n);
		DecimalFormat bd = new DecimalFormat("########");// 把double四舍五入取整

		System.out.println(bd.format(y));
		System.out.println((2 == Math.sqrt(4)));
	}
}