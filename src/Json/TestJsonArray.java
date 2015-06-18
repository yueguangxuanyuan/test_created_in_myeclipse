package Json;

import java.util.ArrayList;

import org.json.JSONArray;

public class TestJsonArray {
   public static void main(String[] args){
	   JSONArray ja = new JSONArray(new ArrayList());
       System.out.println(ja.toString());
   }
}
