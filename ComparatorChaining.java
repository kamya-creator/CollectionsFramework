package org.example;

import java.util.*;

class Employee {
    String name;
    String jobTitle;
    int age;
    int salary;

    public Employee(String name, String jobTitle, int age, int salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }


}
class EmployeeChainedComparator implements Comparator<Employee>
{
    List<Comparator<Employee>> listComparator;

    @SafeVarargs
    public EmployeeChainedComparator(Comparator<Employee> ... comparators)
    {
        listComparator = Arrays.asList(comparators);
    }
    @Override
    public int compare(Employee o1, Employee o2) {

        for (Comparator<Employee> comparator : listComparator)
        {
            int result = comparator.compare(o1,o2);
            if(result < 0)
            {
                return -1;
            }
            else if(result > 0){
                return 1;
            }

        }
        return 0;
    }
}
class JobTitleComparator implements Comparator<Employee>
{
    @Override
    public int compare(Employee o1, Employee o2)
    {
        if((o1.getJobTitle().compareTo(o2.getJobTitle()) > 0 )) return 1;
        else return -1;
    }
}
class AgeComparator implements Comparator<Employee>
{
    @Override
    public int compare(Employee o1, Employee o2)
    {
       if((o1.getAge() - o2.getAge()) > 0 ) return 1;
       else return -1;
    }
}
class NameComparator implements Comparator<Employee>
{
    @Override
    public int compare(Employee o1, Employee o2)
    {
        System.out.println("J".compareTo("A"));
      if(o1.getName().compareTo(o2.getName()) > 0) return -1;
      else return 1;

    }
}
class SalaryComparator implements Comparator<Employee>
{
    @Override
    public int compare(Employee o1, Employee o2)
    {
        if((o1.getSalary() - o2.getSalary())> 0) return -1;
        else if((o1.getSalary() - o2.getSalary()) < 0) return 1;
        else return  0;
    }
}
public class ComparatorChaining {
    public static void main(String[] args) {

        Comparator<Employee> employeeComparator =
                Comparator.comparing(Employee::getJobTitle)
                .thenComparing(Employee::getName)
                .thenComparing(Employee::getAge)
                .thenComparing(Employee::getSalary);

        List<Employee> list = new ArrayList<>();
        // here job title is same , then sorting will happen according to next comparator i.e name
        list.add(new Employee("Jon","Developer",45, 80000));
        list.add(new Employee("Sam","Designer",30,75000));
        list.add(new Employee("Aam", "Designer", 45, 13450));

        System.out.println("Sorting Based on Job Title Comparator-------------");
        for (Employee e : list) {
            System.out.println(e);
        }

        // Chaining works sequentially, if one comparator return 0 then only it will go to next comparator
        Collections.sort(list, new EmployeeChainedComparator(
                new JobTitleComparator(),
                new NameComparator(),
                new AgeComparator(),
                new SalaryComparator()
                ));

        list.clear();
        list.add(new Employee("Jon","Designer",45, 80000));
        list.add(new Employee("Sam","Designer",30,75000));
        list.add(new Employee("Aam", "Designer", 45, 13450));

        System.out.println("Sorting Based on Name Comparator--------------");
        Collections.sort(list, new EmployeeChainedComparator(
                new JobTitleComparator(),
                new NameComparator(),
                new AgeComparator(),
                new SalaryComparator()
        ));
        for (Employee e : list) {
            System.out.println(e);
        }


        // here job tilte and name all are same, then sorting will happen as per age Comparator

        list.clear();
        list.add(new Employee("Aam","Designer",40, 80000));
        list.add(new Employee("Aam","Designer",30,75000));
        list.add(new Employee("Aam", "Designer", 45, 13450));
        System.out.println("Sorting Based on Age Comparator--------------");
        Collections.sort(list, new EmployeeChainedComparator(
                new JobTitleComparator(),
                new NameComparator(),
                new AgeComparator(),
                new SalaryComparator()
        ));
        for (Employee e : list) {
            System.out.println(e);
        }


        // here job title ,name and age all are same, then sorting will happen as per Salary Comparator

        list.clear();
        list.add(new Employee("Aam","Designer",45, 80000));
        list.add(new Employee("Aam","Designer",45,75000));
        list.add(new Employee("Aam", "Designer", 45, 13450));
        System.out.println("Sorting based on Salary Comparator--------------");
        Collections.sort(list, new EmployeeChainedComparator(
                new JobTitleComparator(),
                new NameComparator(),
                new AgeComparator(),
                new SalaryComparator()
        ));
        for (Employee e : list) {
            System.out.println(e);
        }


        System.out.println("Concise code with Comparator.comparing and thenComparaing-------------");
        list.sort(employeeComparator);
        for (Employee e : list) {
            System.out.println(e);
        }
    }
}
