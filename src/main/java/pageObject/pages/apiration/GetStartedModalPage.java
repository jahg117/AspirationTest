package pageObject.pages.apiration;

import base.functions.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GetStartedModalPage extends CommonFunctions {
    @FindBy(css = "div[class*='ReactModal__Content'] input[name='email']")
    private WebElement inputEmailAddress;

    @FindBy(css = "div[class*='ReactModal__Content'] path")
    private WebElement buttonCloseModal;

    public boolean isInputEmailAddressDisplayed() throws Exception {
        return waitForElementVisibility(inputEmailAddress, 10);
    }

    public void clickCloseModal() throws Exception {
        clickElementVisible(buttonCloseModal, 10);
    }
}
