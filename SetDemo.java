package org.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetDemo {
    public static void main(String[] args) throws InterruptedException {
        // Map -> HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap, EnumMap, ConcurrentSkipListMap
        // Set -> HashSet, LinkedHashSet, TreeSet, EnumSet, ConcurrentSkipListSet, CopyOnWriteSet

        Set<Integer> set = new HashSet<>();
        set.add(2);set.add(2);set.add(1);  // Unordered Set
        System.out.println(set);

        set = new TreeSet<>();  // Ordered Set -- Ascending order
        set.add(2);set.add(9);set.add(1);
        System.out.println(set);

        set = new TreeSet<>((a,b)->b-a); // Descending Order
        set.add(8);set.add(3);set.add(9);
        System.out.println(set);
        Set<Integer> finalSet = new TreeSet<>();

        for (int i = 0; i < 100; i++) {
            finalSet.add(i);
        }

        /*
        HashSet and TreeSet both throws ConcurrentModificationException when 2 thread read and write simultaneously
           Exception in thread "Thread-1" java.util.ConcurrentModificationException
         */

        Thread t1 = new Thread(()->{
            for (int i = 100; i < 200; i++) {

                finalSet.add(i);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        Thread t2 = new Thread(()->{
            Iterator<Integer> iterator = finalSet.iterator();
            while(iterator.hasNext())
            {
                Integer ele = iterator.next();
                System.out.println("Reading : " + ele);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();

        //t2.start();

        t1.join();
        t2.join();

         // CopyOnWriteArraySet is thread safe -- it fail-safe, perform write operations on copy of original array
        Set<Integer> set1 = new CopyOnWriteArraySet<>();
        for(int i =0;i<100;i++)
        {
            set1.add(i);
        }
        Thread thread1 = new Thread(() -> {

            for (int i = 100; i < 200; i++) {

                set1.add(i);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        thread1.start();

        Thread thread2 =  new Thread( ()->{

            Iterator<Integer> iterator = set1.iterator();
            while(iterator.hasNext())
            {
                int ele = iterator.next();
                if(ele % 2 == 0)
                {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    finalSet.remove(ele);
                }
            }
        });

        thread2.start();

        thread1.join();
        thread2.join();



    }
}
