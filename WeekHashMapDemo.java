package org.example;

import java.util.Map;
import java.util.WeakHashMap;

public class WeekHashMapDemo {

    public static void main(String[] args) throws InterruptedException {


        // It works as HashMap but only difference is if Key provided in map has week reference it will remove entry from map
       Map<String, Integer> stringIntegerWeakHashMap = new WeakHashMap<>();
        stringIntegerWeakHashMap.put(new String("Hi"), 1);

        // literals are stored in String pool have strong reference hence, weakHashMap won't remove string literal keys even u hit System.gc()
        stringIntegerWeakHashMap.put("Hello",1);
        System.out.println(stringIntegerWeakHashMap);
        Thread.sleep(20000);
        System.gc();
        System.out.println(stringIntegerWeakHashMap);

        /*
        Use Case-
        1. Used for Caching purpose, where entries can be discarded if they are not used (provides keys must have week reference)
        2. When you want map keys not to prevent from Garbage Collection
         */
    }
}
