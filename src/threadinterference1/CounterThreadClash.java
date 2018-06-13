package threadinterference1;

//source: https://gist.github.com/revox/ce6dc504a12dec10e140

public class CounterThreadClash {

    static Counter count = new Counter();

    static class t1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                count.increment();
            }
            System.out.println("t1 " + count.value());
        }

    }

    static class t2 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                count.increment();
            }
            System.out.println("t2 " + count.value());
        }
    }

    public static void main(String[] args) {
        new t1().start();
        new t2().start();
    }
}
