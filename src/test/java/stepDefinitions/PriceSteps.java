package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.YourCartPage;
import java.util.HashMap;
import java.util.Map;

public class PriceSteps {
    private HomePage homePage = new HomePage(DriverManager.getDriver());
    private YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver());
    private Map<String, Double> productPrices = new HashMap<>();

    @Given("I note the price of {string} on home page")
    public void noteProductPrice(String productName) {
        double price = homePage.getProductPrice(productName);
        productPrices.put(productName, price);
    }

    @Then("The price of {string} in cart should match the home page price")
    public void verifyPriceConsistency(String productName) {
        double expectedPrice = productPrices.get(productName);
        double actualPrice = yourCartPage.getProductPrice(productName);
        Assert.assertEquals("Price mismatch for " + productName, expectedPrice, actualPrice, 0.001);
    }
}