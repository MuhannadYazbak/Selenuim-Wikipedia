package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void searchAndCount(String input, String toCount) {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        WebElement inputSearch = driver.findElement(By.id("searchInput"));
        inputSearch.sendKeys(input);
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='search-container']//button"));
        searchButton.click();
        List<WebElement> results = driver.findElementsByXPath("//*[text()='"+toCount+"']");
        System.out.println("There are " + results.size() +" "+toCount+"s" );
        driver.close();
    }

    public static void main(String[] args) {

    searchAndCount("Aardvark", "bear");
    }
}