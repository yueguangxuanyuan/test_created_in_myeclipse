package List;

public class Test {
	public static void main(String[] args) {
//		function();
		int[][] list = new int[5][4];
		System.out.println(list.length);
	}	
	
	public static void function() {
		int num = 1;
		int j = 0;
		int k = 0;
		int[][] juzhen = new int[10][];
		for(int i=0; i<juzhen.length; i++) {
			juzhen[i] = new int[10-i];	
		}
		
		
		while(k<10) {
			juzhen[j][k] =  num;
			num++;
			if(j == 0) {
				j = k+1;
				k = 0;	
			} else {
				j--;
				k++;	
			}
			
		}
		
		for(int i=0; i<juzhen.length; i++) {
			for(int m=0; m<juzhen[i].length; m++) {
				System.out.print(juzhen[i][m] + "\t" );	
			}	
			
			System.out.println();
		}
	}
}
