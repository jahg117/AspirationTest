package pageObject.pages.apiration;

import base.functions.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SpendAndSavePage extends CommonFunctions {
    @FindBy(xpath = "//h2[contains(text(),'Spend & Save Plans')]")
    private WebElement labelSpendAndSave;

    @FindBy(xpath = "//section[7]/div/div[1]//h2[contains(text(),'Spend & Save Plans')]/..//span")
    private List<WebElement> listAspirationPlans;

    public boolean aspirationCardsDisplayed() throws Exception {
        boolean result = false;
        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("ASPIRATION");
        expectedResult.add("ASPIRATION PLUS");

        if(waitForElementVisibility(labelSpendAndSave, 10) && waitForElementListVisible(listAspirationPlans, 5)){
            scrollToWebElement(labelSpendAndSave);
            for (WebElement el : listAspirationPlans) {
                if(expectedResult.contains(el.getText())){
                    result = true;
                }else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
