package org.example.Hands_On_Practice.Problem1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;


public class PrintKeyValue {
    public static void main(String[] args) {
        File file=new File("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\Hands_On_Practice\\Problem1\\datafir.json");
        ObjectMapper objectMapper=new ObjectMapper();
        //Try block
        try {
            JsonNode jsonNode =objectMapper.readTree(file);
            System.out.println(jsonNode);
        }
        //Catch block
        catch (Exception e) {
            System.out.println("Exception occured");
        }
    }
}
