package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Stack internally extends Vector, so it will have all functions of Vector as well
        stack.add(1);
        stack.add(2);
        stack.addAll(Arrays.asList(1,2,3,4,5));
        System.out.println(stack);
        stack.add(2,3);
        stack.set(2,33);
        stack.addElement(99);
        System.out.println(stack);

        stack.remove(3);
        System.out.println(stack);
        stack.remove(Integer.valueOf(3));
        System.out.println(stack);

        System.out.println("Iterator---------------");
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() +" ");
        }
        System.out.println();
        System.out.println("ListIterator- Forward Iterartion--------------");
        ListIterator<Integer> listIterator = stack.listIterator();
        while (listIterator.hasNext())
        {
            System.out.print(listIterator.next() +" ");
        }
        System.out.println();
        System.out.println("List Iterator in Backward direction--------");
        listIterator = stack.listIterator(stack.size());
        while (listIterator.hasPrevious())
        {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println(stack.contains(99));

        // Stack Class methods --------
        // push , pop, peek, search, isEmpty

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);stack2.push(2);stack2.push(3);
        System.out.println(stack2);

        System.out.println(stack2.pop());

        System.out.println(stack2.peek());

        System.out.println(stack2.search(88));
        stack2.clear(); // clear is vector methods not of stack method
        System.out.println(stack2.isEmpty());
    }
}
