package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleProductPage extends AllProductsPage {
    private WebElement productDetails;

    public SingleProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getProductDetails() {
        productDetails = getDriver().findElement(By.className("product-information"));
        return productDetails;
    }
}
