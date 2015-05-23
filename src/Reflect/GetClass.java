package Reflect;

public class GetClass {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class c = Class.forName("java.lang.String");
			System.out.println(c.getSimpleName());
			c = Class.forName("Reflect.Generic");
			System.out.println(c.newInstance().getClass());
			System.out.println(c.getSimpleName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
