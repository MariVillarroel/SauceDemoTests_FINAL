package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.CheckoutInformationPage;
import java.util.List;

public class CheckoutInformationSteps {
    private CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(DriverManager.getDriver());

    @And("I fill the checkout information with")
    public void fillCheckoutInformation(DataTable checkoutInformation) {
        List<String> data = checkoutInformation.transpose().asList(String.class);
        checkoutInformationPage.setFirstNameTextBox(data.get(0));
        checkoutInformationPage.setLastNameTextBox(data.get(1));
        checkoutInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I click on the continue button")
    public void clickOnContinue() {
        checkoutInformationPage.clickOnContinueButton();
    }
}