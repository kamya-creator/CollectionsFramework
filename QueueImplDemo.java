package org.example;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImplDemo {

    public static void main(String[] args) {

        // LinkedList backed by LinkedList so you can't define capacity of QUEUE at LinkedLIst Constructor
        LinkedList<Integer> linekdListasQueue =  new LinkedList<>();
        linekdListasQueue.addLast(2);  // Queue add ele at last
        linekdListasQueue.addLast(2);
        linekdListasQueue.addLast(3);

        System.out.println("LinekdList as Queue as-------------");
        System.out.println(linekdListasQueue);
        System.out.println(linekdListasQueue.pollFirst());  // Queue remove ele from front
        System.out.println(linekdListasQueue);
        System.out.println(linekdListasQueue.peekFirst());  // Queue peek is first element of front


        // ArrayDequeue is backed up by double ended queue i.e circular array
        // We can define capacity of array in ArrayDequeue
        // It provides index based operation
        // No need to shift here in case of resizing because it has head and tail pointer at both end only pointers values get updated
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(3);
        arrayDeque.addLast(1);
        arrayDeque.addLast(12);
        arrayDeque.addLast(0);
        arrayDeque.addLast(0);

        System.out.println("ArrayDequeue as Queue -------------");
        System.out.println(arrayDeque);
        arrayDeque.pollFirst();
        arrayDeque.pollFirst();
        System.out.println(arrayDeque);


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(8);
        pq.add(0);
        pq.add(-1);
        System.out.println("Queue as PriorityQueue-------------");
        while(pq.size()>0)
        {
            System.out.println(pq.poll());
        }

    }
}
