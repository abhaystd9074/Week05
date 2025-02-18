package org.example.AdvanceProblems.Problem15;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class EncryptDecryptCSV {
    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    private static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }

    public static void writeEncryptedCSV(String path) {
        List<String[]> employees = new ArrayList<>();
        employees.add(new String[]{"ID", "Name", "Department", "Salary", "Email"});
        employees.add(new String[]{"101", "John Doe", "Finance", "50000", "john@example.com"});
        employees.add(new String[]{"102", "Alice Smith", "IT", "65000", "alice@example.com"});
        employees.add(new String[]{"103", "Bob Brown", "HR", "60000", "bob@example.com"});

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String[] emp : employees) {
                if (!emp[0].equals("ID")) {
                    emp[3] = encrypt(emp[3]); // Encrypt Salary
                    emp[4] = encrypt(emp[4]); // Encrypt Email
                }
                bw.write(String.join(",", emp));
                bw.newLine();
            }
            System.out.println("Encrypted CSV file written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readDecryptedCSV(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] emp = line.split(",");
                if (!emp[0].equals("ID")) {
                    emp[3] = decrypt(emp[3]); // Decrypt Salary
                    emp[4] = decrypt(emp[4]); // Decrypt Email
                }
                System.out.println(String.join(", ", emp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\AdvanceProblems\\Problem15\\encry.csv";
        writeEncryptedCSV(filePath);
        System.out.println("\nDecrypted Data:");
        readDecryptedCSV(filePath);
    }
}
