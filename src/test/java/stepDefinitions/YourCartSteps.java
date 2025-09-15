package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.When;
import pages.YourCartPage;

public class YourCartSteps {
    private YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver());

    @When("I click on the checkout button")
    public void clickOnCheckoutButton() {
        yourCartPage.clickOnCheckoutButton();
    }
}