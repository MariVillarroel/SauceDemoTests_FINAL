package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Then("A error message that says {string} should be displayed")
    public void verifyErrorMessage(String message) {
        Assert.assertTrue("Error message should be displayed: " + message,
                loginPage.errorMessageIsDisplayed(message));
    }
}