package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {

    @FindBy(css = "h2.complete-header")
    WebElement completeMessage;

    public CheckoutCompletePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCompleteMessage(String message){
        return completeMessage.getText().equalsIgnoreCase(message);
    }
}