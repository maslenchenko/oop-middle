package com.example.demo.idSmuggler.parser;

import org.jsoup.Jsoup;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.Element;

public class Parser {
    String html = "<html><head><title>First parse</title></head>"
            + "<body><p>Parsed HTML into a doc.</p></body></html>";
    Document doc = (Document) Jsoup.parse(html);
}
