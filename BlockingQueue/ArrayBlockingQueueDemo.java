package org.example.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
        Basic Producer-Consumer with ArrayBlockingQueue
        Implement a program with one producer and one consumer using ArrayBlockingQueue<Integer>.
        The producer should generate numbers 1–10 and put them in the queue.
        The consumer should take and print them.
        Bounded Queue Behavior
        _____________________________
        Create an ArrayBlockingQueue of size 2.
        Start a thread that adds 3 elements.
        Observe how put() blocks after the queue is full.
         */
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2);

        Thread producer = new Thread(()->{

            for(int i =1;i<=10;i++)
            {
                try {
                    System.out.println("Trying to Produce :"+i);
                    arrayBlockingQueue.put(i); // This may block if queue is full
                    System.out.println("Produced :"+i);
                    Thread.sleep(1);
                    if(arrayBlockingQueue.size() == 2){
                        System.out.println(arrayBlockingQueue);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->{

            for (int i = 1; i <=10 ; i++) {

                try {
                    Integer ele = arrayBlockingQueue.take(); // This may block if Queue is Empty
                    Thread.sleep(2);
                    System.out.println("Consumed :" + ele);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
