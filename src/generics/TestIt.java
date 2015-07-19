package generics;

import java.util.LinkedList;
import java.util.List;

//interface Sink<T> {
//
//    void flush(T t);
//
//}
public class TestIt {
//	public static <T> T writeAll(T[] coll, Sink<T> snk) {
//
//		T last = null;
//
//		for (T t : coll) {
//
//			last = t;
//
//			snk.flush(last);
//
//		}
//
//		return last;
//
//	}
//	
	

	public static void main(String[] args) {
		
		//在泛型匹配是 Array是类型兼容的 T[] a， E b，   只要T super E  就能通过 T[] a,T b 的编译
		// 而collection 则不能通过 必须严格遵守
//		Sink<Object> s;
//		String[] cs;
//		String str = writeAll(cs, s);

		//在使用多态的时候数据自身类型并没有擦除，对子类重载方法的调用还是调用子类的方法
		animal a = new cat();
		a.eat();
		System.out.println(a + "  ||  " + a.getClass());
		
		//使用通配符声明 不能对数据进行添加操作 因为类型未知，null属于任何集合类型所有可以加进去 但没意义
		// Collection<?> c = new ArrayList<animal>();
		// c.add(null);
            
		//泛型的一大误区在于我们认为泛型的类型没有变，比如我们将List<String> 赋值给 List   但是我们可以给后来的List添加非String对象
		// loophole(2);
		
		//泛型参数可以用于强制转化 但是不安全，能通过编译 但是会产生运行时错
		// System.out.println(badCast("sss", "kkk"));

		//可以用通配符声明未知类型的泛型类容器  但是对于取出的东西必须强制类型转换 否则为未知类型
		// List<?>[] lsa = new List<?>[10]; // ok, array of unbounded wildcard
		// type
		// Object o = lsa;
		// Object[] oa = (Object[]) o;
		// List<Integer> li = new ArrayList<Integer>();
		// li.add(new Integer(3));
		// oa[1] = li; // correct
		// System.out.println(lsa[1].get(0));
		// String s =(String)lsa[1].get(0); // run time error, but cast is explicit

		//泛型在运行是类型是擦除的  用instanceof 检查   比如  ArrayList<Integer>和ArrayList<String>的getClass 拿到的都是同样的类型
		// Collection cs = new ArrayList<String>();
		// if (cs instanceof Collection<String>) {} //非法

		//还是属于经典错误
		// List<String> ls = new ArrayList<String>();
		// List lo = ls;
		// lo.add(new Object());
		// String s = (String) lo.get(0);
	}

	static <T> T badCast(T t, Object o) {
		return (T) o; // unchecked warning
	}

	public static String loophole(Integer x) {

		List<String> ys = new LinkedList<String>();

		List xs = ys;

		xs.add(x); // compile-time unchecked warning

		return ys.iterator().next();

	}

	public static <T extends Comparable<? super T>> void judge(T t) {
	}
}

class someanimal<T extends animal> {

}

class animal {
	public void eat() {
		System.out.println("animal eat");
	}
}

class cat extends animal {
	@Override
	public void eat() {
		System.out.println("cat eat");
	}
}