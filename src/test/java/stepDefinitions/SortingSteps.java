package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SortingSteps {
    private HomePage homePage = new HomePage(DriverManager.getDriver());

    @When("I select the {string} sorting option")
    public void selectSortingOption(String option) {
        homePage.selectSortingOption(option);
    }

    @Then("The products should be sorted in ascending alphabetical order")
    public void verifyProductsSortedAscending() {
        List<String> productNames = homePage.getProductNames();
        List<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(sortedNames);
        Assert.assertEquals("Products are not sorted in ascending order", sortedNames, productNames);
    }

    @Then("The products should be sorted in descending alphabetical order")
    public void verifyProductsSortedDescending() {
        List<String> productNames = homePage.getProductNames();
        List<String> sortedNames = new ArrayList<>(productNames);
        sortedNames.sort(Collections.reverseOrder());
        Assert.assertEquals("Products are not sorted in descending order", sortedNames, productNames);
    }
}