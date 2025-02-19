package org.example.PracticeProblems.Problem2;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class ConvertObjToJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<Car> cars = new ArrayList<>();
            cars.add(new Car("Toyota", "Camry", 2023));
            cars.add(new Car("Tata", "Avinya", 2025));

            String jsonString = objectMapper.writeValueAsString(cars);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
