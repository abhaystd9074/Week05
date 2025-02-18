package org.example.AdvanceProblems.Problem14;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {
    public static void main(String[] args) {
        String jsonPath = "D:\\Week05\\Day01\\students.json";
        String csvPath = "D:\\Week05\\Day01\\students.csv";
        String outputJsonPath = "D:\\Week05\\Day01\\students_output.json";

        jsonToCsv(jsonPath, csvPath);
        csvToJson(csvPath, outputJsonPath);
    }

    public static void jsonToCsv(String jsonPath, String csvPath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode students = (ArrayNode) mapper.readTree(new File(jsonPath));

            BufferedWriter bw = new BufferedWriter(new FileWriter(csvPath));
            bw.write("ID,Name,Age,Grade\n");

            for (JsonNode student : students) {
                bw.write(student.get("ID").asText() + "," +
                        student.get("Name").asText() + "," +
                        student.get("Age").asText() + "," +
                        student.get("Grade").asText() + "\n");
            }

            bw.close();
            System.out.println("JSON converted to CSV successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void csvToJson(String csvPath, String jsonPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode students = mapper.createArrayNode();
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                ObjectNode student = mapper.createObjectNode();
                student.put("ID", parts[0]);
                student.put("Name", parts[1]);
                student.put("Age", parts[2]);
                student.put("Grade", parts[3]);
                students.add(student);
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonPath), students);
            System.out.println("CSV converted to JSON successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

