package hurt_me_plenty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class EstimatedResultsPage extends AbstrPage {

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[2]/div")
    private WebElement vmClass;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[3]/div")
    private WebElement instanceType;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[4]/div")
    private WebElement region;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[5]/div")
    private WebElement localSSD;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[6]/div")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[7]/div")
    private WebElement totalCost;

    public EstimatedResultsPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> resultEstimation(){

        hightlightElement(vmClass);
        log("VM class is " + vmClass.getText());
        hightlightElement(instanceType);
        log("Instance type is " + instanceType.getText());
        hightlightElement(region);
        log("Region is " + region.getText());
        hightlightElement(localSSD);
        log("SSD is " + localSSD.getText());
        hightlightElement(commitmentTerm);
        log("Terms is " + commitmentTerm.getText());
        hightlightElement(totalCost);
        log("Total Cost is " + totalCost.getText());

        ArrayList<String> actualResult = new ArrayList<>();

        actualResult.add(0,vmClass.getText());
        actualResult.add(1,instanceType.getText());
        actualResult.add(2,region.getText());
        actualResult.add(3,localSSD.getText());
        actualResult.add(4,commitmentTerm.getText());
        actualResult.add(5,totalCost.getText());
        log("Actual Collection complited");

        return actualResult;

    }

    @Override
    protected CloudHomePage openPage() {
        throw new RuntimeException();
    }
}
