package TryCatch;

public class testFinally {
     public static void main(String[] args){
    	 testFinally testFinally = new testFinally();
    	 testFinally.testIt();
     }
     
     
     public boolean testIt(){
    	 try{
    		 return true;
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 System.out.println("access finally");
    	 }
    	 return false;
     }
}
