package List;

import java.util.ArrayList;

public class TestContains {
	public static void main(String[] args) {
        ArrayList<Integer> ListA = new ArrayList<Integer>();
        ArrayList<Integer> ListB = new ArrayList<Integer>();
	
	    ListA.add(1);
	    ListA.add(2);
	    
	    ListB.add(3);
	    ListB.add(1);
	    System.out.println(ListA.containsAll(ListB));
	}
}
