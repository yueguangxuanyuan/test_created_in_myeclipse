package Computation;

import java.util.Scanner;

public class Compute_Combination {
    public static void main(String[] args){
    	Compute_Combination c = new Compute_Combination();
    	c.solution();
    }
    
    public void solution(){
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt() ;
    	int r = in.nextInt();
    	
    	int result = 1;
    	for(int i = 0 ; i < r; i++ ){
    		result *= (n-i);
    	}
    	
    	for(int i = 1 ; i <= r; i++ ){
    		result /= i;
    	}
    	
    	System.out.println("result:"+result);
    }
}
