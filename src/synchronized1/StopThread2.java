// based on: Joshua Bloch: Effective Java, chapter 10: Concurrency (2nd ed.)


package synchronized1;

import java.util.concurrent.TimeUnit;

public class StopThread2 {
	
	private static boolean stopRequested;
		
	private static synchronized void requestStop() {
	stopRequested = true;
	}
		
	private static synchronized boolean stopRequested() {
	return stopRequested;
	}
		
	public static void main(String[] args) throws InterruptedException {
	
		Thread backgroundThread = new Thread(new Runnable() {
		
			public void run() {
				int i = 0;
			
				while (!stopRequested()) {
					i++;
					System.out.println(i);
				}
			}
		});
		
		backgroundThread.start();
	
		TimeUnit.SECONDS.sleep(1);
		
		requestStop();
	}
}
