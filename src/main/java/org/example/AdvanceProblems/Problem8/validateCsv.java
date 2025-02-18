package org.example.AdvanceProblems.Problem8;
import java.io.*;
import java.util.regex.Pattern;

public class validateCsv {
    public static void main(String[] args) {
        String path = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem8\\empdata4.csv";


        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            boolean firstLine = true;
            while ((s = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    System.out.println("Header: " + s);
                    continue;
                }

                String[] col = s.split(",");
                if (col.length < 6) {
                    System.out.println("Skipping invalid row (insufficient columns): " + s);
                    continue;
                }

                String email = col[2].trim();
                String phone = col[3].trim();


                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid email: " + s);
                    continue;
                }
                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid phone number: " + s);
                    continue;
                }


                System.out.println("Valid: " + s);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
