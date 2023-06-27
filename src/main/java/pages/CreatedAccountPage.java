package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatedAccountPage extends SignupPage {
    private WebElement continueButton;
    private WebElement accountCreatedText;
    public CreatedAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getContinueButton() {
        continueButton = getDriver().findElement(By.className("btn-primary"));
        return continueButton;
    }

    public WebElement getAccountCreatedText() {
        accountCreatedText = getDriver().findElement(By.xpath("//h2[@data-qa='account-created']"));
        return accountCreatedText;
    }

    public boolean successfullyCreated() {
        return getAccountCreatedText().isDisplayed();
    }
}
