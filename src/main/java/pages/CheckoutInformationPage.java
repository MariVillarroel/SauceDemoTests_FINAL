package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstNameTextBox;

    @FindBy(id = "last-name")
    WebElement lastNameTextBox;

    @FindBy(id = "postal-code")
    WebElement zipCodeTextBox;

    @FindBy(id = "continue")
    WebElement continueButton;

    public CheckoutInformationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameTextBox(String firstName){
        setText(firstNameTextBox, firstName);
    }

    public void setLastNameTextBox(String lastName){
        setText(lastNameTextBox, lastName);
    }

    public void setZipCodeTextBox(String zipCode){
        setText(zipCodeTextBox, zipCode);
    }

    public void clickOnContinueButton(){
        clickElement(continueButton);
    }
}