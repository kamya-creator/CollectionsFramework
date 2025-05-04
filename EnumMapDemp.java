package org.example;

import java.util.EnumMap;
import java.util.HashMap;

public class EnumMapDemp {
    enum DAY{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THRUSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
    public static void main(String[] args) {

        /*
        Using HashMap Enum values as Key hashValue will be generated and stored in map , extra Overhead we have better option as EnumMap
         */
        HashMap<DAY, String> map = new HashMap<>();
        map.put(DAY.MONDAY,"OOPS");
        System.out.println(map);
        map.put(DAY.SUNDAY,"Drama");
        System.out.println(map);


        /*
        EnumMap don;t used Hashing internally
        Enum has constant elemenst in it Ok,
        EnumMap uses this fact and create an array 0 based indexing
        for every key it put its value at array index


        enumMap = [_,_,_,_,_,_,_,_] --- pre-created at the time of declaration
        enumMap.put(DAY.SUNDAY,"COOKING");
        Day.SUNDAY is at index 6
        enumMap = [_,_,_,_,_,_,_,"COOKING]

        enumMap.put(DAY.WEDNESDAY, "Multithreading");
        Day.SUNDAY is at index 2
        enumMap = [_,_,"Multithreading",_,_,_,_,"COOKING]
         */

        EnumMap<DAY, String > enumMap = new EnumMap<>(DAY.class);
        enumMap.put(DAY.SUNDAY,"COOKING");
        enumMap.put(DAY.WEDNESDAY, "Multithreading");

        System.out.println(enumMap);
        System.out.println(enumMap.get(DAY.SUNDAY));

    }
}
