package Map;

import java.util.TreeMap;

public class GetInexist {
	public static void main(String[] args) {
		TreeMap<Integer, Integer> demotreeMap = new TreeMap<Integer, Integer>();
		if (demotreeMap.get(0) == null) {
			System.out.println("Success");
		} else {
			System.out.println("fail");
		}
	}
}
