package pageObject.application;

import base.driverInitialize.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.pages.apiration.GetStartedModalPage;
import pageObject.pages.apiration.NavigationBarPage;
import pageObject.pages.apiration.SpendAndSavePage;
import utils.FileReading;

public class Aspiration {
    private WebDriver driver;
    private NavigationBarPage navigationBar;
    private SpendAndSavePage spendAndSavePage;
    private GetStartedModalPage getStartedModalPage;

    public Aspiration() {
        driver = DriverFactory.getDriver();
        navigationBar = PageFactory.initElements(driver, NavigationBarPage.class);
        spendAndSavePage = PageFactory.initElements(driver, SpendAndSavePage.class);
        getStartedModalPage = PageFactory.initElements(driver, GetStartedModalPage.class);
    }

    public void goTo() {
        FileReading fileReading = new FileReading();
        fileReading.setFileName("GlobalConfig.properties");
        driver.get(fileReading.getField("URL"));
    }

    public NavigationBarPage getNavigationBar() { return navigationBar; }
    public SpendAndSavePage getSpendAndSavePage() { return spendAndSavePage; }
    public GetStartedModalPage getStartedModalPage() { return getStartedModalPage; }
}
