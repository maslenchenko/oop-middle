package com.webscraper.demo.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.imageio.IIOException;
import java.io.IOException;

public class FindWiki {
    public static String FindWikiArticle(String name, String name_company) throws IOException {
        try {
            String url_wiki = "https://en.wikipedia.org/wiki/" + name_company;
            Document wiki = Jsoup.connect(url_wiki).get();
            return url_wiki;

        }catch (Exception e) {
            try {
                name = name.replace(" ", "_");
                String url_wiki = "https://en.wikipedia.org/wiki/" + name;

                Document wiki = Jsoup.connect(url_wiki).get();

                return url_wiki;
            }
            catch (Exception exception){
                return "Not Found";
            }
        }
    }
}

