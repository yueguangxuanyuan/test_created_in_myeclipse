package Map;

import java.util.HashMap;
import java.util.Random;

public class Exp2 {    
     public static void main(String[] args){    
          HashMap h2=new HashMap();    
          for(int i=0;i<10;i++)    
               h2.put(new Element(1), i);    
          System.out.println("h2:"+h2);    
          System.out.println("Get the result for Element:");    
          Element test=new Element(1);    
          if(h2.containsKey(test))    
               System.out.println(h2.get(test));    
          else   
               System.out.println("Not found");    
     }    
}    
   
class Element{    
    int number;    
    public Element(int n){    
         number=n;    
    }     
    public int hashCode(){    
         return number;    
    }    
    public boolean equals(Object o){    
         return (o instanceof Element) && (number==((Element)o).number);    
    }
    
    public String toString(){
    	return Integer.toString(number);
    }
}  
   
class Figureout{    
     Random r=new Random();    
     boolean possible=r.nextDouble()>0.5;    
     public String toString(){    
          if(possible)    
               return "OK!";    
          else   
               return "Impossible!";    
     }    
}