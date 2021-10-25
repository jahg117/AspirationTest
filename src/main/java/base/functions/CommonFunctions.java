package base.functions;

import base.driverInitialize.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CommonFunctions {
    private WebDriver driver = DriverFactory.getDriver();


    /**
     * Return a WebElement if it is found
     *
     * @param locator to find as a WebElement
     * @return WebElement if it is found
     * @author Alejandro Hernandez
     */
    protected WebElement getWebElement(By locator) throws Exception {
        WebElement webElement = null;
        try {
            webElement = driver.findElement(locator);
        } catch (Exception e) {
        }
        return webElement;
    }
    protected List<WebElement> getWebElementList(By locator) throws Exception {
        List<WebElement> webElements = new ArrayList<>();
        try {
            webElements = driver.findElements(locator);
        } catch (Exception e) {
            webElements = null;
        }
        return webElements;
    }

    /**
     * Return true if a WebElement is visible or false if it's not visible
     *
     * @param webElement       WebElement to find.
     * @param timeOutInSeconds Seconds to wait for a WebElement.
     * @return boolean
     * @author Alejandro Hernandez
     */
    public boolean waitForElementVisibility(WebElement webElement, int timeOutInSeconds) throws Exception {
        boolean statusOperation = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            statusOperation = true;
        } catch (Exception e) {
            statusOperation = false;
        }
        return statusOperation;
    }

    /**
     * Return true if a WebElement is clickable or false if it's not clickable
     *
     * @param webElement       WebElement to find.
     * @param timeOutInSeconds Seconds to wait for a WebElement.
     * @return boolean
     * @author Alejandro Hernandez
     */
    protected boolean waitForElementClickable(WebElement webElement, int timeOutInSeconds) throws Exception {
        boolean statusOperation = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            statusOperation = true;
        } catch (Exception e) {
            statusOperation = false;
        }
        return statusOperation;
    }

    /**
     * Method used to click and wait for a visible WebElement
     *
     * @param webElement       contains the Element to select
     * @param timeOutInSeconds time to wait for a WebElement
     * @throws Exception selenium Exception
     * @author Alejandro Hernandez
     */
    protected void clickElementVisible(WebElement webElement, int timeOutInSeconds) throws Exception {
        try {
            if (waitForElementVisibility(webElement, timeOutInSeconds)) {
                clickMethodsWebElement(webElement);
            } else {
                throw new NoSuchElementException("WebElement not clickable");
            }
        } catch (Exception e) {
            throw new NoSuchElementException("WebElement not clickable");
        }
    }

    /**
     * @param webElement contains the WebElement to click
     * @throws Exception Javascript Error or selenium Exception
     * @author Alejandro Hernandez
     * @method perform a click action by Actions Class, Webelement.click or Javascript click, in case there is an error
     * with Actions, WebElement click and using as last option Javascript Click. Using the WebElement
     */
    public void clickMethodsWebElement(WebElement webElement) throws Exception {
        try {
            Actions actions = new Actions(driver);
            actions.click(webElement).build().perform();
        } catch (Exception e) {
                try {
                    webElement.click();
                } catch (Exception e2) {
                    clickElementJS(webElement);
                }
        }
    }

    /**
     * Click to an element with JavaScript
     *
     * @param webElement contains the Element to do click
     * @return returns true if the click was done successfully
     * @throws Exception selenium Exception
     * @author Alejandro Hernandez
     */
    protected void clickElementJS(WebElement webElement) throws Exception {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", webElement);
        } catch (Exception e) {
        }
    }

    /**
     * This method is to scroll to a webElement in specific with JS
     *
     * @param webElement to scroll
     * @return
     * @throws Exception selenium Exception
     * @author Alejandro Hernandez
     */
    protected void scrollToWebElement(WebElement webElement) throws Exception {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
        } catch (Exception e) {

        }
    }

    /**
     * Return true if a list of WebElements is visible or false if it's not visible
     *
     * @param webElements      List of WebElements to find.
     * @param timeOutInSeconds Seconds to wait for a WebElement.
     * @return boolean
     * @author Alejandro Hernandez
     */
    protected boolean waitForElementListVisible(List<WebElement> webElements, int timeOutInSeconds) throws Exception {
        boolean statusOperation = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
            statusOperation = true;
        } catch (Exception e) {
            statusOperation = false;
        }
        return statusOperation;
    }

}
