package org.example.PracticeProblems.Problem5;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Validate {
    public static void main(String[] args) {
        try {
            String path="D:\\Week05\\Day02\\src\\main\\java\\org\\example\\PracticeProblems\\Problem5\\data2.json";
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(path));

            if (rootNode.isObject()) { // Check if it's a valid JSON object
                if (rootNode.has("name") && rootNode.has("email")) { // Validate required fields
                    System.out.println("Valid JSON structure.");
                } else {
                    System.out.println("Invalid JSON: Missing required fields.");
                }
            } else {
                System.out.println("Invalid JSON: Not an object.");
            }
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}

