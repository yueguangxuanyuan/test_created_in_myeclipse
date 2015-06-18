package concurrent;

import java.util.concurrent.Semaphore;

/*
 * 这里采用 semaphore  来实现操作系统概念中的信号量
 * 所有线程通过向semaphore 获取锁  来实现同步
 */

public class TestSemaphore {
	Semaphore semaphoreA = new Semaphore(1);
	Semaphore semaphoreB = new Semaphore(1);
	Semaphore semaphoreC = new Semaphore(1);

	public static void main(String[] args) {
		TestSemaphore testSemaphore = new TestSemaphore();
		testSemaphore.test();
	}
 
	public void test() {
		try {
			semaphoreB.acquire();
			semaphoreC.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread printA = new Thread(new Print("A", semaphoreA, semaphoreB));
		Thread printB = new Thread(new Print("B", semaphoreB, semaphoreC));
		Thread printC = new Thread(new Print("C", semaphoreC, semaphoreA));
		printA.start();
		printB.start();
		printC.start();
	}

	class Print implements Runnable {

		String name;
		Semaphore mutex;
		Semaphore mutexnext;

		public Print(String name, Semaphore mutex, Semaphore mutexnext) {
			this.name = name;
			this.mutex = mutex;
			this.mutexnext = mutexnext;
		}

		public void run() {
			int i = 10;
			while (i-- > 0) {
				try {
					mutex.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("this is : " + name);

				mutexnext.release();
			}
		}

	}

}
