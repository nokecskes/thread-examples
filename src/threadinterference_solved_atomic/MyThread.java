package threadinterference_solved_atomic;

public class MyThread extends Thread {

    AtomicCounter counter;

    MyThread(AtomicCounter counter) {
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
