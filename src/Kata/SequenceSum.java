package Kata;

public class SequenceSum {
	public static int[] sumOfN(int n) {
		int prefix = n > 0 ? 1 : -1;
		int size = n * prefix;
		int[] reval = new int[size + 1];

		for (int i = 1; i <= size; i++) {
			reval[i] = reval[i - 1] + prefix * i;
		}
		return reval;
	}
}