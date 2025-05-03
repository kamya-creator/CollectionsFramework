package org.example;

import java.security.Key;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, String> {

    private int capacity;

    LRUCache(int capacity)
    {
        super(capacity,0.75f, true);
        this.capacity = capacity;
    }



    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > capacity;
    }
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, "One");
        cache.put(2 ,"Two");
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache); // order get changes as per access - recently used ele added at last

        cache.put(3 , "Three");
        System.out.println(cache);


    }
}
