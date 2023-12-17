package org.example;

import logic.WikipediaService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String chromedriverPath = "chromedriver.exe";
        WikipediaService wikipediaService = new WikipediaService(chromedriverPath);
        wikipediaService.searchAndCount("Aardvark", "bear");
    }
}