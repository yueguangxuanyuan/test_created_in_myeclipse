package Computation;

import java.util.ArrayList;

public class ArrayList_has_Point {
	public static void main(String[] args) {
		// ArrayList<Point> pointList = new ArrayList<Point>();
		// pointList.add(new Point(3,4));
		//
		// System.out.println(pointList.contains(new Point(3,4)));

		ArrayList<Item> pointList = new ArrayList<Item>();
		pointList.add(new Item(3, 4, 5, 1));

		System.out.println(pointList.contains(new Item(3, 4, 5, 2)));

	}

}

class Item {
	int[] cups;
	int mark;

	public Item(int A, int B, int C, int mark) {
		cups = new int[3];
		cups[0] = A;
		cups[1] = B;
		cups[2] = C;

		this.mark = mark;
	}

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if ((cups[0] == ((Item) o).cups[0]) && (cups[1] == ((Item) o).cups[1])
				&& (cups[2] == ((Item)o).cups[2])) {
			return true;
		}
		return false;
	}
}
