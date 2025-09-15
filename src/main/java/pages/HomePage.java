package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.ArrayList;

public class HomePage extends BasePage {

    @FindBy(className = "app_logo")
    private WebElement sauceDemoTitle;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(className = "bm-menu-wrap")
    private WebElement menuContainer;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutOption;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutOption;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetOption;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement closeMenuButton;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean sauceDemoTitleIsDisplayed() {
        return isElementDisplayed(sauceDemoTitle);
    }

    public boolean productIsDisplayed(String expectedProductName){
        for (WebElement element: productNames){
            String actualProductName = element.getText();
            if(actualProductName.equalsIgnoreCase(expectedProductName)){
                return true;
            }
        }
        return false;
    }

    public void addProductToCart(String productName){
        String productId = "add-to-cart-"+productName.replace(" ", "-").toLowerCase();
        WebElement addToCartButton = driver.findElement(By.id(productId));
        clickElement(addToCartButton);
    }

    public void clickOnCartIcon(){
        clickElement(cartIcon);
    }

    // MÉTODOS NUEVOS PARA LOS TESTS ADICIONALES
    public double getProductPrice(String productName) {
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";
        WebElement priceElement = driver.findElement(By.xpath(xpath));
        String priceText = priceElement.getText().replace("$", "");
        return Double.parseDouble(priceText);
    }

    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement element : productNames) {
            names.add(element.getText());
        }
        return names;
    }

    public void selectSortingOption(String option) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(option);
    }

    public boolean isOnHomePage() {
        try {
            return driver.getCurrentUrl().contains("inventory.html");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean canAddProductsToCart() {
        try {
            List<WebElement> addButtons = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
            return !addButtons.isEmpty() && addButtons.get(0).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnMenuButton() {
        clickElement(menuButton);
    }

    public boolean areMenuOptionsDisplayed() {
        try {
            return isElementDisplayed(menuContainer) &&
                    isElementDisplayed(aboutOption) &&
                    isElementDisplayed(logoutOption) &&
                    isElementDisplayed(resetOption);
        } catch (Exception e) {
            return false;
        }
    }

    public void selectMenuOption(String option) {
        switch (option.toLowerCase()) {
            case "about":
                clickElement(aboutOption);
                break;
            case "logout":
                clickElement(logoutOption);
                break;
            case "reset app state":
                clickElement(resetOption);
                break;
            default:
                throw new IllegalArgumentException("Unknown menu option: " + option);
        }
    }

    public boolean isOnSauceLabsWebsite() {
        try {
            // Esperar a que la página se cargue completamente
            Thread.sleep(2000);
            return driver.getCurrentUrl().contains("saucelabs.com");
        } catch (Exception e) {
            return false;
        }
    }

    public void goBackToInventoryPage() {
        driver.navigate().back();
        // Esperar a que la página se recargue
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isCartEmpty() {
        try {
            // Si el badge del carrito no está visible, el carrito está vacío
            return !cartBadge.isDisplayed();
        } catch (Exception e) {
            // Si ocurre una excepción, significa que el elemento no existe, por lo tanto el carrito está vacío
            return true;
        }
    }

    public String getCartItemCount() {
        try {
            return cartBadge.getText();
        } catch (Exception e) {
            return "0"; // Si no hay badge, el carrito está vacío
        }
    }

    public void closeMenu() {
        try {
            if (closeMenuButton.isDisplayed()) {
                clickElement(closeMenuButton);
            }
        } catch (Exception e) {
            // El botón de cerrar podría no estar visible
        }
    }
}