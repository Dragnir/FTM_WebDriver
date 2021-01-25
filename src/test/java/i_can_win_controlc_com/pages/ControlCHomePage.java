package i_can_win_controlc_com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlCHomePage extends AbstrPage {

    private static final String HOMEPAGE_URL="http://controlc.com/";

    @FindBy(xpath = "//*[@id='input_text']")
    private WebElement textInput;

    @FindBy(xpath = "//*[@id='paste_title']")
    private WebElement pasteNameTitle;

    @FindBy(xpath = "//*[@id='paste_toolbar_bottom']/div[1]/input")
    private WebElement createNewPaste;

    private String messagePath = "//a[text()='Paste submitted successfully! (view)']";

    public ControlCHomePage(WebDriver driver) {
        super(driver);
    }

    public ControlCHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND).until(CustomCondition.jQueryAJAXsCompleted());
        return this;
    }

    public ControlCHomePage setText(String code) {

        hightlightElement(textInput);
        textInput.sendKeys(code);
        System.out.println("Text set");
        return this;

    }

    public ControlCHomePage setNameTitle(String nameTitle) {

        hightlightElement(pasteNameTitle);
        pasteNameTitle.sendKeys(nameTitle);
        System.out.println("Title set");
        return this;

    }

    public String submitNewPaste() {

        hightlightElement(createNewPaste);
        createNewPaste.click();
        System.out.println("Past set");
        WebElement message = driver.findElement(By.xpath(messagePath));
        hightlightElement(message);
        return message.getText();
        
    }

}
