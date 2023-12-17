package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchAndCountTest {

    private ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSearchAndCount() {
        // Arrange
        String input = "Aardvark";
        String toCount = "Aardvark";

        // Act
        searchAndCount(input, toCount);

        // Assert
        List<WebElement> results = driver.findElementsByXPath("//*[text()='" + toCount + "']");
        int actualCount = results.size();
        int expectedCount = 18;

        assertEquals(expectedCount, actualCount, "The count of elements did not match the expected count.");
    }

    private void searchAndCount(String input, String toCount) {
        WebElement inputSearch = driver.findElement(By.id("searchInput"));
        inputSearch.sendKeys(input);
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='search-container']//button"));
        searchButton.click();
        List<WebElement> results = driver.findElementsByXPath("//*[text()='" + toCount + "']");
        System.out.println("There are " + results.size() + " " + toCount + "s");
    }
}
