package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class EstimatedResultsPage extends AbstrPage {

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[7]/div")
    private WebElement totalCost;

    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimate;

    public EstimatedResultsPage(WebDriver driver) {
        super(driver);
    }

    public YourEmailPage goToSetEmail(WebDriver driver){

        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        emailEstimate.click();
        log("Go to set your Email");
        return new YourEmailPage(driver);

    }

    public String getTotalCost(WebDriver driver){

        String fullCost = totalCost.getText();
        log("Get total cost " + fullCost.substring(26,38));
        return fullCost.substring(26,38);

    }

    @Override
    protected EstimatedResultsPage openPage() {
        throw new RuntimeException();
    }
}
