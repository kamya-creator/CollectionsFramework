package org.example;

import java.lang.reflect.Field;
import java.util.*;
import static java.util.Collections.*;

public class ArrayListDepth  implements Cloneable{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        // ArrayList initialized with 0 capacity as parameter is not passed in constructor
        // only upon adding ele to arraylist, initialCapacity as 10 will be defined
        ArrayList<Integer> list = new ArrayList<>();
        Field feild = ArrayList.class.getDeclaredField("elementData");
        feild.setAccessible(true);
        Object[] o =(Object[]) feild.get(list);
        // In java 8 ArrayList is lazy loaded, if you don't perform any addition operation in list ,
        // it won't initialize capacity if in constructor u didn't pass value
        System.out.println(o.length);


        for(int i =1;i<11;i++)
        {
            list.add(i);
        }
        //list.add(22);
        // printing capacity of list using reflection qki elementData ek private variable h ArrayList class ka
        feild = ArrayList.class.getDeclaredField("elementData");
        feild.setAccessible(true);
        o =(Object[]) feild.get(list);

        System.out.println(o.length);

        // checks if given element is present in collection
        System.out.println(list.contains(38));
        // reduce collection capacity to size i.e removing unused spaces from capacity array
        list.trimToSize();

        feild = ArrayList.class.getDeclaredField("elementData");
        feild.setAccessible(true);
        o =(Object[]) feild.get(list);
        System.out.println(o.length);

        ArrayList<Integer> list2 = new ArrayList<>(list);
        System.out.println(list2);
        list2.add(1, 34);
        System.out.println(list2);

        List<Integer> list3 = new ArrayList<>();
        for(int i =0;i<7;i++)
        {
            list3.add(i);
        }
        // add complete collection at the end of list2
       // list2.addAll(list3);

        // add complete collection at index passed
        list2.addAll(4, list3);
        System.out.println(list2);

        // compare each element of list3 with ele of list 2. If matches remove it
        list2.removeAll(list3);
        System.out.println(list2);

        // save only those ele which are equal to element of list3
        list2.retainAll(list3);
        System.out.println(list2);

        list3.clear();
        System.out.println(list3);

        List<Integer> list4 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list4.add(i);
        }
        // set ele at given index if index is present else will throw error
        list4.set(8, 88);
        list4.set(9, 88);
        System.out.println(list4);

        // returns first index of give ele if found else return -1
        System.out.println(list4.indexOf(880));
        // returns last index of give ele if found else return -1
        System.out.println(list4.lastIndexOf(88));

        // returns true if list contains given ele
        System.out.println(list4.contains(3));

        // returns true if list contains all elements of given collection
        System.out.println(list4.containsAll(list3));

        System.out.println("Iterator---------------");
        Iterator<Integer> iterator = list4.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("ListIterator---------------");
        ListIterator<Integer> integerListIterator = list4.listIterator(list4.size());
        while (integerListIterator.hasPrevious())
        {
            System.out.print(integerListIterator.previous() +" ");
        }


        System.out.println();
        System.out.println("ToArray------Object---------");
        for (Object object : list4.toArray()) {
            System.out.print(object + " ");
        }
        System.out.println();
        System.out.println("ToArray -----Integer----------");

        List<Object> list5 = new ArrayList<>();
        list5.add("1");
        list5.add("2");
        String[] array = list5.toArray(new String[0]);
        for (String integer : array) {

            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("Clone -----------");
        List<Object> ls = (List<Object>) list.clone();
        System.out.println(ls);

        ls =  list5.subList(0,2);
        System.out.println(ls);


        Double[] arr = {1.0, 2.0, 3.0, 6.0, 4.0, 5.0};
        List<Double> list1 =  Arrays.asList(arr);
        for (int i = 0; i < list1.size(); i++) {

            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        Integer[] arr1 = {1,2,3,4,5,6,7,8};
        List<Integer> list6 = Arrays.asList(arr1);
        for (int i = 0; i < list6.size(); i++) {

            System.out.print(list6.get(i) + " ");
        }

        System.out.println();
        System.out.println("Remove By index and by Object-----------");
        ArrayList<Integer> list7 = new ArrayList<>();
        list7.add(101); list7.add(9); list7.add(7); list7.add(88);
        // will remove by index
        list7.remove(1);
        System.out.println(list7);

        // remove by object
        list7.remove(new Integer(7));
        System.out.println(list7);

        // Collections static classes are imported -- import static
        sort(list7);
        System.out.println(list7);
    }
}
