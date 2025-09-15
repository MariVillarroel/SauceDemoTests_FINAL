package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class HomeSteps {
    private HomePage homePage = new HomePage(DriverManager.getDriver());

    @Then("The home page should be displayed")
    public void verifyHomePageIsDisplayed() {
        Assert.assertTrue("Home page should be displayed", homePage.sauceDemoTitleIsDisplayed());
    }

    @Then("The product {string} should be displayed")
    public void verifyProductIsDisplayed(String product) {
        Assert.assertTrue("Product should be displayed: " + product,
                homePage.productIsDisplayed(product));
    }

    @Then("I add the {string} to the cart")
    public void addProductToCart(String productName) {
        homePage.addProductToCart(productName);
    }

    @Then("I click on the cart icon")
    public void clickOnCartIcon() {
        homePage.clickOnCartIcon();
    }
}