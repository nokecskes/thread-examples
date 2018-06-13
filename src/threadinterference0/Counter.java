package threadinterference0;

public class Counter {

    private int c = 0;

    public void increment() {
        c = c + 1;
    }

    public void decrement() {
        c = c - 1;
    }

    public int value() {
        return c;
    }
}
