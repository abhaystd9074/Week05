package org.example.AdvanceProblems.Problem13;

import java.io.*;

public class databaseToCsv {
    public static void main(String[] args) {
        String inputPath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem13\\normaltext.txt";
        String outputPath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem13\\ans.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            bw.write("Employee ID,Name,Department,Salary\n");
            String s;
            while ((s = br.readLine()) != null) {
                bw.write(s.replace(" ", ",") + "\n");
            }

            System.out.println("CSV file generated successfully: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

