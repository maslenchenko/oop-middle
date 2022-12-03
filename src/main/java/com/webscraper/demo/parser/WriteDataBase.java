package com.webscraper.demo.parser;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteDataBase {
    public static void Write_database(String url, String name, String twitter, String facebook, String logo, String icon, String employees, String   address){
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter("src/main/resources/database.csv", true);

            // create CSVWriter with ';' as separator
            CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);


            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[] {name, twitter, facebook, logo, icon, employees, address, url});
            writer.writeAll(data);

            // closing writer connection
            writer.close();
//            System.out.println("Added to database");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
