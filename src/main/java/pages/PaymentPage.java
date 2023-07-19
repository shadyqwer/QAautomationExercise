package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends CheckoutPage{
    private WebElement nameOnCardField;
    private WebElement cardNumberField;
    private WebElement CVCField;
    private WebElement expirationMonthField;
    private WebElement expirationYearField;
    private WebElement payAndConfirmOrderButton;

    public PaymentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameOnCardField() {
        nameOnCardField = getDriver().findElement(By.name("name_on_card"));
        return nameOnCardField;
    }

    public WebElement getCardNumberField() {
        cardNumberField = getDriver().findElement(By.name("card_number"));
        return cardNumberField;
    }

    public WebElement getCVCField() {
        CVCField = getDriver().findElement(By.name("cvc"));
        return CVCField;
    }

    public WebElement getExpirationMonthField() {
        expirationMonthField = getDriver().findElement(By.name("expiry_month"));
        return expirationMonthField;
    }

    public WebElement getExpirationYearField() {
        expirationYearField = getDriver().findElement(By.name("expiry_year"));
        return expirationYearField;
    }

    public WebElement getPayAndConfirmOrderButton() {
        payAndConfirmOrderButton = getDriver().findElement(By.id("submit"));
        return payAndConfirmOrderButton;
    }

    public PaymentPage enterNameOnCart(String text) {
        getNameOnCardField().clear();
        getNameOnCardField().sendKeys(text);
        return this;
    }

    public PaymentPage enterCardNumber(String text) {
        getCardNumberField().clear();
        getCardNumberField().sendKeys(text);
        return this;
    }

    public PaymentPage enterCVC(String text) {
        getCVCField().clear();
        getCVCField().sendKeys(text);
        return this;
    }

    public PaymentPage enterExpirationMonth(String text) {
        getExpirationMonthField().clear();
        getExpirationMonthField().sendKeys(text);
        return this;
    }

    public PaymentPage enterExpirationYear(String text) {
        getExpirationYearField().clear();
        getExpirationYearField().sendKeys(text);
        return this;
    }

    public PaymentPage payAndConfirmOrder() {
        getPayAndConfirmOrderButton().click();
        return this;
    }
}
