package Map;

import java.util.*;

public class HashMaps {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		map.put("d", "ddd");
        
		System.out.println(map);
		Iterator iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println("map.get(key) is :" + map.get(key));
		}

		Hashtable tab = new Hashtable();
		tab.put("a", "aaa");
		tab.put("b", "bbb");
		tab.put("c", "ccc");
		tab.put("d", "ddd");
		Iterator iterator_1 = tab.keySet().iterator();
		while (iterator_1.hasNext()) {
			Object key = iterator_1.next();
			System.out.println("tab.get(key) is :" + tab.get(key));
		}

		TreeMap tmp = new TreeMap();
		tmp.put("a", "aaa");
		tmp.put("b", "bbb");
		tmp.put("c", "ccc");
		tmp.put("d", "ddd");
		tmp.put("a", "aba");
		Iterator iterator_2 = tmp.keySet().iterator();
		while (iterator_2.hasNext()) {
			Object key = iterator_2.next();
			System.out.println("tmp.get(key) is :" + tmp.get(key));
		}
        
		
	   LinkedHashMap<String ,Integer>  linkedHashMap = new LinkedHashMap<String,Integer>();
	   linkedHashMap.put("dasdsa", 1);
	   linkedHashMap.put("gdsf",2);
	   linkedHashMap.put("texvdfd", 3);
	   linkedHashMap.put("bdada", 4);
	   
	   linkedHashMap.put("gdsf",3);
	   for(String temp : linkedHashMap.keySet()){
		   System.out.println(temp);
	   }
	   
	}

}
