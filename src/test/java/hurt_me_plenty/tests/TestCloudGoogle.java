package hurt_me_plenty.tests;

import hurt_me_plenty.pages.CloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestCloudGoogle {

    private WebDriver driver;
    private String searchInput = "Google Cloud Platform Pricing Calculator";
    private String numberInstance = "4";
    private String vmClass = "VM class: regular";
    private String instanceType = "Instance type: n1-standard-8";
    private String region = "Region: Frankfurt";
    private String totalSDD = "Total available local SSD space 2x375 GiB";
    private String term = "Commitment term: 1 Year";
    private String estimatedCost = "Estimated Component Cost: USD 1,082.77 per 1 month";

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Check Calculator")
    public void checkCalculator(){

        ArrayList<String> actualResult = new CloudHomePage(driver)
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
                .addToEstimate()
                .resultEstimation();

        Assert.assertEquals(actualResult, getExpectedResult());
        System.out.println("Test finished");
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver=null;
    }

    public ArrayList<String> getExpectedResult(){

        ArrayList<String> expectedResult = new ArrayList<>();

        expectedResult.add(0,vmClass);
        expectedResult.add(1,instanceType);
        expectedResult.add(2,region);
        expectedResult.add(3,totalSDD);
        expectedResult.add(4,term);
        expectedResult.add(5,estimatedCost);

        return expectedResult;
    }

}
