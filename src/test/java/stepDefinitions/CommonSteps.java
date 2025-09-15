package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class CommonSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("I am in sauce demo web page")
    public void goToSauceDemoPage() {
        DriverManager.getDriver().get("https://www.saucedemo.com");
    }

    @When("I set the user name text box with {string}")
    public void setUserName(String userName) {
        loginPage.setUserNameTextBox(userName);
    }

    @When("I set the password text box with {string}")
    public void setPassword(String password) {
        loginPage.setPasswordTextBox(password);
    }

    @When("I click on the login button")
    public void clickOnLogin() {
        loginPage.clickOnLoginButton();
    }

    @Then("I should be redirected to the login page")
    public void verifyRedirectedToLoginPage() {
        Assert.assertTrue("Should be redirected to login page",
                DriverManager.getDriver().getCurrentUrl().contains("saucedemo.com"));
    }
}