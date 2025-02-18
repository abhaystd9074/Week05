package org.example.intermediate.Problem7;

import java.io.*;
import java.util.*;

public class SortRecords {
    public static void main(String[] args) {
        String path = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\intermediate\\Problem7\\empdat3.csv";
        List<String[]> records = new ArrayList<>();
        String header = "";

        // Reading the file content
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            boolean firstLine = true;
            while ((s = br.readLine()) != null) {
                if (firstLine) {
                    header = s;
                    firstLine = false;
                } else {
                    String[] col = s.split(",");
                    records.add(col);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        records.sort((a, b) -> Integer.compare(Integer.parseInt(b[3].trim()), Integer.parseInt(a[3].trim())));

        System.out.println("Top 5 Highest-Paid Employees:");
        int limit = Math.min(5, records.size());
        for (int i = 0; i < limit; i++) {
            String[] record = records.get(i);
            System.out.println("ID: " + record[0] + ", Name: " + record[1] + ", Department: " + record[2] + ", Salary: " + record[3]);
        }
    }
}
