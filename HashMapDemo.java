package org.example;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<Integer, String > map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println(map);

        System.out.println(map.get(1));
        map.clear();
        System.out.println(map);

        map.put(1,"Apple"); map.put(2,"Banana");map.put(3,"Orange");

        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("Hi"));
        System.out.println(map.size() + " " + map.isEmpty());

        // Advance Put / Update
        // 1. putIfAbsent
        map.putIfAbsent(1,"UpdatedApple");
        System.out.println(map);

        //2. replace(key, newValue)
        map.replace(1,"Replaced");
        System.out.println(map);

        //3. replace(key, value, newValue)
        // worked like chaining , first key should matched then value should be matched then only replace will happen
        map.replace(1,"Replaced", "ReplacingIfOldValueMatched");
        System.out.println(map);

        //3. Compute(key, Bi-function)
        // compute Bi Function for value present at given Key, if Key is not present it will throw NullPointer exception
        map.compute(1, (x,y)->y.toLowerCase());
        System.out.println(map);

        map.put(10, String.valueOf(100));
        map.put(10, null);
        map.remove(10);

        // 4. ComputeIfAbsent(key, Function)
        // computeIFAbsent will work only when if no values (neither null nor any object) is present for key
        // If key itself is not present then key with corresponding mapping func will be added to map
        // computeIfAbsent takes Function as second argument, and that function takes key as input and compute function
        map.computeIfAbsent(10, x-> String.valueOf(Integer.valueOf(x * x)));
        System.out.println(map);

        // 5. computeIfPresent(key, BiFUnction)
        map.computeIfPresent(10, (x,y)->String.valueOf("Hundred"));

        /**
         * Interesting forEach -- ShortCut to iterate over any collection in Single line
         * forEach takes Consumer or BiConsumer as input according to Collection type
         * JVM at the completion expect what kind of data is stored in Collection
         * If entrySet i.e. Key , Value is stored in data structure then , forEach expect BiConsumer of Key value type
         * If Integer is stored in Collection then it will expect the Integer as Consumer type
         */
        map.forEach((key, value) -> System.out.println(key + " : " + value));
        List<Integer> list = Arrays.asList(1,2,3,34,5);
        list.forEach(x-> System.out.print(x));
        Set<Integer> set = new HashSet<>(Arrays.asList(2,3,4,2,3,4));
        System.out.println("Set ----------");
        set.forEach(System.out::print);

        System.out.println();
        System.out.println(map);
        // 6.merge
        /*
        If the key is not present or its value is null, the new value is simply inserted.
        If the key is present and has a non-null value,
        the remappingFunction is applied to the old value and the new value, and the result replaces the existing value.
         */
        /*
        merge takes 3 argument as paarmeters 1. key 2. Value, 3. BiFunction
        Case 1. If key is not present then key with value i.e 2nd arg will be inserted into map
        Case2. If key is present then existing value will be remapped as per 3rd argument and put back in map
                , so in order to remapping we have 2 arguments in biFunction i.e existing value, and new value - combination of both is applied and newValue is calculated
         */
        map.merge(2, "Orange1", (s,t) -> s.concat(t));
        System.out.println(map);
        /*
        {1=replacingifoldvaluematched, 2=Banana, 3=Orange, 10=Hundred}  // before merge
        {1=replacingifoldvaluematched, 2=BananaOrange1, 3=Orange, 10=Hundred} // after merge
         */





    }
}
