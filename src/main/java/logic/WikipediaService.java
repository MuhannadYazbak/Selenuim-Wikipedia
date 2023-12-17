package logic;


import infra.WikipediaPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaService {
    private WikipediaPage wikipediaPage;

    public WikipediaService(String chromedriverPath) {
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        this.wikipediaPage = new WikipediaPage(new ChromeDriver());
    }

    public void searchAndCount(String input, String toCount) {
        wikipediaPage.open();
        wikipediaPage.search(input);
        wikipediaPage.clickSearchButton();
        int count = wikipediaPage.getCount(toCount);
        System.out.println("There are " + count + " " + toCount + "s");
        closeDriver();
    }

    private void closeDriver() {
        if (wikipediaPage != null) {
            wikipediaPage.closeDriver();
        }
    }
}
