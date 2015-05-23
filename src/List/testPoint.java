package List;

import java.awt.*;
import java.util.ArrayList;

public class testPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Point> smallmetric = new ArrayList<Point>();
		smallmetric.add(new Point(1,2));
		System.out.println(smallmetric.get(0) == new Point(1,2));
		smallmetric.remove(new Point(1, 2));
		System.out.println(smallmetric);
	}

}
