package Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class putJsonObject {
    public static void main(String[] args) throws JSONException{
    	JSONObject myObject =  new JSONObject();
    	myObject.put("wu", 1);
    	myObject.put("you", 2);
    	myObject.put("hua", 3);
    	
    	
    	System.out.println(myObject.keys().next());
    	
    	JSONArray myArray = new JSONArray();
    	myArray.put(0,4);
    	myArray.put(1, 5);
		myArray.put(3,2);
    	
    	myObject.append("6", myArray);
    	System.out.println(myObject);
    	
    	JSONArray newArray = new JSONArray();
    	
    	for(int i = 0 ; i < 2 ; i ++){
    		JSONObject newJsonObject = new JSONObject();
    		newJsonObject.put("label",(int)(Math.random()*9999));
    		
    		JSONArray dataArray = new JSONArray();
    		for(int j = 0 ; j <= 23 ; j ++ ){
    			for(int k = 0 ; k < 60 ; k ++){	
    				dataArray.put(new JSONArray().put(j+k*1.0/100).put((int)(Math.random()*100)));
    			}
    		}
    		newJsonObject.put("data", dataArray);
    		newArray.put(newJsonObject);
    	}
    	System.out.println(newArray);
    }
}
