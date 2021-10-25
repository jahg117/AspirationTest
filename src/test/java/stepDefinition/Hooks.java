package stepDefinition;

import base.driverInitialize.DriverFactory;
import base.driverInitialize.SharedDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.AbstractTestNGCucumberParallelTests;
import utils.FileReading;

public class Hooks {
    private WebDriver driver = null;
    private String passed;
    private String failed;

    @Before
    public void Initialize(Scenario scenario) throws Exception {
        String browser = AbstractTestNGCucumberParallelTests.browser;
        FileReading fileReading = new FileReading();
        fileReading.setFileName("GlobalConfig.properties");
        passed = fileReading.getField("screenshotPass");
        failed = fileReading.getField("screenshotFail");
        SharedDriver df = new SharedDriver(browser);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @AfterStep
    public void takeScreenShot(Scenario scenario) {
        if(!scenario.isFailed()&&passed.equalsIgnoreCase("true")||scenario.isFailed()&&failed.equalsIgnoreCase("true")) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After
    public void CloseDriver(Scenario scenario){
        DriverFactory.getDriver().quit();
        DriverFactory.removeDriver();
    }

}
