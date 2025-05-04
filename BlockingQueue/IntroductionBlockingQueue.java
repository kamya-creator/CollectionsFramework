package org.example.BlockingQueue;

import java.util.concurrent.*;

public class IntroductionBlockingQueue {
    public static void main(String[] args) {

        /*
        BlockingQueue is an interface in the java.util.concurrent package.
        It was introduced in Java 1.5.

        It is a thread-safe queue designed to support blocking operations.
        This makes it ideal for handling concurrent producer-consumer scenarios.

        Blocking behavior:
        - If the queue is FULL, a producer thread calling put() will block until space is available.
        - If the queue is EMPTY, a consumer thread calling take() will block until an element is available.

        How do we define if the queue is full or empty?
        - By specifying the queue's capacity at the time of creation (for bounded queues).

        BlockingQueue -- Interface
        Common Implementations:

        1. ArrayBlockingQueue
           - Bounded (fixed size).
           - Backed by an array.
           - Elements are ordered FIFO.

        2. LinkedBlockingQueue
           - Can be bounded or unbounded. capacity is Optional in constructor
           - Backed by linked nodes.
           - Typically used in Executor frameworks. -- next topic multithreading hi padhenge

        3. PriorityBlockingQueue
           - Unbounded.
           - Orders elements according to their natural ordering or a comparator.
           - Doesn't guarantee FIFO.

        4. DelayQueue
           - Unbounded.
           - Elements must implement the Delayed interface.
           - Elements can only be taken after a delay expires.

        5. SynchronousQueue
           - Has no capacity.
           - Each insert operation must wait for a corresponding remove operation.
           - Used for direct handoffs between threads.

        6. LinkedBlockingDeque
           - A double-ended queue variant of LinkedBlockingQueue.
           - Allows insertion/removal from both ends.
        */

        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        BlockingQueue<Integer> linkedListBlockingQueueUnbounded = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> linkedListBlockingQueueBounded = new LinkedBlockingQueue<>(3); // explicitly making LinkedBlockingQueue bounded

        BlockingQueue<Integer> priorityBlockingQueueUnbounded = new PriorityBlockingQueue<>();

        // That constructor sets the initial capacity, not the maximum capacity —
        // it can still grow beyond that. So it remains unbounded in behavior.
        BlockingQueue<Integer> priorityBlockingQueueBounded = new PriorityBlockingQueue<>(9);

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>(); // Blocked until produced item is consumed
        DelayQueue<Task> delayQueue = new DelayQueue<>(); // Unbounded BQ, element will only be taken when its delay has been expired

        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();



    }
    class Task implements Delayed{


        private final String name;
        private final long startTime;
        Task(String name, long startTime) {
            this.name = name;
            this.startTime = startTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long delay = startTime - System.currentTimeMillis() ;
            return unit.convert(delay, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {

            if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS) )
            {
                return -1;
            }
            else if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
            {
                return 1;
            }
            else{
                return  0;
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", startTime=" + startTime +
                    '}';
        }
    }
}
