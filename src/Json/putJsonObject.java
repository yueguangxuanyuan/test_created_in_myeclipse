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
    	
    	
    	System.out.println(myObject);
    	
    	JSONArray myArray = new JSONArray();
    	myArray.put(0,4);
    	myArray.put(1, 5);
		myArray.put(3,2);
    	
    	myObject.append("6", myArray);
    	System.out.println(myObject);
    }
}
