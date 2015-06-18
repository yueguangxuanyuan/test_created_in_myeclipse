package Kata;

import java.util.HashMap;

public class DnaStrand {
	public static String makeComplement(String dna) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();

		map.put('A', 'T');
		map.put('T', 'A');
		map.put('G', 'C');
		map.put('C', 'G');

		char[] reval = new char[dna.length()];

		for (int i = 0; i < dna.length(); i++) {
			reval[i] = map.get(dna.charAt(i));
		}
		return String.valueOf(reval);
	}
}
