package bring_it_on_controlc_com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends AbstrPage {

    @FindBy(xpath = "//*[@id='pastecontainer']/div[1]/div[2]")
    private WebElement resultTitle;

    private String xPathCode = "//*[@id='thepaste']";
    private String xPathCodeColor = "//*[@id='thepaste']/span[7]";

    @FindBy(xpath = "//*[@id='pasteLinks']/a[2]")
    private WebElement fullScreenBtn;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public String checkTitle(){

        hightlightElement(resultTitle);
        System.out.println("Title is present " + resultTitle.getText());

        return resultTitle.getText();

    }

    public String checkCode(){

        hightlightElement(fullScreenBtn);
        fullScreenBtn.click();
        WebElement resultCode = driver.findElement(By.xpath(xPathCode));
        hightlightElement(resultCode);
        System.out.println("Title is present " + resultCode.getText());

        return resultCode.getText();

    }

    public String checkColor(){

        hightlightElement(fullScreenBtn);
        fullScreenBtn.click();
        WebElement resultCodeColor = driver.findElement(By.xpath(xPathCodeColor));
        String color = resultCodeColor.getCssValue("color");

        return Color.fromString(color).asHex();

    }

    @Override
    protected AbstrPage openPage() {
        throw new RuntimeException();
    }

}
