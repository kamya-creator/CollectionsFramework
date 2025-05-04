package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {

    public static void main(String[] args) {

        Map<String, Integer> map  = new HashMap<>();
        map.put("Hello", 1);
        map.put("World",2);
        System.out.println(map);

        /*
        A View is created for map which is unmodifiable , it means U cannot update View of map
        But map is still modifiable
         */
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        System.out.println(unmodifiableMap);
        System.out.println(unmodifiableMap.get("Hello"));
        // unmodifiableMap.put("Hi", 3); // UnsupportedOperationException --- U are chaning view of unmodifiablemap

        /*
        Use Map.of() to create Unmodifiable map
         */
        // Map.of can take upto 10 key value pairs in comma separated format
        Map<String, Integer> unmofiableMap_Using_Map_OF = Map.of("A", 1, "B", 2, "C", 3, "D", 4, "E", 5, "F", 6, "G", 7, "H", 8, "I", 9, "J", 10);
        System.out.println(unmofiableMap_Using_Map_OF);

        // If we want more than 10 key value pair in unmodifiable map use Map.ofEntries() function
        Map<String, Integer> ofEntries = Map.ofEntries(Map.entry("A", 1),
                Map.entry("B", 2),
                Map.entry("C", 3),
                Map.entry("D", 4),
                Map.entry("E", 5),
                Map.entry("F", 6),
                Map.entry("G", 7),
                Map.entry("H", 8),
                Map.entry("I", 9),
                Map.entry("J", 10),
                Map.entry("K", 11),
                Map.entry("L", 12),
                Map.entry("M", 13),
                Map.entry("N", 14)
        );

        System.out.println(ofEntries);
        // ofEntries.put("O",15); // throws UnSupportedOperationException
    }
}
