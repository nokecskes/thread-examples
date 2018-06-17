package volatile1;
//based on: Joshua Bloch: Effective Java, chapter 10: Concurrency (2nd ed.)

public class Volatile {

	private static volatile int nextSerialNumber = 0;
	
	public static int generateSerialNumber() {
		return nextSerialNumber++;
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread 1 : " + generateSerialNumber());
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread 2 : " + generateSerialNumber());
				}
			}
		});
		
		thread1.start();
		thread2.start();

	}
}
