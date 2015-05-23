package TestMath;

public class TestPow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        System.out.println((int)Math.pow(2, 10));
		 System.out.println(24&(-24));
	}
	private int getMod2Max(int n){
		int mark =0;
		while( n%2 == 0){
			mark ++;
			n = n/2;
		}
		return (int)Math.pow(2, mark);
	}
}
