package concurrent;

import java.util.concurrent.Semaphore;

public class AddandMinus {
	int j = 0;

	public static void main(String[] args) {
		new AddandMinus().test();
	}

	public void test() {
		Semaphore semaphoreJ = new Semaphore(1);
		Semaphore semaphoreAdd = new Semaphore(2);
		Semaphore semaphoreMinus = new Semaphore(0);

		Thread thread1 = new Thread(new AddJ(semaphoreJ, semaphoreAdd,
				semaphoreMinus));
		Thread thread2 = new Thread(new AddJ(semaphoreJ, semaphoreAdd,
				semaphoreMinus));
		Thread thread3 = new Thread(new MinusJ(semaphoreJ, semaphoreMinus,
				semaphoreAdd));
		Thread thread4 = new Thread(new MinusJ(semaphoreJ, semaphoreMinus,
				semaphoreAdd));
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

	class AddJ implements Runnable {
		Semaphore semaphore;
		Semaphore semaphorethis;
		Semaphore semaphorenext;

		public AddJ(Semaphore semaphore, Semaphore semaphorethis,
				Semaphore semaphorenext) {
			this.semaphore = semaphore;
			this.semaphorethis = semaphorethis;
			this.semaphorenext = semaphorenext;
		}

		public void run() {
			int count = 10;
			while (count-- > 0) {
				try {
					semaphorethis.acquire();
					semaphore.acquire();
					j++;
					System.out.println(Thread.currentThread().getName()+" : "+j);
					semaphore.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semaphorenext.release();
			}

		}
	}

	class MinusJ implements Runnable {
		Semaphore semaphore;
		Semaphore semaphorethis;
		Semaphore semaphorenext;

		public MinusJ(Semaphore semaphore,Semaphore semaphorethis,Semaphore semaphorenext) {
			this.semaphore = semaphore;
			this.semaphorethis = semaphorethis;
			this.semaphorenext = semaphorenext;
		}

		public void run() {
			int count = 10;
			while (count-- > 0) {
				try {
					semaphorethis.acquire();
					semaphore.acquire();
					j--;
					System.out.println(Thread.currentThread().getName()+" : "+j);
					semaphore.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semaphorenext.release();
			}
		}

	}
}
