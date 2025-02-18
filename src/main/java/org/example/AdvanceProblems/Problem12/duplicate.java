package org.example.AdvanceProblems.Problem12;
import java.io.*;
import java.util.*;

public class duplicate {
    public static void main(String[] args) {
        String path = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem12\\datafile.csv";
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            br.readLine();
            while ((s = br.readLine()) != null) {
                String[] col = s.split(",");
                String id = col[0].trim();

                if (!uniqueIds.add(id)) {
                    duplicates.add(s);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records found:");
                for (String dup : duplicates) {
                    System.out.println(dup);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

