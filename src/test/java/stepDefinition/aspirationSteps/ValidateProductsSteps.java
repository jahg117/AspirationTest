package stepDefinition.aspirationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.AplicationInstance;

public class ValidateProductsSteps extends AplicationInstance {

    @Given("^I navigate to aspiration site$")
    public void navigateAspirationSite() throws Throwable {
        aspiration.goTo();
    }

    @When("^I click on spend and save option$")
    public void clickSpendAndSaveOption() throws Throwable {
        aspiration.getNavigationBar().clickSpendAndSaveOption();
    }

    @Then("^I validate the correct aspiration products are displayed$")
    public void validateCorrectAspirationProductsDisplayed() throws Throwable {
        boolean result = aspiration.getSpendAndSavePage().aspirationCardsDisplayed();
        Assert.assertTrue(result, "The aspiration cards are not matching");
    }

    @And("^I click on GetStarted$")
    public void clickGetstarted() throws Throwable {
        aspiration.getNavigationBar().clickButtonGetStarted();
    }

    @And("^I validate the input email address is displayed$")
    public void validateInputEmailAddressDisplayed() throws Throwable {
        Assert.assertTrue(aspiration.getStartedModalPage().isInputEmailAddressDisplayed(), "The input email address is not displayed");
        aspiration.getStartedModalPage().clickCloseModal();
    }

}
