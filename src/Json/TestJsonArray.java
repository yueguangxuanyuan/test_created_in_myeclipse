package Json;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestJsonArray {
	public static void main(String[] args) {
		JSONArray ja = new JSONArray(new ArrayList());
		System.out.println(ja.toString());
		try {
			JSONArray testNull = new JSONArray("[1222,null,null]");
			System.out.println(testNull.isNull(1));
			System.out.println(!testNull.isNull(1)?(testNull.getDouble(1)):-1);
			
			JSONObject jsonObject = new JSONObject() ;
			jsonObject.put("test","1000");
			System.out.println(new BigDecimal(jsonObject.getString("test")).divide(new BigDecimal(1000)).compareTo(new BigDecimal(1)));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
