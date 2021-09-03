package guarded_blocks;


public class ProducerConsumerExample {

    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop), "cica1")).start();
        (new Thread(new Consumer(drop), "cica2")).start();
    }

}
