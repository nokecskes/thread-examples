//source: https://docs.oracle.com/javase/tutorial/essential/concurrency/QandE/answers.html
package guarded_blocks_blocking_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        BlockingQueue<String> drop = new SynchronousQueue<String>();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
