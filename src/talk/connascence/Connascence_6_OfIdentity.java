package talk.connascence;

import java.util.PriorityQueue;
import java.util.Queue;

public class Connascence_6_OfIdentity {

    // Two components must reference the same object

    // Example 1
    private static class Producer implements Runnable {

        public static Queue<String> queue = new PriorityQueue<>();

        public void run() {
            queue.add("first");
        }
    }

    private class Consumer implements Runnable {

        public void run() {
            String item = Producer.queue.poll();
            // do something with item
        }
    }
}
