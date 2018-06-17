package threadinterference0;

//source: https://www.javacodex.com/Threads-and-Processes/Thread-Interference-Example
//Three threads incrementing and decrementing many 1000's of times (at the same time) and in the end the count should be zero.

public class ThreadInterference {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
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
