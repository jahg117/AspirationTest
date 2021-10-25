package base.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator extends WebDriverCreator {
    @Override
    public WebDriver createWebDriver() {
        WebDriver driver;
        driver = new FirefoxDriver();
        return driver;
    }
}
