package threadinterference_solved_atomic;

//source: https://docs.oracle.com/javase/tutorial/essential/concurrency/atomicvars.html

public class ThreadInterference {

    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        System.out.println("Count: " + counter.value());
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        MyThread t3 = new MyThread(counter);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Count: " + counter.value());
    }
}
