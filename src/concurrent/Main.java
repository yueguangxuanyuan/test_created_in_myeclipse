package concurrent;

public class Main {

	Object metrux;
	int applecount;

	public Main() {
		metrux = new Object();
		applecount = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.startThread();
	}

	public void startThread() {
		PutApple putApple = new PutApple();
		GetApple getApple = new GetApple();

		Thread putThread = new Thread(putApple);
		Thread getThread = new Thread(getApple);

		putApple.start();
		getApple.start();

	}

	class PutApple extends Thread {
		public void run() {
//			boolean isFull = false;
			while (true) {
				synchronized (metrux) {
					if (applecount < 5) {
						applecount++;
						System.out.println("Put a apple.now have " + applecount
								+ " apple(s)");
						if(applecount == 1){
							metrux.notify();
						}
					} else {
//						isFull = true;
						System.out.println("Package full");
					    try {
							metrux.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
//				if(isFull){
//					Thread.yield();
//				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	class GetApple extends Thread {
		public void run() {
//			boolean isEmpty =false;
			while (true) {
				synchronized (metrux) {
					if (applecount > 0) {
						applecount--;
						System.out.println("Get a apple.now have " + applecount
								+ " apple(s)");
						if(applecount == 4){
							metrux.notify();
						}
					} else {
//						isEmpty = true;
						System.out.println("Package Empty");
						try {
							metrux.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				if(isEmpty){
//					Thread.yield();
//				}
			}

		}
	}
}
