package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

public class MenuSteps {
    private HomePage homePage = new HomePage(DriverManager.getDriver());
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @When("I click on the menu button")
    public void clickOnMenuButton() {
        homePage.clickOnMenuButton();
    }

    @Then("The menu options should be displayed")
    public void verifyMenuOptionsDisplayed() {
        Assert.assertTrue("Menu options should be displayed", homePage.areMenuOptionsDisplayed());
    }

    @When("I select the {string} option from menu")
    public void selectMenuOption(String option) {
        homePage.selectMenuOption(option);
    }

    @Then("I should be redirected to the Sauce Labs website")
    public void verifyRedirectedToSauceLabsWebsite() {
        Assert.assertTrue("Should be on Sauce Labs website", homePage.isOnSauceLabsWebsite());
    }

    @When("I go back to the inventory page")
    public void goBackToInventoryPage() {
        homePage.goBackToInventoryPage();
    }

    @Then("The cart should be empty")
    public void verifyCartIsEmpty() {
        Assert.assertTrue("Cart should be empty", homePage.isCartEmpty());
    }

    @Then("The cart icon should show {string} item")
    public void verifyCartItemCount(String expectedCount) {
        String actualCount = homePage.getCartItemCount();
        Assert.assertEquals("Cart item count mismatch", expectedCount, actualCount);
    }
}