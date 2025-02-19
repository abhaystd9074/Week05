package org.example.Hands_On_Practice.Problem3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;


public class FilterData {
    public static void main(String[] args) {
        try {
            String s="D:\\Week05\\Day02\\src\\main\\java\\org\\example\\Hands_On_Practice\\Problem3\\FilterData.java";
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(s));

            for (JsonNode node : rootNode) {
                int age = node.get("age").asInt();
                if (age > 25) {
                    System.out.println("Name: " + node.get("name").asText());
                    System.out.println("Email: " + node.get("email").asText());
                    System.out.println("Age: " + age);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

