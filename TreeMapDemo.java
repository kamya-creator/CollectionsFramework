package org.example;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {

        class Student implements Comparable<Student>{

            private int Id;
            private String name;
            private String subject;

            public Student( String name, int id,String subject) {
                Id = id;
                this.name = name;
                this.subject = subject;
            }

            public int getId() {
                return Id;
            }

            public void setId(int id) {
                Id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "Id=" + Id +
                        ", name='" + name + '\'' +
                        ", subject='" + subject + '\'' +
                        '}';
            }

            @Override
            public int compareTo(Student o) {
                return this.getName().compareTo(o.getName());
            }
        }
        class SubjectComparator implements Comparator<Student>
        {

            @Override
            public int compare(Student o1, Student o2) {
                return  o1.getSubject().compareTo(o2.getSubject());
            }
        }
        /*
        1. TreeMap Implements Navigable Map
        2. Used Red Black Tree internally, resulting in O(log n) Tc in all cases
        3. No Null values as key is supported
        4. Can pass custom comparator in Constructor to define custom sorting logic
        5. TreeMap is not synchronized  , have to use Collections.synchronizedMap(new TreeMap<>()) for synchronization
         */
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 1);
        map.put("Orange", 2); // here key is String , it has implemented Comparable in it , hence sorting is happened as lexicographical ordering
        map.put("Grape",3);
        System.out.println(map); // {Apple=1, Grape=3, Orange=2}

        TreeMap<Integer, String> map2 = new TreeMap<>();
        map2.put(1, "Apple");
        map2.put( 2,"Orange"); // here key is Integer , it has implemented Comparable in it , hence sorting is happened as natural ordering
        map2.put(3, "Grape");
        System.out.println(map2); // {1=Apple, 2=Orange, 3=Grape}

        // Here Student class implementing the Comparable interface
        TreeMap<Student, Integer> studentMarks = new TreeMap<>(); // for Custom Object , in custom Object class itself it must implement the Comparable or Comparator Object must be passed
        studentMarks.put(new Student("Krishna", 1, "Math"), 100);
        studentMarks.put(new Student("Radhe", 2, "CS"), 101);

        System.out.println(studentMarks);


        // Custom Comparator for Sorting lexicographic order of subject
        studentMarks = new TreeMap<>(new SubjectComparator());

        System.out.println("Sort By Subject Name----------");
        studentMarks.put(new Student("Krishna", 1, "Math"), 100);
        studentMarks.put(new Student("Radhe", 2, "CS"), 101);
        System.out.println(studentMarks); // {Student{Id=2, name='Radhe', subject='CS'}=101, Student{Id=1, name='Krishna', subject='Math'}=100}


        // If we say both Subject name as CS then result of comparator will be 0 , which says keys are equal hence it will replace the
        // Value and don't insert new entry in map
        System.out.println("When subject names are same then result of o1.getSubject().compareTo(this.getSubject())will be 0 result in Updating the existing key");
        studentMarks = new TreeMap<>(new SubjectComparator());
        studentMarks.put(new Student("Krishna", 1, "CS"), 100);
        studentMarks.put(new Student("Radhe", 2, "CS"), 101);
        System.out.println(studentMarks); // {Student{Id=1, name='Krishna', subject='CS'}=101}

        // In order to make Comparator work efficiently use comparator chaining
        Comparator<Student> comparator = Comparator.comparing(Student::getSubject)
                                                    .thenComparing(Student::getName)
                                                    .thenComparing(Student:: getId);

        TreeMap<Student, Integer> stundentSortBY_sub_name_Id =  new TreeMap<>(comparator);
        Map<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(new Student("A",1,"Science"),1);
        studentMap.put(new Student("AA",2,"Math"),1);
        studentMap.put(new Student("ABA",3,"Science"),1);
        studentMap.put(new Student("BA",4,"CS"),1);
        studentMap.put(new Student("BA",5,"CS"),1);
        stundentSortBY_sub_name_Id.putAll(studentMap);
        System.out.println(stundentSortBY_sub_name_Id);






    }
}
