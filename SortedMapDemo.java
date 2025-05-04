package org.example;


import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {

        /*
        Map -- Interface
        SortedMap --- Interface that extends Map
        NavigableMap --- Interface that extends SortedMap

        TreeMap ------ Implements ALl above interfaces Using Red-Black Tree
        So TreeMap Object can be type of TreeMap, SortedMap , NavigableMap or Map

        Below are possible objects of each interface and Tree concrete class

        SortedMap<Integer, String> map = new TreeMap<>();
        NavigableMap<Integer, String> map1 = new TreeMap<>();
        Map<Integer, String> map2 = new TreeMap<>();
        TreeMap<Integer, String> map3 = new TreeMap<>();


         */


        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(3,"three");
        map.put(1, "one");
        map.put(0,"zero");
        map.put(5, "five");
        map.put(4,"four");
       // map.put(null, "k"); // No null as Key is accepted in SortedMap

        System.out.println(map); // {0=zero, 1=one, 3=three, 4=four, 5=five}

        /*
        Key functions of SortedMap-----------
        firstKey() ----------return first key
        lastKey() ----------return last key
        subMap(fromKey, toKey) ----------- return sub map from fromKey to toKey-1(exclusive)
        headMap(toKey) ------------ return map from head key to toKey provided
        tailMap(fromKey) -------------- return map from fromKey to end key
         */
        System.out.println(map.firstKey()); // 0
        System.out.println(map.lastKey()); // 5
        System.out.println(map.subMap(0,1)); // {0=zero}
        System.out.println(map.headMap(3)); // {0=zero, 1=one}
        System.out.println(map.tailMap(2)); // {3=three, 4=four, 5=five}  // returns the submap from where key is greater tah or eqaul to fromKey




        NavigableMap<Integer, String> map1 = new TreeMap<>();
        map1.put(3,"three");
        map1.put(1, "one");
        map1.put(0,"zero");
        map1.put(5, "five");
        map1.put(4,"four");
        // map1.put(null, "5"); // No null as Key is allowed in Navigable map
        System.out.println("Navigable Key-----------");
        System.out.println(map1); // {0=zero, 1=one, 3=three, 4=four, 5=five}

        System.out.println(map1.descendingMap()); // {5=five, 4=four, 3=three, 1=one, 0=zero}
        System.out.println(map1.pollFirstEntry());  // 0=zero
        System.out.println(map1.pollLastEntry());   // 5=five

        System.out.println(map1.higherKey(Integer.valueOf('a'))); // null -- No value greater than 'a' ASCII value is present in map
        System.out.println(map1.lowerKey(2)); // 1
        System.out.println(map1.floorEntry(5));
        System.out.println(map1.ceilingEntry(4));



        TreeMap<Integer, String> map3 = new TreeMap<>();
        map3.put(3,"three");
        map3.put(1, "one");
        map3.put(0,"zero");
        map3.put(5, "five");
        map3.put(4,"four");
        System.out.println("TreeMap Key-----------");
        System.out.println(map3);

        // AnyKind of SortedMap don't allow Key as null
        //map3.put(null, "j"); // It will compile but throw exception at RunTime, NUllPointerException,
        map3.put(4,null); // Null as Value is OK
        System.out.println(map3); // {0=zero, 1=one, 3=three, 4=null, 5=five}
    }
}
