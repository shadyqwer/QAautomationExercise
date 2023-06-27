package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage extends BasePage {
    private WebElement signupLoginButton;
    private WebElement loggedInAs;
    private WebElement deleteAccount;
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

    public String loggedInUsername() {
        return getLoggedInAs().findElement(By.xpath("./..")).getText();
    }
}
