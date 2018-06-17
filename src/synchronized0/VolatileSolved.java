// based on: Joshua Bloch: Effective Java, chapter 10: Concurrency (2nd ed.)


package synchronized0;

public class VolatileSolved {
	
	private static int nextSerialNumber = 0;
	
	public static synchronized int generateSerialNumber(String name) {
		System.out.println(name + nextSerialNumber);
		return nextSerialNumber++;
	}
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					generateSerialNumber("Thread 1: ");
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					generateSerialNumber("Thread 2: ");
				}
			}
		});
		
		thread1.start();
		thread2.start();

	}
}
