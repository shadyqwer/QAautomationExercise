package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleProductPage extends AllProductsPage {
    private WebElement productDetails;
    private WebElement quantityField;
    private WebElement addToCartButton;
    private WebElement viewCartButton;

    public SingleProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getProductDetails() {
        productDetails = getDriver().findElement(By.className("product-information"));
        return productDetails;
    }

    public WebElement getQuantityField() {
        quantityField = getDriver().findElement(By.id("quantity"));
        return quantityField;
    }

    public WebElement getAddToCartButton() {
        addToCartButton = getDriver().findElement(By.cssSelector(".btn.btn-default.cart"));
        return addToCartButton;
    }

    @Override
    public WebElement getViewCartButton() {
        viewCartButton = getDriver().findElement(By.linkText("View Cart"));
        return viewCartButton;
    }

    public SingleProductPage setQuantity(int quantity) {
        getQuantityField().clear();
        getQuantityField().sendKeys(Integer.toString(quantity));
        return this;
    }

    public SingleProductPage addToCart() {
        getAddToCartButton().click();
        return this;
    }

    public SingleProductPage goToCart() {
        getViewCartButton().click();
        return this;
    }
}
