package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends CartPage {
    private WebElement commentBox;
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getCommentBox() {
        commentBox = getDriver().findElement(By.name("message"));
        return commentBox;
    }

    public WebElement getPlaceOrderButton() {
        placeOrderButton = getDriver().findElement(By.className("check_out"));
        return placeOrderButton;
    }

    public CheckoutPage enterComment(String text) {
        getCommentBox().sendKeys(text);
        return this;
    }

    public CheckoutPage placeOrder() {
        getPlaceOrderButton().click();
        return this;
    }
}
