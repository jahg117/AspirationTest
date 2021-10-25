package pageObject.pages.apiration;

import base.functions.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBarPage extends CommonFunctions {

    @FindBy(css = "a[href*='spendandsave']")
    private WebElement buttonSpendAndSave;

    @FindBy(css = "button[data-id='open-account-button']")
    private WebElement buttonGetStarted;

    public void clickButtonGetStarted() throws Exception {
        clickElementVisible(buttonGetStarted, 10);
    }

    public void clickSpendAndSaveOption() throws Exception {
        clickElementVisible(buttonSpendAndSave, 10);
    }
}
