package hurt_me_plenty.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstrPage {

    protected static WebDriver driver;

    protected abstract CloudHomePage openPage();

    protected final int WAIT_TIMEOUT_SECOND = 20;

    protected AbstrPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
