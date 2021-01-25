package bring_it_on_controlc_com.tests;

import bring_it_on_controlc_com.pages.ControlCHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestControlC {

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

        String resultTitle = new ControlCHomePage(driver)
                .openPage().setText(code)
                .setNameTitle(pasteNameTitle)
                .setHighlighting(isHighlighter)
                .submitNewPaste()
                .goToResultPage()
                .checkTitle();

        System.out.println("Original Title " + pasteNameTitle);
        System.out.println("Result Title " + resultTitle);
        Assert.assertEquals(resultTitle, pasteNameTitle);
        System.out.println("Test finished");
    }

    @Test(description = "Check code")
    public void checkCode() {

        String resultCode = new ControlCHomePage(driver)
                .openPage().setText(code)
                .setNameTitle(pasteNameTitle)
                .setHighlighting(isHighlighter)
                .submitNewPaste()
                .goToResultPage()
                .checkCode();

        System.out.println("Original Code " + code);
        System.out.println("Result Code " + resultCode);
        Assert.assertEquals(resultCode, code);
        System.out.println("Test finished");
    }

    @Test(description = "Check Color")
    public void checkColor() {

        String resultColor = new ControlCHomePage(driver)
                .openPage().setText(code)
                .setNameTitle(pasteNameTitle)
                .setHighlighting(isHighlighter)
                .submitNewPaste()
                .goToResultPage()
                .checkColor();

        System.out.println("Original Color " + expectedColor);
        System.out.println("Result Color " + resultColor);
        Assert.assertEquals(resultColor, expectedColor);
        System.out.println("Test finished");
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver=null;
    }

}
