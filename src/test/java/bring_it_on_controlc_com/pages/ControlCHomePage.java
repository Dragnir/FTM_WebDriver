package bring_it_on_controlc_com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlCHomePage extends AbstrPage {

    private static final String HOMEPAGE_URL="http://controlc.com/";

    @FindBy(xpath = "//textarea[@id='input_text']")
    private WebElement textInput;

    @FindBy(xpath = "//input[@id='paste_title']")
    private WebElement pasteNameTitle;

    @FindBy(xpath = "//select[@id='codeSyntax']")
    private WebElement selectHighlighting;

    @FindBy(xpath = "//*[@id='paste_toolbar_bottom']/div[1]/input")
    private WebElement createNewPaste;

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

    public ControlCHomePage setHighlighting(String highlighting) {
        hightlightElement(selectHighlighting);
        Select selectHL = new Select(selectHighlighting);
        selectHL.selectByVisibleText(highlighting);
        System.out.println("Title set");
        return this;
    }

    public CompletePage submitNewPaste() {
        hightlightElement(createNewPaste);
        createNewPaste.click();
        System.out.println("Past set");
        return new CompletePage(driver);
    }

}
