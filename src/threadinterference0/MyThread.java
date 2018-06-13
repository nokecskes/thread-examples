package threadinterference0;

public class MyThread extends Thread {

    Counter counter;

    MyThread(Counter counter) {
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
