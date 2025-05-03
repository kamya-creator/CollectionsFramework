package org.example;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapDemo {
    public static void main(String[] args) {

        // HashMap uses the Key class hashCode, here String hashCode will be used
        // String hashCode works on string value not on  address
        // hence here only one value of new String("Key1") will be calculated , resulting in only one entry in map
        HashMap<String, Integer> map = new HashMap<>();
        map.put(new String("key1"), 1);
        map.put(new String("key1"), 1);
        System.out.println(map); // {key1=1}


        // If we want instead  of key class Hash value must be calculated using Object class use IdentityHashMap
        // Object class calculate hash function using the address of object only
        IdentityHashMap<String, Integer> integerIdentityHashMap = new IdentityHashMap<>();
        integerIdentityHashMap.put(new String("key1"),1);
        integerIdentityHashMap.put(new String("key2") , 1);
        System.out.println(integerIdentityHashMap); // {key1=1, key2=1}
    }
}
