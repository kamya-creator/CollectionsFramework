package org.example;

import java.util.*;

public class LinkedListInDepth {
    public static void main(String[] args) {

        // 1. Creation
        // Internally Linked list used double ended Linked List, so we need not give initialCapacity here
        LinkedList<Integer> linkedList = new LinkedList<>(); // Construct empty linked list
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList);

        linkedList = new LinkedList<>(Arrays.asList(12,13,14,15,16)); // Construct linked list with specified elements present in given Collection
        System.out.println(linkedList);

        // 2. Basic Operation
        System.out.println(linkedList.contains(12)); // true
        linkedList.add(1,3); // 12,3,13, 14,15,16
        System.out.println(linkedList);
        System.out.println(linkedList.get(1)); // 3
        linkedList.addAll(Arrays.asList(4 ,5,6,7,8,90,0));
        System.out.println(linkedList); // 12,3,13, 14,15,16,4,5,6,7,8,90,0

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5,4,3,2,1,3));
        linkedList.addAll(3,arr); // 12,3,13, 5,4,3,2,1,3 ,14,15,16,4,5,6,7,8,90,0
        System.out.println(linkedList);

        System.out.println(linkedList.indexOf(3)); // return first index of ele
        System.out.println(linkedList.remove(3)); // remove element at index
        System.out.println(linkedList.removeAll(List.of(3))); // Convert primitive datatype to Collection object and then remove all occurrence of collection object from LL
        System.out.println(linkedList);
        linkedList.addAll(List.of(3,3,3,3,3));
        System.out.println(linkedList);
        System.out.println(linkedList.lastIndexOf(3));
        System.out.println(linkedList.indexOf(3));

        ListIterator<Integer> listIterator = (ListIterator<Integer>) linkedList.iterator();
        while (listIterator.hasNext())
        {
            // hasNext ko break krne ke liye ya aage badhane ke liye .next() chalana hi padega
           System.out.print(listIterator.next() +" ");

        }
        System.out.println();
        // ListIterator has capability to iterate backward direction
        ListIterator<Integer> listIterator1 = linkedList.listIterator(linkedList.size());
        while (listIterator1.hasPrevious())
        {
            // hasPrevoius() ko break krne ke liye .prevoius() chalana hi padega
            System.out.print(listIterator1.previous() + " Previous ");
        }
        System.out.println();
        System.out.println("descending Iterartor--------------");
        Iterator<Integer> integerIterator = linkedList.descendingIterator();
        while(integerIterator.hasNext())
        {
            if(integerIterator.next().equals(new Integer(3)))
                integerIterator.remove();
        }
        integerIterator = linkedList.descendingIterator();
        while (integerIterator.hasNext())
        {
            System.out.print(integerIterator.next()+" ");
        }

    }
}
