package i_can_win_controlc_com.tests;

import i_can_win_controlc_com.pages.ControlCHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestControlC {

    private WebDriver driver;
    private String code = "Hello from WebDriver";
    private String pasteNameTitle = "helloweb";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "First Test")
    public void createNewPaste() {

        System.out.println(new ControlCHomePage(driver)
                .openPage().setText(code)
                .setNameTitle(pasteNameTitle)
                .submitNewPaste());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver=null;
    }

}
