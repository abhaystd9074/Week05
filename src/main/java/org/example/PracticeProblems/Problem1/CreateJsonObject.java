package org.example.PracticeProblems.Problem1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreateJsonObject {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode student1 = objectMapper.createObjectNode();
            student1.put("name", "Abhay");
            student1.put("age", 22);
            ArrayNode subjects1 = objectMapper.createArrayNode();
            subjects1.add("Mathematics");
            subjects1.add("Physics");
            subjects1.add("Computer Science");
            student1.set("subjects", subjects1);

            ObjectNode student2 = objectMapper.createObjectNode();
            student2.put("name", "Rahul");
            student2.put("age", 23);
            ArrayNode subjects2 = objectMapper.createArrayNode();
            subjects2.add("English");
                    subjects2.add("History");
                    subjects2.add("Biology");
            student2.set("subjects", subjects2);

            ArrayNode studentsArray = objectMapper.createArrayNode();
            studentsArray.add(student1);
            studentsArray.add(student2);

            System.out.println(studentsArray.toPrettyString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
