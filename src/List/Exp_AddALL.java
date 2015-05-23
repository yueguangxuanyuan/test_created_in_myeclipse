package List;

import java.awt.*;
import java.util.ArrayList;

public class Exp_AddALL {
   public static void main(String[] args){
	   ArrayList<Point> pointList = new ArrayList<Point>();
	   ArrayList<Point> targetList = new ArrayList<Point>();
	   
	   pointList.add( new Point(1,1));
	   pointList.add( new Point(1,2));
	   
	   
	   targetList.add(new Point(1,2));
	   targetList.add( new Point(3,3));
	   
	   targetList.addAll(pointList);
	   
	   for(int i = 0 ; i < targetList.size() ;i++){
		   System.out.println(targetList.get(i));
	   }
   }
}
