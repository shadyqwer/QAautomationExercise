package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllProductsPage extends IndexPage {
    private WebElement categoryText;
    private List<WebElement> allProducts;

    public AllProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getCategoryText() {
        categoryText = getDriver().findElement(By.cssSelector(".title.text-center"));
        return categoryText;
    }

    public List<WebElement> getAllProducts() {
        allProducts = getDriver().findElements(By.className("fa-plus-square"));
        return allProducts;
    }

    public void viewProductByIndex(int index) {
        getAllProducts().get(index).click();
    }
}
