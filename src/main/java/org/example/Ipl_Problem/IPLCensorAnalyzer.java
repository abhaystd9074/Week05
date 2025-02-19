package org.example.Ipl_Problem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;
import java.util.Map;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        try {
            File jsonInputFile = new File("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\Ipl_Problem\\input.json");
            File csvInputFile = new File("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\Ipl_Problem\\csvinput.json");

            File jsonOutputFile = new File("censored_ipl.json");
            File csvOutputFile = new File("censored_ipl.csv");


            List<Map<String, Object>> jsonData = readJson(jsonInputFile);
            jsonData.forEach(IPLCensorAnalyzer::applyCensorship);
            writeJson(jsonOutputFile, jsonData);

            // Process CSV
            List<Map<String, String>> csvData = readCsv(csvInputFile);
            csvData.forEach(IPLCensorAnalyzer::applyCensorship);
            writeCsv(csvOutputFile, csvData);

            System.out.println("✅ Censorship applied. Check output files!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static List<Map<String, Object>> readJson(File file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<>() {});
    }

    // Write JSON file
    private static void writeJson(File file, List<Map<String, Object>> data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
    }


    private static List<Map<String, String>> readCsv(File file) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> it = csvMapper.readerFor(new TypeReference<Map<String, String>>() {})
                .with(schema)
                .readValues(file);
        return it.readAll();
    }


    private static void writeCsv(File file, List<Map<String, String>> data) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.builder()
                .addColumn("match_id")
                .addColumn("team1")
                .addColumn("team2")
                .addColumn("score_team1")
                .addColumn("score_team2")
                .addColumn("winner")
                .addColumn("player_of_match")
                .setUseHeader(true)
                .build();
        csvMapper.writer(schema).writeValue(file, data);
    }


    private static <T> void applyCensorship(Map<String, T> match) {
        match.replaceAll((key, value) -> {
            if (key.equals("team1") || key.equals("team2") || key.equals("winner")) {
                return (T) censorTeam(String.valueOf(value));
            }
            if (key.equals("player_of_match")) {
                return (T) "REDACTED";
            }
            return value;
        });
    }


    private static String censorTeam(String team) {
        String[] words = team.split(" ");
        return words.length > 1 ? words[0] + " ***" : team;
    }
}