package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InterruptThreadPool {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("interrupted");
						break;
					}
				}
			}
		});

		executor.shutdownNow();
		if (!executor.awaitTermination(10, TimeUnit.MICROSECONDS)) {
			System.out
					.println("Still waiting after 10ms: calling System.exit(0)...");
			System.exit(0);
		}
		System.out.println("Exiting normally...");
	}

}
