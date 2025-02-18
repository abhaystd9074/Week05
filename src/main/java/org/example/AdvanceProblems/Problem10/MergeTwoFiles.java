package org.example.AdvanceProblems.Problem10;
import java.io.*;
import java.util.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String file1 = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem10\\student1.csv";
        String file2 = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem10\\student2.csv";
        String outputFile = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem10\\outputdata.csv";

        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String s;
            br.readLine();
            while ((s = br.readLine()) != null) {
                String[] col = s.split(",");
                studentData.put(col[0], new String[]{col[1], col[2]});
            }
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String s;
            br.readLine();
            while ((s = br.readLine()) != null) {
                String[] col = s.split(",");
                if (studentData.containsKey(col[0])) {
                    String[] details = studentData.get(col[0]);
                    studentData.put(col[0], new String[]{details[0], details[1], col[1], col[2]});
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();
            for (Map.Entry<String, String[]> entry : studentData.entrySet()) {
                bw.write(entry.getKey() + "," + String.join(",", entry.getValue()));
                bw.newLine();
            }
            System.out.println("Merged file created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
