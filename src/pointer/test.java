package pointer;

public class test {
	public static void main(String[] args) {
       A();
       String a =new String("aaa");
       C(a);
       System.out.println("main: "+a);
	}

	public static void A() {
		Haha a = new Haha();
		a.a = "hehe";
		B(a);
		System.out.println("A ： "+a.a);
	}

	public static void B(Haha a) {
		a.a = "haha";
		System.out.println("B ： "+a.a);
	}
	public static void C(String a) {
		a = new String(a+" is changed");
		System.out.println("C : "+a);
	}
	static class Haha {
		public String a = "haha";
	}
}
