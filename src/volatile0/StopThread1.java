//based on: Joshua Bloch: Effective Java, chapter 10: Concurrency (2nd ed.)

package volatile0;

import java.util.concurrent.TimeUnit;

public class StopThread1 {
	
	private static volatile boolean stopRequested;
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested) {
					i++;
					System.out.println(i);
				}
				
				if (stopRequested) {
					System.out.println("Last value is: " + i);
				}
			}
		});
	
		backgroundThread.start();
	
		TimeUnit.SECONDS.sleep(1);
	
		stopRequested = true;
	}
}
