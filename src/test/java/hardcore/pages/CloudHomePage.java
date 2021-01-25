package hardcore.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudHomePage extends AbstrPage {

    private static final String HOMEPAGE_URL="https://cloud.google.com/";

    @FindBy(xpath = "//div[@class='devsite-searchbox']/input")
    private WebElement searchBtn;

    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultPage setSearchText(String searchTest) {

        hightlightElement(searchBtn);
        searchBtn.click();
        searchBtn.sendKeys(searchTest);
        searchBtn.sendKeys(Keys.ENTER);
        log("Text for Search set");
        return new SearchResultPage(driver);
    }

}
