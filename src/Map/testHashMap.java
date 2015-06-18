package Map;

import java.util.HashMap;

public class testHashMap {
    public static void main(String[] args){
    	HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
    	
    	hashMap.put("3", 1);
    	hashMap.put("1", 4);
    	hashMap.put("2", 2);
    	hashMap.put("5", 3);
    	hashMap.put("4", 5);
    	
    	StringBuilder sb = new StringBuilder("{");
		for (String key : hashMap.keySet()) {
			sb.append("\"" + key + "\" : " + hashMap.get(key) + ",");
		}
		sb.setCharAt(sb.length() - 1, '}');
		System.out.println(sb.toString());
		
		for(String i : hashMap.keySet()){
    		System.out.print(i + "\n");
    	}
    	
    }
}
