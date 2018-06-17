//exercise of: https://docs.oracle.com/javase/tutorial/essential/concurrency/QandE/questions.html

package memoryinconsistency;

public class BadThreads {

    static String message;

    private static class CorrectorThread extends Thread {

        @Override
        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
            // Key statement 1:
            message = "Mares do eat oats.";
        }
    }

    public static void main(String args[]) throws InterruptedException {

        (new CorrectorThread()).start();
        message = "Mares do not eat oats.";
        Thread.sleep(2000);
        // Key statement 2:
        System.out.println(message);
    }

}

// Exercise source: https://docs.oracle.com/javase/tutorial/essential/concurrency/QandE/questions.html

// QUESTIIONS:
// The application should print out "Mares do eat oats."
// Is it guaranteed to always do this?
// If not, why not?
// Would it help to change the parameters of the two invocations of Sleep?
// How would you guarantee that all changes to message will be visible in the main thread?
