package Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

public class GenericDAO {
	public static void main(String[] args) throws Exception {
		Method method = GenericDAO.class.getMethod("apply", Vector.class);

		// 得到泛型化的参数类型，返回的是一个数组，因为一个方法可能有多个泛型化的参数类型
		Type[] genericParameter = method.getGenericParameterTypes();

		/*
		 * 这里方法apply只有一个泛型化的参数类型，所以取下标为0，
		 * ParameterizedType代表一个参数化的类型，例如Vector<Date>
		 */
		ParameterizedType parameterizedType = (ParameterizedType) genericParameter[0];

		System.out.println(parameterizedType);;
		// 打印出参数化类型的原始类型
		System.out.println(parameterizedType.getRawType());
		/*
		 * parameterizedType.getActualTypeArguments()返回的是实际类型的数组，
		 * 因为可能有多个如：Map<k,v>这里只有一个，所以取下标0
		 */
		System.out.println(parameterizedType.getActualTypeArguments()[0]);
	}

	/*
	 * 通过vector是没办法得到泛型Vector传进来的是什么类型，即无法得到Date类型 通过apply方法是可以得到它的泛型化参数类型是什么类型的
	 */
	public void apply(Vector<Date> vector) {

	}
}
