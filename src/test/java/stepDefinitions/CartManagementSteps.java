package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.YourCartPage;

public class CartManagementSteps {
    private YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver());
    private HomePage homePage = new HomePage(DriverManager.getDriver());

    @When("I click on the continue shopping button")
    public void clickOnContinueShopping() {
        yourCartPage.clickOnContinueShopping();
    }

    @Then("I should be redirected to the home page")
    public void verifyRedirectedToHomePage() {
        Assert.assertTrue("Should be redirected to home page", homePage.isOnHomePage());
    }

    @Then("I should be able to add another product to cart")
    public void verifyCanAddAnotherProduct() {
        Assert.assertTrue("Should be able to add products", homePage.canAddProductsToCart());
    }
}