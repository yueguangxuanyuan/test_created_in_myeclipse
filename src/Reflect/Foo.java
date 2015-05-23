package Reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public abstract class Foo<T> {

//	Class<T> type;

	public Foo() {
//		this.type = (Class<T>) getClass();
	}

	public static void main(String[] args) {

		Foo<Integer> foo = new Foo<Integer>() {
		};
		Type mySuperClass = foo.getClass().getGenericSuperclass();
		System.out.println("#3 : " + foo.getClass());
		System.out.println("#2 : " + mySuperClass);
		Type type = ((ParameterizedType) mySuperClass).getActualTypeArguments()[0];
		System.out.println(type);
          
		ArrayList<Integer> A = new ArrayList<Integer>();
		mySuperClass = A.getClass().getGenericSuperclass();
		System.out.println("#4 : " + A.getClass());
		System.out.println("#5 : " + A.getClass().getGenericInterfaces());
		System.out.println("#1 : " + mySuperClass);
		type = ((ParameterizedType) mySuperClass).getActualTypeArguments()[0];
		System.out.println(type);
		System.out.println(((ParameterizedType)A.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
}