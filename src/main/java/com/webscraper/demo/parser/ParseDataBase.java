package com.webscraper.demo.parser;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.json.JSONObject;

import java.io.FileReader;

public class ParseDataBase {
    public static JSONObject DataBaseParser(String name){
        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader("src/main/resources/database.csv");

            // create csvReader object passing
            // file reader as a parameter
            CSVParser parser_csv = new CSVParserBuilder().withSeparator(';').build();
            CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser_csv).build();
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                if(nextRecord[7].equals(name)){
                    JSONObject parsed_from_database = new JSONObject();
                    parsed_from_database.put("name", nextRecord[0]);
                    parsed_from_database.put("twitter", nextRecord[1]);
                    parsed_from_database.put("facebook", nextRecord[2]);
                    parsed_from_database.put("logo", nextRecord[3]);
                    parsed_from_database.put("icon", nextRecord[4]);
                    parsed_from_database.put("employees", nextRecord[5]);
                    parsed_from_database.put("address", nextRecord[6]);
//                    String parsed_from_database_str = parsed_from_database.toString(4);

                    return parsed_from_database;

                }


            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
