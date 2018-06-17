//source: Joshua Bloch: Effective Java, chapter 10: Concurrency (2nd ed.)

package volatile0;

import java.util.concurrent.TimeUnit;

public class StopThread0 {
	
	private static boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {
	
		Thread backgroundThread = new Thread(new Runnable() {
	
			public void run() {
				int i = 0;
				while (!stopRequested) { 
					i++;
				}
			}
		});
	
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
	
		stopRequested = true;
	}

}
