package com.webscraper.demo.parser;

import org.apache.tomcat.Jar;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        JSONObject result = WebScraper.scraper("ucu.edu.ua");
        String res = result.toString(4);
        System.out.println(res);
    }
}
