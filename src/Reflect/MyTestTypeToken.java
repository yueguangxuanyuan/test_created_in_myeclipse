package Reflect;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class MyTestTypeToken {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 Type type = new TypeToken<List<String>>(){}.getType();
		 System.out.println(type);
		 
	}
}
