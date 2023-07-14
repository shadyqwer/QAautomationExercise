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
    private WebElement continueShoppingButton;
    private WebElement viewCartButton;

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

    public WebElement getContinueShoppingButton() {
        continueShoppingButton = getDriver().findElement(By.className("btn-success"));
        return continueShoppingButton;
    }

    public WebElement getViewCartButton() {
        viewCartButton = getDriver().findElement(By.xpath("//p[@class='text-center']//a"));
        return viewCartButton;
    }

    public void viewProductByIndex(int index) {
        getAllProducts().get(index).click();
    }

    public AllProductsPage hoverOverProduct(int index) {
        getActions().moveToElement(getProductsInfo().get(index)).perform();
        return this;
    }

    public AllProductsPage addProductToCart(int index) {
        int inx = (index + 1) * 2;
        getDriver().findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])["+inx+"]")).click();
        return this;
    }

    public AllProductsPage continueShopping() {
        getContinueShoppingButton().click();
        return this;
    }

    public AllProductsPage viewCart() {
        getViewCartButton().click();
        return this;
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

    public double getProductPrice(int index) {
        String productPrice = getProductsInfo().get(index).getText().split("\n")[0];
        productPrice = productPrice.replaceAll("Rs.", "").trim();
        return Double.parseDouble(productPrice);
    }
}
