package hardcore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TenMinutesMailPage extends AbstrPage {

    private static final String HOMEPAGE_URL="https://10minutemail.com";

    @FindBy(xpath = "//*[@id='copy_address']")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/table/tbody/tr[1]/td[4]")
    private WebElement mailCost;

    String newMailPath = "//*[@id='mail_messages_content']/div/div[1]";

    public TenMinutesMailPage(WebDriver driver) {
        super(driver);
    }

    public TenMinutesMailPage openPage() {

        driver.get(HOMEPAGE_URL);
        return this;
    }

    public String getMailAddress() throws IOException, UnsupportedFlavorException {

        hightlightElement(mailAddress);
        mailAddress.click();
        String newMail = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        log("New email address ready " + newMail);
        return newMail;
    }

    public String getMailCost(){

        WebElement newMail = waitWebElementClickable(newMailPath);
        hightlightElement(newMail);
        newMail.click();
        hightlightElement(mailCost);
        log("Email total cost is " + mailCost.getText());
        return mailCost.getText();
    }
}
