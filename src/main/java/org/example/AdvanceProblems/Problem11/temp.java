package org.example.AdvanceProblems.Problem11;
import java.io.*;
import java.util.Random;

public class temp {
    public static void main(String[] args) {
        String path = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem11\\largefile.csv";
        long targetSize = 10L * 1024 * 1024;
        String header = "ID,Name,Age,Salary,Department\n";
        String[] names = {"Abhay", "Rahul", "Sneha", "Arjun", "Priya", "Amit", "Neha", "Vikas", "Pooja", "Karan"};
        String[] departments = {"HR", "Finance", "IT", "Sales", "Marketing", "Operations"};

        Random rand = new Random();
        long fileSize = 0;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(header);
            fileSize += header.length();

            while (fileSize < targetSize) {
                int id = rand.nextInt(100000) + 1;
                String name = names[rand.nextInt(names.length)];
                int age = rand.nextInt(18, 60);
                int salary = rand.nextInt(30000, 120000);
                String department = departments[rand.nextInt(departments.length)];

                String row = id + "," + name + "," + age + "," + salary + "," + department + "\n";
                bw.write(row);
                fileSize += row.length();

                if (fileSize % (50 * 1024 * 1024) < row.length()) {
                    System.out.println("Generated: " + (fileSize / (1024 * 1024)) + " MB");
                }
            }

            System.out.println("CSV file generated successfully: " + path);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

