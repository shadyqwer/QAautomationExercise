package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupLoginPage extends IndexPage {
    private WebElement loginEmailField;
    private WebElement loginPasswordField;
    private WebElement loginButton;
    private WebElement signupNameField;
    private WebElement signupEmailField;
    private WebElement signupButton;
    private WebElement newUserSignUpText;

    public SignupLoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLoginEmailField() {
        loginEmailField = getDriver().findElement(By.xpath("//input[@data-qa='login-email']"));
        return loginEmailField;
    }

    public WebElement getLoginPasswordField() {
        loginPasswordField = getDriver().findElement(By.xpath("//input[@data-qa='login-password']"));
        return loginPasswordField;
    }

    public WebElement getLoginButton() {
        loginButton = getDriver().findElement(By.xpath("//button[@data-qa='login-button']"));
        return loginButton;
    }

    public WebElement getSignupNameField() {
        signupNameField = getDriver().findElement(By.xpath("//input[@data-qa='signup-name']"));
        return signupNameField;
    }

    public WebElement getSignupEmailField() {
        signupEmailField = getDriver().findElement(By.xpath("//input[@data-qa='signup-email']"));
        return signupEmailField;
    }

    public WebElement getSignupButton() {
        signupButton = getDriver().findElement(By.xpath("//button[@data-qa='signup-button']"));
        return signupButton;
    }

    public WebElement getNewUserSignUpText() {
        newUserSignUpText = getDriver().findElement(By.xpath("//h2[text() ='New User Signup!']"));
        return newUserSignUpText;
    }

    public SignupLoginPage enterLoginEmail(String text) {
        getLoginEmailField().sendKeys(text);
        return this;
    }

    public SignupLoginPage enterLoginPassword(String text) {
        getLoginPasswordField().sendKeys(text);
        return this;
    }

    public SignupLoginPage enterSignupName(String text) {
        getSignupNameField().sendKeys(text);
        return this;
    }

    public SignupLoginPage enterSignupEmail(String text) {
        getSignupEmailField().sendKeys(text);
        return this;
    }

    public void login() {
        getLoginButton().click();
    }

    public void signup() {
        getSignupButton().click();
    }
}
