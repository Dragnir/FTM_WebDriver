package hardcore.tests;

import hardcore.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class TestCloudGoogle {

    private WebDriver driver;
    private String searchInput = "Google Cloud Platform Pricing Calculator";
    private String numberInstance = "4";
    ArrayList<String> tabs;

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Check total costs from estimated page and from email")
    public void checkCalculator() throws IOException, UnsupportedFlavorException {

        //Set full information for estimation and get Total cost from estimate page
        EstimatedResultsPage estimatedResult =
                new CloudHomePage(driver)
                .openPage()
                .setSearchText(searchInput)
                .goToResult(searchInput)
                .setNumberInstance(numberInstance)
                .setSeries()
                .setMachineType()
                .setGPUs()
                .setLocalSSD()
                .setDataCenter()
                .setUsage()
                .addToEstimate();
        String estimatedTotalCost = estimatedResult.getTotalCost(driver);

        //Create new tab, go to email generator and get new email.
        createNewTab(driver);
        TenMinutesMailPage mailTenMinutesPage = new TenMinutesMailPage(driver).openPage();
        String newMail = mailTenMinutesPage.getMailAddress();

        //Return to Estimate page, set new email and send mail with total cost
        moveToTab(0);
        estimatedResult.goToSetEmail(driver).setYourMail(newMail).sendEmail();

        //Return to Mail generator and waite new mail. Get total cost from mail.
        moveToTab(1);
        String mailTotalCost = mailTenMinutesPage.getMailCost();

        //Compare total cost from estimated page and from mail.
        Assert.assertEquals(estimatedTotalCost, mailTotalCost);
        System.out.println("Test finished successfully");
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver=null;
    }

    public void createNewTab(WebDriver driver){

        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));;
    }

    public void moveToTab(int tabNumber){

        driver.switchTo().window(tabs.get(tabNumber));
    }

}
