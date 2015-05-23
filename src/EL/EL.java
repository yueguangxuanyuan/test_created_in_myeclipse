package EL;


// String.matches（regex）   是严格匹配    .*可以表示任意字符
public class EL {
	public static void main(String[] args){
//		System.out.println("aa01".matches(".*[a-z]{1,}.*"));
		System.out.println(EL.match("aZ0123543"));
	}
	public static boolean match(String s) {
		if (s.length() < 8 || s.length() > 16) {
			return false;
		} else {
			int count = 0;
			if (s.matches(".*[a-z]{1,}.*")) {
				count++;
			}

			if (s.matches(".*[A-Z]{1,}.*")) {
				count++;
			}

			if (s.matches(".*[0-9]{1,}.*")) {
				count++;
			}

			if (s.matches(".*[~!@#$%]{1,}.*")) {
				count++;
			}
			System.out.println(count);
			if (count >= 3) {
				return true;
			} else {
				return false;
			}
		}

	}

}
