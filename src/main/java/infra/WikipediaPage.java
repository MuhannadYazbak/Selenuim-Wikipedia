package infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WikipediaPage {
    private ChromeDriver driver;

    public WikipediaPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.wikipedia.org/");
    }

    public void search(String input) {
        WebElement inputSearch = driver.findElement(By.id("searchInput"));
        inputSearch.sendKeys(input);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='search-container']//button"));
        searchButton.click();
    }

    public int getCount(String toCount) {
        List<WebElement> results = driver.findElementsByXPath("//*[text()='" + toCount + "']");
        return results.size();
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
