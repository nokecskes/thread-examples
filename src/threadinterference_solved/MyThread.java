package threadinterference_solved;

public class MyThread extends Thread {

    SynchronizedCounter counter;

    MyThread(SynchronizedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int x = 0; x < 100000000; x++) {
            counter.increment();
            counter.decrement();
            counter.increment();
            counter.decrement();
        }
    }
}
