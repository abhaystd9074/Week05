package org.example.PracticeProblems.Problem3;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class SpecificFields {
    public static void main(String[] args) {
        try {
            String path="D:\\Week05\\Day02\\src\\main\\java\\org\\example\\PracticeProblems\\Problem3\\data.json";
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(path));

            if (rootNode.isArray()) { // Ensure it's an array
                for (JsonNode node : rootNode) {
                    JsonNode nameNode = node.get("name");
                    JsonNode emailNode = node.get("email");

                    String name = (nameNode != null) ? nameNode.asText() : "N/A";
                    String email = (emailNode != null) ? emailNode.asText() : "N/A";

                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);

                }
            } else {
                System.out.println("JSON is not an array!");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
