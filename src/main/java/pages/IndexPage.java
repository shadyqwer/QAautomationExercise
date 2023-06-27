package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage extends BasePage {
    private WebElement signupLoginButton;

    public IndexPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSignupLoginButton() {
        signupLoginButton = getDriver().findElement(By.xpath("//li[contains(., 'Signup / Login')]"));
        return signupLoginButton;
    }

    public IndexPage open() {
        getDriver().get(homeUrl());
        return this;
    }

    public IndexPage goToSignupLogin() {
        getSignupLoginButton().click();
        return this;
    }
}
