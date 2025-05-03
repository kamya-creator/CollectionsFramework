package org.example;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0;i<10000;i++)
        {
            list.add(i);
        }
        ListIterator<Integer> listIterator = list.listIterator();
       while (listIterator.hasNext())
        {
           // System.out.print(listIterator.next()+ " ");
            if(listIterator.next().equals(new Integer(3)))
            {
                //list.add(33); // Will cause concurrent modification exception
                listIterator.set(33) ; // thread safe -- will not cause concurrent modification exception
            }
        }

        // Note -- Exception in thread "main" java.util.ConcurrentModificationException
        // while doing reading and writing on ArrayList simultaneously list.add will throw ConcurrentModificationException
//        for(int i : list)
//        {
//            System.out.print(i);
//            if(i==3)
//            {
//                list.add(33);
//            }
//        }


        // CopyOnWriteArrayList is a thread-safe variant of ArrayList in Java.
        // It allows safe iteration even when multiple threads are modifying the list simultaneously.
        //
        // How it works:
        //
        // 1. For **read operations**, threads read from the current array (no locking required).
        // 2. For **write operations** (like add, remove, set):
        //    - A **new copy** (snapshot) of the underlying array is created.
        //    - The write operation is applied to this new array.
        //    - Once done, the reference to the array is **atomically updated** to point to the new one.
        //
        // This means:
        // - Readers never see a partially modified array.
        // - Writers work on an isolated copy, avoiding interference with readers.
        //
        // Trade-offs:
        // - **Pros**: Safe iteration without `ConcurrentModificationException`.
        // - **Cons**: Costly for frequent write operations (due to copying).

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
       for(int i = 10;i<100;i++)
       {
           copyOnWriteArrayList.add(i);
       }

       for(Integer i : copyOnWriteArrayList)
       {
           System.out.print(i + " ");
           if(i.equals(new Integer(20)))
           {
               System.out.println("Inside");
               System.out.println(copyOnWriteArrayList.remove(i));
               System.out.println(copyOnWriteArrayList.add(124));
           }
       }
        System.out.println(copyOnWriteArrayList);
    }
}
