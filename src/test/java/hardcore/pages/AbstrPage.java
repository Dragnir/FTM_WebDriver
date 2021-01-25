package hardcore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstrPage {

    protected static WebDriver driver;

    protected abstract AbstrPage openPage();

    protected final int WAIT_TIMEOUT_SECOND = 20;

    protected AbstrPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitWebElementClickable(String xPath){

        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECOND);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

        WebElement newWebElement = driver.findElement(By.xpath(xPath));

        return newWebElement;
    }

    public static void hightlightElement(WebElement element) {

        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = ' " + "yellow" + "'", element);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        js.executeScript("arguments[0].style.backgroundColor = ' " + "bg" + "'", element);

    }

    public static void clickElement(WebElement element) {

        new Actions(driver).moveToElement(element).click(element).build().perform();

    }

    public void log(String message) {

        System.out.println(message);

    }

}
