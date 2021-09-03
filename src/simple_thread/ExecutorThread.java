//source: https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
package simple_thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ExecutorThread {

    // Display a message, preceded by the name of the current thread
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);

        boolean isDaemon = Thread.currentThread().isDaemon();
        System.out.println(isDaemon);
    }

    private static class MessageLoop implements Runnable {

        @Override
        public void run() {
            String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too" };
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        // Delay, in milliseconds before we interrupt MessageLoop thread (default one hour).
        long patience = 1000 * 60 * 60;
        // long patience = 1000;

        // If command line argument present, gives patience in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();

        ForkJoinPool executor = new ForkJoinPool();
        executor.execute(new MessageLoop());
        executor.awaitTermination(25, TimeUnit.SECONDS);

        threadMessage("Finally!");
    }

}
