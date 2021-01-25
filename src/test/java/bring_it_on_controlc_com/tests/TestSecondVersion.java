package bring_it_on_controlc_com.tests;

import bring_it_on_controlc_com.pages.ControlCHomePage;
import bring_it_on_controlc_com.pages.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSecondVersion {

    private WebDriver driver;
    private String code = "git config --global user.name  'New Sheriff in Town'\n" +
            "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')\n" +
            "git push origin master --force";
    private String pasteNameTitle = "how to gain dominance among developers";
    private String expectedColor = "#008800";
    private String isHighlighter = "Yes";

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Check Title")
    public void checkTitle() {

        Assert.assertEquals(checkResultPage().checkTitle(), pasteNameTitle);

    }

    @Test(description = "Check code")
    public void checkCode() {

        Assert.assertEquals(checkResultPage().checkCode(), code);

    }

    @Test(description = "Check color")
    public void checkColor() {

        Assert.assertEquals(checkResultPage().checkColor(), expectedColor);

    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver=null;
    }

    public ResultPage checkResultPage() {

        return new ControlCHomePage(driver)
                .openPage().setText(code)
                .setNameTitle(pasteNameTitle)
                .setHighlighting(isHighlighter)
                .submitNewPaste()
                .goToResultPage();

    }

}
