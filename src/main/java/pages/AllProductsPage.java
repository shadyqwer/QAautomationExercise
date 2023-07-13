package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllProductsPage extends IndexPage {
    private WebElement categoryText;
    private List<WebElement> allProducts;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> productsInfo;

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

    public WebElement getSearchField() {
        searchField = getDriver().findElement(By.id("search_product"));
        return searchField;
    }

    public WebElement getSearchButton() {
        searchButton = getDriver().findElement(By.id("submit_search"));
        return searchButton;
    }

    public List<WebElement> getProductsInfo() {
        productsInfo = getDriver().findElements(By.className("productinfo"));
        return productsInfo;
    }

    public void viewProductByIndex(int index) {
        getAllProducts().get(index).click();
    }

    public AllProductsPage enterSearchText(String text) {
        getSearchField().sendKeys(text);
        return this;
    }

    public AllProductsPage searchProducts() {
        getSearchButton().click();
        return this;
    }

    public boolean checkSuccessfulSearch(String text) {
        text = text.toLowerCase();
        for (WebElement product : getProductsInfo()) {
            if (!product.getText().toLowerCase().contains(text)) {
                return false;
            }
        }
        return true;
    }
}
