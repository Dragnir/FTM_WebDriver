package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourEmailPage extends AbstrPage {

    @FindBy(xpath = "//*[@id='input_477']")
    private WebElement inputYourMail;

    @FindBy(xpath = "//*[@id='dialogContent_483']/form/md-dialog-actions/button[2]")
    private WebElement sendEmail;

    public YourEmailPage(WebDriver driver) {
        super(driver);
    }

    public YourEmailPage setYourMail(String yourMail){
        hightlightElement(inputYourMail);
        inputYourMail.sendKeys(yourMail);
        log("You new email set");
        return this;
    }

    public YourEmailPage sendEmail(){
        hightlightElement(sendEmail);
        sendEmail.click();
        log("New mail with total cost sent");
        return this;
    }

    @Override
    protected YourEmailPage openPage() {
        throw new RuntimeException();
    }
}