package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletedAccountPage extends SignupPage {
    private WebElement accountDeletedText;
    private WebElement continueButton;
    public DeletedAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAccountDeletedText() {
        accountDeletedText = getDriver().findElement(By.xpath("//h2[@data-qa='account-deleted']"));
        return accountDeletedText;
    }

    public WebElement getContinueButton() {
        continueButton = getDriver().findElement(By.className("btn-primary"));
        return continueButton;
    }

    public boolean successfullyDeleted() {
        return getAccountDeletedText().isDisplayed();
    }
}
