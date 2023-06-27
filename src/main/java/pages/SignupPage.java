package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends SignupLoginPage {
    private WebElement enterAccountInfoText;
    private WebElement titleMr;
    private WebElement titleMrs;
    private WebElement nameField;
    private WebElement emailField;
    private WebElement passwordField;
    private Select dayBirth;
    private Select monthBirth;
    private Select yearBirth;
    private WebElement signUpForNewsletterCheck;
    private WebElement receiveOffersCheck;
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement companyField;
    private WebElement addressField;
    private WebElement addressTwoField;
    private Select countrySelect;
    private WebElement stateField;
    private WebElement cityField;
    private WebElement zipcodeField;
    private WebElement mobileNumberField;
    private WebElement createAccountButton;
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEnterAccountInfoText() {
        enterAccountInfoText = getDriver().findElement(By.xpath("//h2[contains(., 'Enter Account Information')]"));
        return enterAccountInfoText;
    }

    public WebElement getTitleMr() {
        titleMr = getDriver().findElement(By.id("uniform-id_gender1"));
        return titleMr;
    }

    public WebElement getTitleMrs() {
        titleMrs = getDriver().findElement(By.id("uniform-id_gender2"));
        return titleMrs;
    }

    public WebElement getNameField() {
        nameField = getDriver().findElement(By.id("name"));
        return nameField;
    }

    public WebElement getEmailField() {
        emailField = getDriver().findElement(By.id("email"));
        return emailField;
    }

    public WebElement getPasswordField() {
        passwordField = getDriver().findElement(By.id("password"));
        return passwordField;
    }

    public Select getDayBirth() {
        dayBirth = new Select(getDriver().findElement(By.id("days")));
        return dayBirth;
    }

    public Select getMonthBirth() {
        monthBirth = new Select(getDriver().findElement(By.id("months")));
        return monthBirth;
    }

    public Select getYearBirth() {
        yearBirth = new Select(getDriver().findElement(By.id("years")));
        return yearBirth;
    }

    public WebElement getSignUpForNewsletterCheck() {
        signUpForNewsletterCheck = getDriver().findElement(By.id("newsletter"));
        return signUpForNewsletterCheck;
    }

    public WebElement getReceiveOffersCheck() {
        receiveOffersCheck = getDriver().findElement(By.id("optin"));
        return receiveOffersCheck;
    }

    public WebElement getFirstNameField() {
        firstNameField = getDriver().findElement(By.id("first_name"));
        return firstNameField;
    }

    public WebElement getLastNameField() {
        lastNameField = getDriver().findElement(By.id("last_name"));
        return lastNameField;
    }

    public WebElement getCompanyField() {
        companyField = getDriver().findElement(By.id("company"));
        return companyField;
    }

    public WebElement getAddressField() {
        addressField = getDriver().findElement(By.id("address1"));
        return addressField;
    }

    public WebElement getAddressTwoField() {
        addressTwoField = getDriver().findElement(By.id("address2"));
        return addressTwoField;
    }

    public Select getCountrySelect() {
        countrySelect = new Select(getDriver().findElement(By.id("country")));
        return countrySelect;
    }

    public WebElement getStateField() {
        stateField = getDriver().findElement(By.id("state"));
        return stateField;
    }

    public WebElement getCityField() {
        cityField = getDriver().findElement(By.id("city"));
        return cityField;
    }

    public WebElement getZipcodeField() {
        zipcodeField = getDriver().findElement(By.id("zipcode"));
        return zipcodeField;
    }

    public WebElement getMobileNumberField() {
        mobileNumberField = getDriver().findElement(By.id("mobile_number"));
        return mobileNumberField;
    }

    public WebElement getCreateAccountButton() {
        createAccountButton = getDriver().findElement(By.xpath("//button[@data-qa='create-account']"));
        return createAccountButton;
    }
}
