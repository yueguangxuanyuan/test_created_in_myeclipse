package List;

import java.util.ArrayList;

public class Exp_AddALL1 {
   public static void main(String[] args){
	   ArrayList<Integer> pointList = new ArrayList<Integer>();
	   ArrayList<Integer> targetList = new ArrayList<Integer>();
	   
	   pointList.add(1);
	   pointList.add(2);
	   
	   
	   targetList.add(2);
	   targetList.add( 3);
	   
	   targetList.addAll(pointList);
	   
	   for(int i = 0 ; i < targetList.size() ;i++){
		   System.out.println(targetList.get(i));
	   }
   }
}
