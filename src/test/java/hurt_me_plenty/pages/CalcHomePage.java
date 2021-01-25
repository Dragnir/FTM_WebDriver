package hurt_me_plenty.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CalcHomePage extends AbstrPage {

    @FindBy(xpath = "//*[@id='input_63']")
    private WebElement numberInstance;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesVer;

    @FindBy(xpath = "//*[@id='select_option_188']")
    private WebElement seriesVerCurrent;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement listMachineType;

    @FindBy(xpath = "//div[contains( text(),'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")
    private WebElement machineTypeVer;

    @FindBy(xpath = "//div[contains( text(),'Add GPUs.')]")
    private WebElement addGPUs;

    @FindBy(xpath = "//*[@id='select_value_label_392']")
    private WebElement numberGPUs;

    @FindBy(xpath = "//*[@id='select_option_399']")
    private WebElement currentGPUs;

    @FindBy(xpath = "//*[@id='select_value_label_393']")
    private WebElement typeGPUs;

    @FindBy(xpath = "//*[@id='select_option_406']")
    private WebElement currentTypeGPUs;

    @FindBy(xpath = "//*[@id='select_value_label_354']")
    private WebElement typeSSD;

    @FindBy(xpath = "//*[@id='select_option_381']")
    private WebElement currentSSD;

    @FindBy(xpath = "//*[@id='select_value_label_61']")
    private WebElement dataCenterLocations;

    @FindBy(xpath = "//*[@id='select_option_205']")
    private WebElement dataCenter;

    @FindBy(xpath = "//*[@id='select_value_label_62']")
    private WebElement committedUsage;

    @FindBy(xpath = "//*[@id='select_option_97']")
    private WebElement currentUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimate;

    public CalcHomePage(WebDriver driver) {
        super(driver);
    }

    public CalcHomePage setNumberInstance(String number){

        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");

        hightlightElement(numberInstance);
        numberInstance.sendKeys(number);
        log("Instance number set " + number);
        return this;

    }

    public CalcHomePage setSeries(){

        hightlightElement(seriesVer);
        seriesVer.click();
        seriesVerCurrent.click();
        log("Series set ");
        return this;

    }

    public CalcHomePage setMachineType(){

        hightlightElement(listMachineType);
        listMachineType.click();
        clickElement(machineTypeVer);
        log("Machine Type set " );
        return this;

    }

    public CalcHomePage setGPUs(){

        hightlightElement(addGPUs);
        addGPUs.click();
        numberGPUs.click();
        clickElement(currentGPUs);
        hightlightElement(typeGPUs);
        typeGPUs.click();
        clickElement(currentTypeGPUs);
        log("GPUs set " );
        return this;

    }

    public CalcHomePage setLocalSSD(){

        hightlightElement(typeSSD);
        typeSSD.click();
        hightlightElement(currentSSD);
        currentSSD.click();
        currentSSD.sendKeys(Keys.ENTER);
        log("Local SSD set " );
        return this;

    }

    public CalcHomePage setDataCenter(){

        hightlightElement(dataCenterLocations);
        dataCenterLocations.click();
        hightlightElement(dataCenter);
        dataCenter.click();
        dataCenter.sendKeys(Keys.ENTER);
        log("Data center location set " );
        return this;

    }

    public CalcHomePage setUsage(){

        hightlightElement(committedUsage);
        committedUsage.click();
        hightlightElement(currentUsage);
        currentUsage.click();
        log("Committed usage set " );
        return this;

    }

    public EstimatedResultsPage addToEstimate(){

        hightlightElement(addToEstimate);
        addToEstimate.click();
        log("Information added to estimate " );
        return new EstimatedResultsPage(driver);

    }

    @Override
    protected CloudHomePage openPage() {
        throw new RuntimeException();
    }
}
