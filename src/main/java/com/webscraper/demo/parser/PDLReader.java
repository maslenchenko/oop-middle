package com.webscraper.demo.parser;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PDLReader {

    public static int GetEmployees(String domen) {
        try {
            String API_KEY = "7dd1fcd5bbe12ddaa126cd17a6a1a1754345f2a27b07e3a8796ab34ac06ae951";
            String command = "SELECT NAME FROM COMPANY WHERE WEBSITE='" + domen + "'";
//        String query = URLEncoder.encode("SELECT NAME FROM COMPANY WHERE WEBSITE='ucu.edu.ua'", StandardCharsets.UTF_8);
            String query = URLEncoder.encode(command, StandardCharsets.UTF_8);

            URL url = new URL("https://api.peopledatalabs.com/v5/company/search?sql=" + query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", API_KEY);
            connection.connect();
            String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
            JSONObject jsonObject = new JSONObject(text);
//            System.out.println(jsonObject.toString(4));
            return jsonObject.getJSONArray("data").getJSONObject(0).getInt("employee_count");
        } catch (IOException e) {
            return -1;
        }
    }

    public static String GetAddress(String domen) {
        try {
            String API_KEY = "7dd1fcd5bbe12ddaa126cd17a6a1a1754345f2a27b07e3a8796ab34ac06ae951";
            String command = "SELECT NAME FROM COMPANY WHERE WEBSITE='" + domen + "'";
//        String query = URLEncoder.encode("SELECT NAME FROM COMPANY WHERE WEBSITE='ucu.edu.ua'", StandardCharsets.UTF_8);
            String query = URLEncoder.encode(command, StandardCharsets.UTF_8);

            URL url = new URL("https://api.peopledatalabs.com/v5/company/search?sql=" + query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", API_KEY);
            connection.connect();
            String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
            JSONObject jsonObject = new JSONObject(text);
//            System.out.println(jsonObject.toString(4));
            JSONObject location = jsonObject.getJSONArray("data").getJSONObject(0).getJSONObject("location");
            String location_str = location.getString("name");
            try{
            location_str = location.getString("street_address") + ", " + location.getString("name");
            }catch (Exception exception){}
            return location_str;
        } catch (IOException e) {
            return "Not Found";
        }
    }
}