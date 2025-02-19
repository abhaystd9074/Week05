package org.example.Hands_On_Practice.Problem5;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class MergeJsonData {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON files
            JsonNode json1 = objectMapper.readTree(new File("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\Hands_On_Practice\\Problem5\\data1.json"));
            JsonNode json2 = objectMapper.readTree(new File("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\Hands_On_Practice\\Problem5\\data2.json"));

            // Merge JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            // Print merged JSON
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
