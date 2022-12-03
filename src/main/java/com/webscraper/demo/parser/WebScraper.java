package com.webscraper.demo.parser;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebScraper {


    public static JSONObject scraper(String domen){
        try{
            Pattern pattern_checker = Pattern.compile(".+\\..+");
            Matcher matcher_checker = pattern_checker.matcher(domen);
            if(!matcher_checker.find()){
                JSONObject parsed3 = new JSONObject();
                parsed3.put("name", "Invalid domen");
                parsed3.put("twitter", "Invalid domen");
                parsed3.put("facebook", "Invalid domen");
                parsed3.put("logo", "Invalid domen");
                parsed3.put("icon", "Invalid domen");
                parsed3.put("employees", "Invalid domen");
                parsed3.put("address", "Invalid domen");
                return parsed3;
            }
       String url = "https://" + domen;





        String mydata = url;
        String name_company = null;

        Pattern pattern = Pattern.compile("/(.*?)\\.(.*?)");
        Matcher matcher = pattern.matcher(mydata);
        if (matcher.find()) {
            name_company = matcher.group(1);
//            System.out.println(name_company);
        }
        JSONObject result = ParseDataBase.DataBaseParser(url);

        if(result != null){
            return result;
        }

        Document doc = Jsoup.connect(url).get();
        String name = Parser.ParseTitle(doc);





        String twitter = Parser.ParseTwitter(doc);
        String facebook = Parser.ParseFacebook(doc);
        String logo = Parser.ParseLogo(doc);
        String icon = Parser.ParseFavicon(doc);

        JSONObject parsed = new JSONObject();
        parsed.put("name", name);
        parsed.put("twitter", twitter);
        parsed.put("facebook", facebook);
        parsed.put("logo", logo);
        parsed.put("icon", icon);
        String employees = "Not Found";
        String address = "Not Found.";

        String url_wiki = FindWiki.FindWikiArticle(name, name_company);

        if (url_wiki != "Not Found") {
            Document wiki = Jsoup.connect(url_wiki).get();
            employees = Parser.ParseEmloyees(wiki);
            address = Parser.ParseLocation(wiki);
        }
        if(employees == "Not Found"){
            String employees_pdl = Integer.toString(PDLReader.GetEmployees(domen));
            if(employees_pdl.equals("-1")){
                employees = "Not found";
            }else{
                employees = employees_pdl;

            }
        }
        if(employees.equals("-1")){employees = "Not Found";}
        if(address == "Not Found."){
            String address_pdl = PDLReader.GetAddress(domen);
            if(address_pdl != "Not Found"){address = address_pdl;}
        }
        parsed.put("employees", employees);
        parsed.put("address", address);
//        String parsedStr = parsed.toString(4);
//        System.out.println(parsedStr);
        WriteDataBase.Write_database(url, name, twitter, facebook, logo, icon, employees, address);


        return parsed;
    }catch (IOException e){
            JSONObject parsed2 = new JSONObject();
            parsed2.put("name", "Not found");
            parsed2.put("twitter", "Not found");
            parsed2.put("facebook", "Not found");
            parsed2.put("logo", "Not found");
            parsed2.put("icon", "Not found");
            parsed2.put("employees", "Not found");
            parsed2.put("address", "Not found");
            return parsed2;
        }

    }

}