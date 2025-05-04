package org.example;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipLIstMapDemo {
    public static void main(String[] args) {

        /*
        If u want synchronized as wel as sorted map use ConcurrentSkipListMap

        It Internally uses ConcurrentSkip data structure to store key value pair
        It scales better than TreeMap and TreeSet
        Best Suitable for read-heavy concurrent application
        O(log n) TC
         */
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();
        map.put( 1,"Hello");
        System.out.println(map);

    }
}
