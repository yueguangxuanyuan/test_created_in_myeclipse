package Computation;

import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		ArrayList a = new ArrayList(20);
//		System.out.println(a.size());
//		a.add(1);
//		a.add(-1);
//		Collections.sort(a);
//		System.out.println(getIndex(1, a));
//		long A = 2000000000;
//		System.out.println(A/60  + 20);
		int a = 1;
		int b = 3;
		float tempf = (float) (1.0*a/b);
		System.out.println(tempf);
		
//		System.out.println(Math.pow(2, 16));
//		System.out.println(Math.log(30000)/Math.log(2) );
//		System.out.println(0x12);
//		System.out.println((int)(Math.log(7)/Math.log(2)));
//		//二进制字符串 相互转化
//		System.out.println(Integer.parseInt("1010",2));
//		System.out.println(Integer.numberOfTrailingZeros(20));
//		System.out.println(Integer.numberOfLeadingZeros(20));
//		//位运算
//		 System.out.println(20<<1|1);
//		 System.out.println(24 == 24.0);
//		 //集合运算
//		 Set<A> set =new HashSet<A>();
//		 set.add(new A(1));
//		 if(!set.add(new A(1))){
//		 System.out.println("Success");
//		 }else{
//		 System.out.println("failed " + set.size());
//		 }
	}
	private static int getIndex(int value ,ArrayList<Integer> temp){
		int left = 0;
		int right = temp.size()-1;
		int mid = (left+right) >> 1;
            
        while(right >= left){
        	if(temp.get(mid) == value){
        		return mid+1;
         	}else if(temp.get(mid) > value){
         		right = mid-1;
         	}else{
         		left = mid+1;
         	}
        	mid = (right + left)>>1;
        }
		return 0;
	}

}

class A {
	int i;

	public A(int i) {
		this.i = i;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((A) obj).i == i;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new Integer(i).hashCode();
	}

}