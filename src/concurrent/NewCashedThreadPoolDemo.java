package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
 * 这实验了  newCachedThreadPool 方法来获取线程池
 * 
 * 根据源码  得到的ExceutorService  的核心线程池数量为0 
 *                             最大线程池数量为Integer.Max_Value
 *                             额外线程有60s的存活期
 *                             使用SynchronousQueue<Runnable>()方式来处理等待线程
 *                             
 *另外明确一点  shutdown 和shutdownNow
 *   shutdown  将会把shutdown标志位标记为true  线程不接受新的输入
 *   shotdownNow   首先是将shutdown标志位标记为true，另外他会把等待线程清空，
 *                 并且将所有已有线程的interrupt标记为设置为true,处理或者不处理这个标签更具线程本身或者框架的设置来决定
 */
public class NewCashedThreadPoolDemo {
	static int A = 0;

	public static synchronized void addA() {
		A = A + 1;
		// System.out.println(Thread.currentThread().getId());
		System.out.println(A);
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					for (int j = 0; j < 1000; j++) {
						if (Thread.currentThread().isInterrupted()) {
							System.out.println("interrupted");
							break;
						}
						NewCashedThreadPoolDemo.addA();
					}
				}
			});
		}

		System.out.println("OUT OF LOOP");
		if (cachedThreadPool.isShutdown()) {
			System.out.println("shut down already");
		} else {
			// cachedThreadPool.shutdownNow();
			cachedThreadPool.shutdownNow();
			System.out.println("shut down by hand");
		}
	}
}
