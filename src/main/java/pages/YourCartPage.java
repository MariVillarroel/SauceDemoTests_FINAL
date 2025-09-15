package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends BasePage {

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    public YourCartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckoutButton(){
        clickElement(checkoutButton);
    }

    // MÉTODOS NUEVOS PARA LOS TESTS ADICIONALES
    public double getProductPrice(String productName) {
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']";
        WebElement priceElement = driver.findElement(By.xpath(xpath));
        String priceText = priceElement.getText().replace("$", "");
        return Double.parseDouble(priceText);
    }

    public boolean isOnCartPage() {
        try {
            return driver.getCurrentUrl().contains("cart.html");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCheckoutButtonDisplayed() {
        try {
            return checkoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnContinueShopping() {
        clickElement(continueShoppingButton);
    }

    public void removeItemFromCart(String productName) {
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//button[text()='Remove']";
        WebElement removeButton = driver.findElement(By.xpath(xpath));
        clickElement(removeButton);
    }

    public boolean isItemInCart(String productName) {
        try {
            String xpath = "//div[text()='" + productName + "']";
            WebElement productElement = driver.findElement(By.xpath(xpath));
            return isElementDisplayed(productElement);
        } catch (Exception e) {
            return false;
        }
    }
}