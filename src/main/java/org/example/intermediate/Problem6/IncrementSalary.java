package org.example.intermediate.Problem6;

import java.io.*;
import java.util.ArrayList;

public class IncrementSalary {
    public static void main(String[] args) {
        String path = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\intermediate\\Problem6\\empdat2.csv";
        ArrayList<String> updatedLines = new ArrayList<>();

        // Reading and modifying the file content
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s; int count=0;
            while ((s = br.readLine()) != null) {
                if (count > 0) {
                    String[] col = s.split(",");
                    int salary = Integer.parseInt(col[3].trim());
                    col[3] = String.valueOf(salary + 86); // Increment salary by 1000
                    updatedLines.add(String.join(",", col)); // Add updated row
                }
                else{
                    updatedLines.add(s); count++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Writing updated content back to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String it : updatedLines) {
                bw.write(it);
                bw.newLine();
            }
            System.out.println("Salary incremented successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
