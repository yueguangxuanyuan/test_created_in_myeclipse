package Kata;

public class Square {

	public static void main(String[] args) {
		System.out.println(Square.isSquare(9859600));
	}

	// 需要考虑 溢出的情况 所以用除法规避溢出 然后检查
	// 当然数据量大的话 可以采取先将Interger 最大算数平方根求出来 然后之后的数 先与这个数比较然后用乘法检查
	public static boolean isSquare(int n) {
		if (n <= 0) {
			return false;
		}
		int low = 1;
		int high = n;
		int mid = (low + high) >> 1;
		while (low <= high) {
			int temp = n / mid;
			if (mid == temp && n == mid * temp) {
				return true;
			}
			if (temp < mid) {
				high = mid - 1;
			}
			if (temp >= mid) {
				low = mid + 1;
			}
			mid = (low + high) >> 1;
		}
		return false; // fix me!
	}
}
