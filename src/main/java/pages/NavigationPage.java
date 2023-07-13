package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage extends BasePage {
    private WebElement signupLoginButton;
    private WebElement loggedInAs;
    private WebElement deleteAccount;
    private WebElement logoutButton;
    private WebElement homeButton;
    private WebElement contactUsButton;
    private WebElement testCasesButton;
    private WebElement productsButton;
    private WebElement footerBottom;
    private WebElement subscriptionField;
    private WebElement subscriptionButton;
    private WebElement successSubscription;
    private WebElement cartButton;

    public NavigationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSignupLoginButton() {
        signupLoginButton = getDriver().findElement(By.xpath("//li[contains(., 'Signup / Login')]"));
        return signupLoginButton;
    }

    public WebElement getLoggedInAs() {
        loggedInAs = getDriver().findElement(By.className("fa-user"));
        return loggedInAs;
    }

    public WebElement getDeleteAccount() {
        deleteAccount = getDriver().findElement(By.className("fa-trash-o"));
        return deleteAccount;
    }

    public WebElement getLogoutButton() {
        logoutButton = getDriver().findElement(By.className("fa-lock"));
        return logoutButton;
    }

    public WebElement getHomeButton() {
        homeButton = getDriver().findElement(By.className("fa-home"));
        return homeButton;
    }

    public WebElement getContactUsButton() {
        contactUsButton = getDriver().findElement(By.className("fa-envelope"));
        return contactUsButton;
    }

    public WebElement getTestCasesButton() {
        testCasesButton = getDriver().findElement(By.xpath("//a[contains(text(), 'Test Cases')]"));
        return testCasesButton;
    }

    public WebElement getProductsButton() {
        productsButton = getDriver().findElement(By.xpath("//a[contains(text(), 'Products')]"));
        return productsButton;
    }

    public WebElement getFooterBottom() {
        footerBottom = getDriver().findElement(By.className("footer-bottom"));
        return footerBottom;
    }

    public WebElement getSubscriptionField() {
        subscriptionField = getDriver().findElement(By.id("susbscribe_email"));
        return subscriptionField;
    }

    public WebElement getSubscriptionButton() {
        subscriptionButton = getDriver().findElement(By.id("subscribe"));
        return subscriptionButton;
    }

    public WebElement getSuccessSubscription() {
        successSubscription = getDriver().findElement(By.id("success-subscribe"));
        return successSubscription;
    }

    public WebElement getCartButton() {
        cartButton = getDriver().findElement(By.xpath("//li//i[@class='fa fa-shopping-cart']"));
        return cartButton;
    }

    public String loggedInUsername() {
        return getLoggedInAs().findElement(By.xpath("./..")).getText();
    }

    public void deleteUser() {
        getDeleteAccount().click();
    }

    public void logoutUser() {
        getLogoutButton().click();
    }

    public NavigationPage openTestCases() {
        getTestCasesButton().click();
        return this;
    }

    public void openAllProducts() {
        getProductsButton().click();
    }

    public void openCart() {
        getCartButton().click();
    }

    public NavigationPage scrollDownToFooter() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getFooterBottom());
        return this;
    }

    public NavigationPage enterSubscriptionEmail(String email) {
        getSubscriptionField().sendKeys(email);
        return this;
    }

    public NavigationPage subscribe() {
        getSubscriptionButton().click();
        return this;
    }
}
