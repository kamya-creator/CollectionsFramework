package org.example;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Equals Default method of Object just compare the address of Object nothing much
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }


    // Custom equals method for Object in order to compare objects data members correctly
    @Override
    public boolean equals(Object o) {
        if( this == o) return true;
        if(o == null) return false;
        if(!(o instanceof Person)) return false;
        Person p = (Person) o;
        if(p.age == this.age)
        {
            // Use Objects utility for comparing , as it handles null object compares as well
            return Objects.equals(p.name, this.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // IntelliJ Produced these equals and hashCode methods
//    @Override
//    public boolean equals(Object o) {
//        System.out.println(o);
//        if (!(o instanceof Person)) return false;
//        Person person = (Person) o;
//        return age == person.age && Objects.equals(name, person.name);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class PersonHashMap {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Person p1 = new Person("Alice", 20);
        Person p2 = new Person("Jhon", 27);
        Person p3 = new Person("Krishna", 25);
        Person p4 = new Person(null, 20);

        System.out.println(p1.equals(p4)); // handle equals methods otherwise output will not be correct
        HashMap<Person, String> map = new HashMap<>();
        map.put(p1,"Engineer");
        map.put(p2,"Developer");
        map.put(p3, "UI/UX");
        map.put(p4,"Manager");

        map.forEach((key,value)-> System.out.println(key +  ":" + value));

        // HashMap default initial capacity is 16 size array
        // HashMap default loadFactor is 0.75f ,
        // after every insert loadFactor is calculated , if calculated loadfactor  exceeds default or provided loadfactor
        // then array bucket will be increased, all rehashing will be calculated and then stored in arrayBucket
        HashMap<Integer,String> map2 = new HashMap<>(2,1);
        System.out.println(map2.size()); // 0

        map2.put(1,"One");
        map2.put(2,"One");
        System.out.println(map2.size());
        map2.put(3,"One");
        map2.put(4,"One");
        map2.put(5,"One");
        map2.put(6,"One");
        map2.put(7,"One");
        System.out.println(map2.size());

        Class<HashMap> hashMapClass = HashMap.class;
        Field table = hashMapClass.getDeclaredField("table");
        table.setAccessible(true);
        Object[] o = (Object[])table.get(map2);
        // Capacity is depending on loadfactor and initialCapacity
        // If initialCapacity got used completely then as per loadFactor arrayBucket size will be doubled
        System.out.println("HashMap Capacity--------");
        System.out.println(o.length);  // This is the capacity of the HashMap (i.e., number of buckets)


    }
}
