package com.webscraper.demo.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static String ParseTitle(Document page){
        String name = page.title();
        return name;
    }

    public static String ParseTwitter(Document page){
        String twitter_txt = "";
        Elements twitter = page.select("[href*=twitter]");
        for (Element link : twitter) {
            twitter_txt += link.attr("abs:href");
        }
        if(twitter_txt == ""){
            return "Not Found";
        }
        return twitter_txt;
    }

    public static String ParseFacebook(Document page){
        String facebook_txt = "";

        Elements facebook = page.select("[href*=facebook]");
        for (Element link : facebook) {
            facebook_txt += link.attr("abs:href");
            break;
        }
        if(facebook_txt == ""){
            return "Not Found";
        }
        return facebook_txt;
    }

    public static String ParseLogo(Document page){
        Element image = page.select("img[src*=logo]").first();
        if(image == null){
            return "Not Found";
        }
        String imgSrc = image.absUrl("src");
        return imgSrc;
    }

    public static String ParseFavicon(Document page){
        Element favicon = page.head().select("link[href~=.*\\.ico]").first();
        if(favicon == null){
            favicon = page.head().select("link[href*=favicon]").first();
            if(favicon == null){

                return "Not Found";
        }
        }
        String favicon_url = favicon.absUrl("href");
        return favicon_url;
    }
    public static String ParseEmloyees(Document page){
        Element box =   page.select("table.infobox").first();
        if(box == null){return "Not Found";}
        Element employees_title = box.select("th:contains(employees)").first();
        if(employees_title == null){return "Not Found";}
        Element employees_value = employees_title.nextElementSibling();
        if(employees_value == null){return "Not Found";}
        String employees_value_text = employees_value.text();

        if(employees_value_text.isBlank()){
            return "Not found";
        }else {
            Pattern pattern = Pattern.compile("\\d+,?\\.?\\s?\\d*");
            Matcher matcher = pattern.matcher(employees_value_text);
            if (matcher.find()) {
                return matcher.group(0);
            } else {
                return "Not found";
            }
        }
    }
    public static String ParseLocation(Document page){
        Element box =   page.select("table.infobox").first();
        if(box == null){return "Not Found";}
        Element location_title = box.select("th:contains(Headquarters)").first();
        if(location_title == null){return "Not Found";}
        Element location = location_title.nextElementSibling();
        if(location == null){return "Not Found";}
        String location_text = location.text();

        if(location_text.isBlank()){
            return "Not found";
        }else {
            return location_text;
        }
    }

}
