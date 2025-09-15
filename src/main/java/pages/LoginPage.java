package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement userNameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setUserNameTextBox(String userName){
        setText(userNameTextBox, userName);
    }

    public void setPasswordTextBox(String password){
        setText(passwordTextBox, password);
    }

    public void clickOnLoginButton(){
        clickElement(loginButton);
    }

    public boolean errorMessageIsDisplayed(String message){
        String actualMessage = errorMessage.getText();
        return message.equalsIgnoreCase(actualMessage);
    }

    public boolean isOnLoginPage() {
        try {
            return driver.getCurrentUrl().contains("saucedemo.com") &&
                    userNameTextBox.isDisplayed() &&
                    passwordTextBox.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}