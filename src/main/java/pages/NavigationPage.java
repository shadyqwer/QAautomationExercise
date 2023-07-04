package pages;

import org.openqa.selenium.By;
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
}
