package org.example.Hands_On_Practice.Problem7;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static <CsvMapper, CsvSchema> void main(String[] args) {
        try {
            // Initialize CsvMapper
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader(); // Read CSV headers

            // Read CSV file
            File csvFile = new File("data.csv");
            MappingIterator<Map<String, String>> csvIterator =
                    csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvFile);

            // Convert to JSON
            List<Map<String, String>> data = csvIterator.readAll();
            ObjectMapper jsonMapper = new ObjectMapper();
            String jsonOutput = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

            // Print JSON
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
