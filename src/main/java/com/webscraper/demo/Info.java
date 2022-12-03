package com.webscraper.demo;


import com.webscraper.demo.parser.WebScraper;
import org.json.JSONObject;

import java.io.EOFException;
import java.io.IOException;

public class Info {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String name_ = "Not found";
    private String facebook_ = "Notfound";
    private String twitter_ = "Not found";
    private String logo_ = "Not found";
    private String icon_ = "Not found";
    private String employees_ = "Not found";
    private String address_ = "Not found";

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getFacebook_() {
        return facebook_;
    }

    public void setFacebook_(String facebook_) {
        this.facebook_ = facebook_;
    }

    public String getTwitter_() {
        return twitter_;
    }

    public void setTwitter_(String twitter_) {
        this.twitter_ = twitter_;
    }

    public String getLogo_() {
        return logo_;
    }

    public void setLogo_(String logo_) {
        this.logo_ = logo_;
    }

    public String getIcon_() {
        return icon_;
    }

    public void setIcon_(String icon_) {
        this.icon_ = icon_;
    }

    public String getEmployees_() {
        return employees_;
    }

    public void setEmployees_(String employees_) {
        this.employees_ = employees_;
    }

    public String getAddress_() {
        return address_;
    }

    public void setAddress_(String address_) {
        this.address_ = address_;
    }


    public Info find(String url) {
        JSONObject result = WebScraper.scraper(this.url);
        this.name_ = result.getString("name");
        this.facebook_ = result.getString("facebook");
        this.twitter_ = result.getString("twitter");
        this.logo_ = result.getString("logo");
        this.icon_ = result.getString("icon");
        this.employees_ = result.getString("employees");
        this.address_ = result.getString("address");


        return this;

    }
}
