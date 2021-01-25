package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends AbstrPage {

    private String xpathFirstPart = "//div[@class='gsc-thumbnail-inside']/div[@class='gs-title']/a/b[text()='";
    private String xpathSecondPart = "']";

    private String valueURL = "value";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CalcHomePage goToResult(String search){

        WebElement searchResult = waitWebElementClickable(xpathFirstPart+search+xpathSecondPart);
        hightlightElement(searchResult);
        searchResult.click();

        return new CalcHomePage(driver);

    }

    @Override
    protected SearchResultPage openPage() {
        throw new RuntimeException();
    }
}
