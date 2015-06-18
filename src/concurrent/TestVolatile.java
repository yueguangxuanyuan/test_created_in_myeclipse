package concurrent;


/*
 * 测试结果：
 * volalite关键字在多核下比较有用  在简单程序中效果并不明显
 * 
 * volalite关键字保证对元素的读写 写入内存中  使得程序在多核多线程并行运行的时候的正确性
 * 
 * 但是volalite  只能保证某一变量元素值的唯一性，并不能保证程序逻辑的正确性
 * 我们需要采用同步的时候可能更多的需要将一系列活动封装成原子操作，
 * 
 * 总的来说  如果只是需要保证元素在某一时间点取值的正确性的话  那么volatile将比 synchronized 更加高效
 * 也就是我们至多应该只有一个线程在对元素进行赋值操作
 * 
 * 在我看来  volatile 做不了同步
 */
public class TestVolatile {
	public static void main(String[] args) {
		TestVolatile.test();
	}

	public static void test() {
		TestVolatile testVolatile = new TestVolatile();
		Thread t1 = new Thread(new AddA(testVolatile));
		Thread t2 = new Thread(new AddA(testVolatile));
		t1.start();
		t2.start();
	}

	// volatile
	static protected long a = 1L;

}

class AddA implements Runnable {
	TestVolatile testVolatile = new TestVolatile();

	public AddA(TestVolatile testVolatile) {
		this.testVolatile = testVolatile;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			testVolatile.a = testVolatile.a + 1;
			System.out.println(Thread.currentThread().getName() + " :  "
					+ testVolatile.a);
		}
	}

}