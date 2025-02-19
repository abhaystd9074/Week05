package org.example.Hands_On_Practice.Problems2;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

class Student {
    public String name;
    public int age;
    public List<String> subjects;

    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}

public class ConvertJasonToObj {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<Student> students = new ArrayList<>();
            students.add(new Student("Abhay", 22, List.of("Math", "Physics")));
            students.add(new Student("Rahul", 23, List.of("English", "History")));
            students.add(new Student("Sneha", 21, List.of("Biology", "Chemistry")));

            String jsonArray = objectMapper.writeValueAsString(students);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
