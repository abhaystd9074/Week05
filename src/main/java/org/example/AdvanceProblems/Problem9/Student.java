package org.example.AdvanceProblems.Problem9;
public class Student {

    String id;
    String name;
    String department;
    int salary;


    public Student(String id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    public void printStudentDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}
