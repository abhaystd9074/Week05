package org.example.AdvanceProblems.Problem11;
import java.io.*;

public class LargeFile {
    public static void main(String[] args) {
        String path = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\intermediate\\Problem11\\large_data.csv";

        int batchSize = 100;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            br.readLine();
            while ((s = br.readLine()) != null) {
                count++;
                if (count % batchSize == 0) {
                    System.out.println("Processed records: " + count);
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
