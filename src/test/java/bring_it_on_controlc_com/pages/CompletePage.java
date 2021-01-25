package bring_it_on_controlc_com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompletePage extends AbstrPage {

    @FindBy(xpath = "//*[@class='input-copy']/form/input")
    private WebElement outURL;

    private String valueURL = "value";

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public ResultPage goToResultPage(){

        hightlightElement(outURL);
        System.out.println("Element checked. URL is " + outURL.getAttribute(valueURL));
        driver.get(outURL.getAttribute(valueURL));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(CustomCondition.jQueryAJAXsCompleted());
        return new ResultPage(driver);

    }

    @Override
    protected AbstrPage openPage() {
        throw new RuntimeException();
    }
}
