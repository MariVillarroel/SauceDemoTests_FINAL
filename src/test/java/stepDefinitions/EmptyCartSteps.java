package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.YourCartPage;

public class EmptyCartSteps {
    private YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver());

    @Then("I should remain on the cart page")
    public void verifyRemainOnCartPage() {
        Assert.assertTrue("Expected to remain on cart page", yourCartPage.isOnCartPage());
    }

    @Then("An error message should be displayed")
    public void verifyErrorMessageDisplayed() {
        Assert.assertTrue("Checkout should not proceed with empty cart", yourCartPage.isCheckoutButtonDisplayed());
    }
}