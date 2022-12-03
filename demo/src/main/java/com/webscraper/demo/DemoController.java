package com.webscraper.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String getURL(Model model) {
        model.addAttribute("info", new Info());
        return "info";
    }

    @PostMapping("/info")
    public String postURL(@ModelAttribute Info info, Model model) {
        model.addAttribute("info", info);
        return "result";
    }

}