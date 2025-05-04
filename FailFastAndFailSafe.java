package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafe {

    public static void main(String[] args) {

        /*
        FAIL-FAST -- Throw ConcurrentModificationException when any structural operation t.e adding or removing ele is performed
                        Ex- HashMap, ArrayList, HashSet

         FAIL-SAFE --- Doesn't throw any ConcurrentModificationException when any structural operation t.e adding or removing ele is performed
                        because It performs action on copy of original collection not on collection itself
                        After modification original reference will be getting changed to newly updated collection i.e copy of collection with new Value

                        Ex- CopyOnWriteArrayList, ConcurrentHashmap, ConcurrentSet

         */

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,34,4,5,6,5));

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext())
        {
            int ele = iterator.next();
            System.out.println(ele);
            if(ele %2 == 0)
            {

                // ArrayList is not support concurrentModification hence it will fail-fast when you perform remove operation
                // Exception in thread "main" java.util.ConcurrentModificationException
               // list.remove(ele);
            }
        }


        while (iterator.hasNext())
        {
            int ele = iterator.next();
            System.out.println(ele);
            if(ele % 2 ==0)
            {
                // It will not trow any exception because iterator are fail-safe
                iterator.remove();
            }
        }


        List<Integer> list2 = new CopyOnWriteArrayList<>();

        list2.add(1);
        list2.add(7);
        list2.add(4);
        list2.add(3);
        list2.add(2);

        Iterator<Integer> iterator1 = list2.iterator();

        while (iterator1.hasNext())
        {
            int ele = iterator1.next();
            System.out.println(ele);
            if(ele %2 ==0)
            {
                // Won't throw any kind of exception
                // Fail safe with CopyOnWriteArrayList
                list2.remove(ele);
            }
        }


    }
}
