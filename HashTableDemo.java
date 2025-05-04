package org.example;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) throws InterruptedException {

        // Is Part of Java since 1.2 Version
        // same as hashmap, but it is synchronized
        // no key allowed, no value allowed
        // legacy class
        // slower than hashMap
        // Uses linkedList even after threshold of collision exceeds
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1,10);
        hashtable.put(3,30);
        hashtable.put(2,20);

        System.out.println(hashtable);

       // hashtable.put(null, 1); // no null key is allowed
       //  hashtable.put(1, null);  // no null value is allowed

        HashMap<Integer, Integer> map = new HashMap<>();
        Thread thread = new Thread( ()->{

                for(int i =0;i<1000;i++)
                {
                    map.put(i,i);
                }
        });

        Thread thread2 = new Thread( ()->{

            for(int i =1000;i<2000;i++)
            {
                map.put(i,i);
            }
        });

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();

        System.out.println(map.size()); // map size will not be 2000 as , it is not synchronized


        Hashtable<Integer, Integer> hashtable_sync = new Hashtable<>();

        Thread t1 = new Thread(() -> {
            for(int i =0;i<1000;i++)
            {
                hashtable_sync.put(i,i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i =1000;i<2000;i++)
            {
                hashtable_sync.put(i,i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(hashtable_sync.size()); // It will always be 2000, because hashTable is synchronized
        /*
        HashTable completely lock the HashTable for both read and write operation , hence is quite slower
        In order to achieve good performance any synchronization we Have ConcurrentHashMap
         */
    }
}
