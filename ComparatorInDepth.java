package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student
{
    String address;
    String name;
    int age;

    public Student(String address, String name, int age) {
        this.address = address;
        this.name = name;
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class CustomComparator implements Comparator<Student>
{

    @Override
    public int compare(Student o1, Student o2) {

        if(o1.getAddress().compareTo(o2.getAddress()) > 0)
        {
            return -1;
        }
        else if(o1.getAddress().compareTo(o2.getAddress()) < 0)
        {
            return 1;
        }
        else{
            if(o1.getName().compareTo(o2.getName()) > 0)
            {
                return 1;
            }
            else if(o1.getName().compareTo(o2.getName()) < 0)
            {
                return -1;
            }
            else {
                return o1.getAge() - o2.getAge();
            }
        }
    }
}
public class ComparatorInDepth {
    public static void main(String[] args) {

        Student student1 = new Student("South","Alice",20);
        Student student2 = new Student("East","Bob",24);
        Student student3 = new Student("West","Mice",30);
        Student student4 = new Student("North","Govind",19);
        Student student5 = new Student("South-East","Radhe",27);
        Student student6 = new Student("South","Alice",32);

        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);list.add(student2);list.add(student3);list.add(student4);list.add(student5);list.add(student6);
        //list.sort(new CustomComparator());
        list.sort(Comparator.comparing(Student::getAddress).thenComparing(Student::getName).thenComparing(Student::getAge));
        System.out.println(list);
    }
}
