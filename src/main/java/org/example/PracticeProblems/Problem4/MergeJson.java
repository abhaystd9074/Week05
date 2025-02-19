package org.example.PracticeProblems.Problem4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode json1 = objectMapper.createObjectNode();
            json1.put("name", "Abhay");
            json1.put("age", 22);
            json1.put("city", "Mumbai");

            ObjectNode json2 = objectMapper.createObjectNode();
            json2.put("email", "abhay@example.com");
            json2.put("phone", "9876543210");

            json1.setAll(json2); // Merging json2 into json1

            System.out.println(json1.toPrettyString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

