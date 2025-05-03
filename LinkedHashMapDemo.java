package org.example;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // LinkedHashMap preserves the Ordering of insertion
        // LinkedHashMap is backed by doubly Linked list that's why insertion order is preserved
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Alice", 99);
        linkedHashMap.put("Jon", 87);
        linkedHashMap.put("Ram" , 100);
        linkedHashMap.forEach((k,v) -> System.out.println(k + " : "+ v));


        // 1. LinkedHashMap with no argument
        LinkedHashMap<String , Integer> marks = new LinkedHashMap<>();
        marks.put("Krishna", 89);
        marks.put("Radhe", 99);
        marks.put("Govind", 76);
        marks.put("Madhav", 76);
        marks.get("Krishna");

        System.out.println(marks);

        // 2. LinkedHashMap with 2 argument i.e initialCapacity of bucket and loadFactor
        // Same as hashmap, when size * loadfactor reaches beyond capacity then double the size of array bucket
        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>(2, 0.3f);
        linkedHashMap1.put("A",1);
        linkedHashMap1.put("B",2);
        linkedHashMap1.put("C",3);
        System.out.println(linkedHashMap1);


        // 3. LinkedHashMap with 3 arguments i.e initailCapacity, loadFactor and accessOrder
        // accessOrder = true, It means recently used entrySet will be placed at last of map

        LinkedHashMap<String, Integer> linkedHashMap_aceessOrder = new LinkedHashMap<>(2, 0.3f, true);
        linkedHashMap_aceessOrder.put("Krishna", 101);
        linkedHashMap_aceessOrder.put("Radhe", 102);
        linkedHashMap_aceessOrder.put("Hello" , 5);
        linkedHashMap_aceessOrder.put("World", 109);

        // {Krishna=101, Radhe=102, Hello=5, World=109}
        System.out.println(linkedHashMap_aceessOrder);  // Ok no issues , linkedhash will print as its order

        linkedHashMap_aceessOrder.get("Krishna"); // now you are accessing ele from 0 index so it will be placed at the last of map
        System.out.println(linkedHashMap_aceessOrder); // {Radhe=102, Hello=5, World=109, Krishna=101}

        // This property of linkedHashMap i.e accessOrder = true is helpful in building LRU - Least Recently Used


    }
}
