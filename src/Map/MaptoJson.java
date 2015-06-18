package Map;

import java.util.HashMap;
import java.util.Map;
import org.json.*;

public class MaptoJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> testMap = new HashMap<String, Integer>();
		testMap.put("aaaa", 1);
		testMap.put("2222", 1212);

		JSONObject jo = new JSONObject(testMap);

		System.out.println(jo.toString());

		Map<String, Float> testMap1 = new HashMap<String, Float>();
		testMap1.put("aaaa", (float) 1.0);
		testMap1.put("2222", (float) 1212.0);

		jo = new JSONObject(testMap1);
		System.out.println(jo);
		
		Map<Integer, Float> testMap2 = new HashMap<Integer, Float>();
		testMap2.put(11, (float) 1.0);
		testMap2.put(2222, (float) 1212.0);
		jo = new JSONObject(testMap2);
        System.out.println(jo);
	}

	class TestObject {
		private String ss = " a";
		private String aa = "b ";
		private String ee = "c ";

		public String getSs() {
			return ss;
		}

		public void setSs(String ss) {
			this.ss = ss;
		}

		public String getAa() {
			return aa;
		}

		public void setAa(String aa) {
			this.aa = aa;
		}

		public String getEe() {
			return ee;
		}

		public void setEe(String ee) {
			this.ee = ee;
		}

	}

}
