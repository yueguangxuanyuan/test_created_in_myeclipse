package concurrent;

import java.util.HashMap;
import java.util.UUID;

// hashtable 在多线程激烈竞争的情况下会引起  死锁   
//下面的程序 多跑几次  就会出现死锁
public class hashMapInConcurrent {
	public static void main(String[] args) throws InterruptedException {
		final HashMap<String, String> map = new HashMap<String, String>(2);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
							System.out.println(Thread.currentThread().getName()
									+ " : " + UUID.randomUUID().toString());
						}
					}, "ftf" + i).start();
				}
			}
		}, "ftf");
		t.start();
		t.join();
		System.out.println(t.getName());
	}
}
