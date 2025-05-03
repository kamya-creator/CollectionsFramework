package org.example;

import java.util.ArrayList;
import java.util.Vector;

public class VectorInDepth {
    public static void main(String[] args) throws InterruptedException {
        // Array backed Data structure
        // Eager Loading -- array with give or default size will be allocated in memory before any add operation
        Vector<Integer> vector = new Vector<>();
        System.out.println(vector.capacity()); // 10

        // Instead of default size of array we are providing initialCapacity of array as 2
        vector = new Vector<>(1);
        vector.add(1);vector.add(2); vector.add(3); vector.add(3);vector.add(3);
        System.out.println(vector.capacity()); // 2

        // In ArrayList array size increase 1.5x times , but
        // in Vector it Increase ( initialCapacity + capacityIncrement ) total if capacityIncremente provided
        // else it will just double the capacity
        /*
        int newCapacity = (capacityIncrement > 0) ?
                    oldCapacity + capacityIncrement :
                    oldCapacity * 2;

         */
        vector = new Vector<>(2,3);
        vector.add(1); vector.add(2);
        System.out.println(vector.capacity()); //2

        vector.add(3);
        System.out.println(vector.capacity()); // 5


        // Let's Prove that Vector is Thread Safe

        // Using ArrayList means synchronization is missing , leads to race condition
        // final size of list must be 2000 but it will not be because of ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        Thread thread1 = new Thread(()->{
            for(int i =0;i<1000;i++)
            {
                list.add(i);
            }
        });

        Thread thread2 = new Thread(()->{
            for(int i =0;i<1000;i++)
            {
                list.add(i);
            }
        });

        thread1.start(); thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final ArrayList-----------");
        System.out.println(list.size());


        Vector<Integer> vectorList = new Vector<>();

        Thread t1 = new Thread(()->{
            for(int i =0;i<1000;i++)
            {
                vectorList.add(i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i =0;i<1000;i++)
            {
                vectorList.add(i);
            }
        });

        t1.start();t2.start();

        t1.join(); t2.join();

        System.out.println("Vector List Size");
        System.out.println(vectorList.size());

    }
}
