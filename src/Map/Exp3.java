package Map;

import java.util.HashMap;

public class Exp3 {    
     public static void main(String[] args){    
          HashMap h2=new HashMap();    
          for(int i=0;i<10;i++)    
               h2.put(i, new Figureout());    
          System.out.println("h2:"+h2);    
          System.out.println("Get the result for Element:");    
//          Element_1 test=new Element_1(5);    
          if(h2.containsKey(5))    
               System.out.println((Figureout)h2.get(5));    
          else   
               System.out.println("Not found");    
     }    
}    
   
//class Element_1{    
//     int number;    
//     public Element_1(int n){    
//          number=n;    
//     }     
//}    
