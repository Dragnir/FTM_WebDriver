package hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends AbstrPage {

    private String xpathFirstPart = "//div[@class='gsc-thumbnail-inside']/div[@class='gs-title']/a/b[text()='";
    private String xpathSecondPart = "']";

    private String valueURL = "value";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CalcHomePage goToResult(String search){

        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFirstPart+search+xpathSecondPart)));

        WebElement searchResult = driver.findElement(By.xpath(xpathFirstPart+search+xpathSecondPart));
        hightlightElement(searchResult);
        searchResult.click();

        return new CalcHomePage(driver);

    }

    @Override
    protected CloudHomePage openPage() {
        throw new RuntimeException();
    }
}
