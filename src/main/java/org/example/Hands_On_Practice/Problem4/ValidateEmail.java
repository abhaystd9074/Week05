package org.example.Hands_On_Practice.Problem4;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileInputStream;

public class ValidateJsonSchema {
    public static <JSONObject> void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON schema
            FileInputStream schemaStream = new FileInputStream("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\Hands_On_Practice\\Problem4\\Schema.json");
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(rawSchema);
             String path="D:\\Week05\\Day02\\src\\main\\java\\org\\example\\Hands_On_Practice\\Problem4\\jsondata.json";
            // Load JSON data
            FileInputStream jsonStream = new FileInputStream(path);
            JSONObject jsonData = new JSONObject(new JSONTokener(jsonStream));

            // Validate JSON against schema
            schema.validate(jsonData);

            System.out.println("Valid JSON: Email format is correct!");
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
