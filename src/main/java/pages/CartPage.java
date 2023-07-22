package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends IndexPage {
    private List<WebElement> productQuantity;
    private List<WebElement> productPrice;
    private WebElement proceedToCheckoutButton;
    private WebElement emptyCartField;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<WebElement> getProductQuantity() {
        productQuantity = getDriver().findElements(By.className("cart_quantity"));
        return productQuantity;
    }

    public List<WebElement> getProductPrice() {
        productPrice = getDriver().findElements(By.className("cart_total"));
        return productPrice;
    }

    public WebElement getProceedToCheckoutButton() {
        proceedToCheckoutButton = getDriver().findElement(By.className("check_out"));
        return proceedToCheckoutButton;
    }

    public WebElement getEmptyCartField() {
        emptyCartField = getDriver().findElement(By.id("empty_cart"));
        return emptyCartField;
    }

    public int productsQuantity() {
        int quantity = 0;
        for (WebElement productQuantity : getProductQuantity()) {
            quantity += Integer.parseInt(productQuantity.getText());
        }
        return quantity;
    }

    public double getCartTotal() {
        double cartTotal = 0;
        for (WebElement productPrice : getProductPrice()) {
            String price = productPrice.getText();
            price = price.replaceAll("Rs.", "").trim();
            cartTotal += Double.parseDouble(price);
        }
        return cartTotal;
    }

    public CartPage proceedToCheckout() {
        getProceedToCheckoutButton().click();
        return this;
    }

    public void removeAllProducts() {
        List<WebElement> deleteButtons = getDriver().findElements(By.className("cart_quantity_delete"));
        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }
    }
}
