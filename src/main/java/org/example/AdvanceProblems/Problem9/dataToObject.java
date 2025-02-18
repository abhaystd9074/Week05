package org.example.AdvanceProblems.Problem9;
import java.io.*;
import java.util.*;

public class dataToObject {
    public static void main(String[] args) {
        String path = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem8\\studentdata.csv";
        List<Student> students = new ArrayList<>();

        // Reading and converting CSV data to Student objects
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            boolean firstLine = true; // To skip the header row
            while ((s = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header
                } else {
                    String[] col = s.split(",");
                    String id = col[0];
                    String name = col[1];
                    String department = col[2];
                    int salary = Integer.parseInt(col[3].trim()); // Convert salary to int

                    // Create a Student object and add to the list
                    Student student = new Student(id, name, department, salary);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Printing the List of Students by calling the print method of each Student
        System.out.println("List of Students:");
        for (Student student : students) {
            student.printStudentDetails(); // Printing student details
        }
    }
}

