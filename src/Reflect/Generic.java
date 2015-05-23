package Reflect;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Generic extends Base<Integer,String> {
	public ArrayList<Integer> B = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
//		Generic c = new Generic();
//		System.out.println(c.getGenericType(0).getName());
		
		//chunck2
//		Type type = StringList.class.getGenericSuperclass();
//	    System.out.println(type); // java.util.ArrayList<java.lang.String>
//	    ParameterizedType pt = (ParameterizedType) type;
//	    System.out.println(pt.getActualTypeArguments()[0]);
	    
		ArrayList<Integer> A = new ArrayList<Integer>();
		System.out.println(((ParameterizedType)A.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
//		ArrayList<ArrayList<Integer>> AA = new ArrayList<ArrayList<Integer>>();
//		AA.add((new ArrayList<Integer>()));
//		System.out.println(Generic.class.getDeclaredFields()[0].getGenericType());
//		System.out.println(Generic.class.getField("B").getGenericType());
	}

	Object array;

	public Generic() {
		array = Array.newInstance(getGenericType(0), 100);
	}
}

class StringList extends ArrayList<String> {
}

class Base<T,F> {
	public Class getGenericType(int index) {
		Type genType = getClass().getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			throw new RuntimeException("Index outof bounds");
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		//System.out.println(params[index]);
		return (Class) params[index];
	}
}
