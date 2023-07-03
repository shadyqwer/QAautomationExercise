package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends IndexPage {

    private WebElement nameField;
    private WebElement emailField;
    private WebElement subjectField;
    private WebElement messageField;
    private WebElement addFileInput;
    private WebElement submitButton;
    private WebElement successMessageNotification;
    private WebElement getInTouchText;

    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameField() {
        nameField = getDriver().findElement(By.name("name"));
        return nameField;
    }

    public WebElement getEmailField() {
        emailField = getDriver().findElement(By.name("email"));
        return emailField;
    }

    public WebElement getSubjectField() {
        subjectField = getDriver().findElement(By.name("subject"));
        return subjectField;
    }

    public WebElement getMessageField() {
        messageField = getDriver().findElement(By.name("message"));
        return messageField;
    }

    public WebElement getAddFileInput() {
        addFileInput = getDriver().findElement(By.name("upload_file"));
        return addFileInput;
    }

    public WebElement getSubmitButton() {
        submitButton = getDriver().findElement(By.name("submit"));
        return submitButton;
    }

    public WebElement getSuccessMessageNotification() {
        successMessageNotification = getDriver().findElement(By.cssSelector(".status.alert.alert-success"));
        return successMessageNotification;
    }

    public WebElement getGetInTouchText() {
        getInTouchText = getDriver().findElement(By.xpath("//h2[text()='Get In Touch']"));
        return getInTouchText;
    }

    public ContactUsPage enterName(String name) {
        getNameField().sendKeys(name);
        return this;
    }

    public ContactUsPage enterEmail(String email) {
        getEmailField().sendKeys(email);
        return this;
    }

    public ContactUsPage enterSubject(String subject) {
        getSubjectField().sendKeys(subject);
        return this;
    }

    public ContactUsPage enterMessage(String message) {
        getMessageField().sendKeys(message);
        return this;
    }

    public ContactUsPage addFile(String filePath) {
        getAddFileInput().sendKeys(filePath);
        return this;
    }

    public ContactUsPage pressSubmit() {
        getSubmitButton().click();
        return this;
    }

    public ContactUsPage acceptAlert() {
        getDriver().switchTo().alert().accept();
        return this;
    }

    public boolean getInTouchVisible() {
        return getGetInTouchText().isDisplayed();
    }

    public boolean verifyMessageSuccess() {
        return getSuccessMessageNotification().isDisplayed() &&
                getSuccessMessageNotification().getText().contains("Success!");
    }
}
