package File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
   public static void main(String[] args) throws Exception{
	   File a = new File("a.txt");
	   if(!a.exists()){
		   try {
			a.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
           System.out.println("ERROR: can't create file");
		}
		FileWriter wa = new FileWriter(a, true);
		for(int i = 1 ; i <= 960 ; i++){
			for(int j = 1 ; j <= 1439;j++){
				wa.write(1+" ");
			}
			wa.write(1+"\n");
		}
	   }
   }
}
