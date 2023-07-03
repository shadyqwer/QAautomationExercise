package tests;

import data.TestDataProviders;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test(testName = "Test Case 1: Register User")
    public void verityUserCanRegister() {
        getIndexPage().open();
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Automation Exercise"),
                "Home page not visible successfully.");

        getIndexPage().goToSignupLogin();
        getSoftAssert().assertTrue(getSignupLoginPage().getNewUserSignUpText().isDisplayed(),
                "New User Signup! not visible.");

        String username = getFaker().name().username();
        String password = getFaker().internet().password();
        String email = getFaker().internet().emailAddress();

        getSignupLoginPage().enterSignupName(username);
        getSignupLoginPage().enterSignupEmail(email);
        getSignupLoginPage().signup();
        getSoftAssert().assertTrue(getSignupPage().getEnterAccountInfoText().isDisplayed(),
                "ENTER ACCOUNT INFORMATION not visible.");

        getSignupPage().getTitleMr().click();
        getSignupPage().getPasswordField().sendKeys(password);
        getSignupPage().getDayBirth().selectByValue("13");
        getSignupPage().getMonthBirth().selectByValue("1");
        getSignupPage().getYearBirth().selectByValue("1995");
        getSignupPage().getSignUpForNewsletterCheck().click();
        getSignupPage().getReceiveOffersCheck().click();
        getSignupPage().getFirstNameField().sendKeys(getFaker().name().firstName());
        getSignupPage().getLastNameField().sendKeys(getFaker().name().lastName());
        getSignupPage().getCompanyField().sendKeys(getFaker().company().name());
        getSignupPage().getAddressField().sendKeys(getFaker().address().fullAddress());
        getSignupPage().getAddressTwoField().sendKeys(getFaker().address().fullAddress());
        getSignupPage().getCountrySelect().selectByIndex(1);
        getSignupPage().getStateField().sendKeys(getFaker().address().state());
        getSignupPage().getCityField().sendKeys(getFaker().address().city());
        getSignupPage().getZipcodeField().sendKeys(getFaker().address().zipCode());
        getSignupPage().getMobileNumberField().sendKeys(getFaker().phoneNumber().phoneNumber());
        getSignupPage().getCreateAccountButton().click();

        getSoftAssert().assertTrue(getCreatedAccountPage().successfullyCreated(),
                "ACCOUNT CREATED not visible.");
        getCreatedAccountPage().getContinueButton().click();

        getSoftAssert().assertTrue(getNavigationPage().loggedInUsername().contains(username),
                "Logged in as (username) not visible.");
        getNavigationPage().getDeleteAccount().click();

        getSoftAssert().assertTrue(getDeletedAccountPage().successfullyDeleted(),
                "ACCOUNT DELETED! not visible.");
        getDeletedAccountPage().getContinueButton().click();

        getSoftAssert().assertAll();
    }

    @Test(testName = "Test Case 5: Register User with existing email",
            dataProvider = "existingEmail", dataProviderClass = TestDataProviders.class)
    public void verifyUserCanNotRegisterWithExistingEmail(String email) {
        getIndexPage().open();
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Automation Exercise"),
                "Home page not visible successfully.");

        getIndexPage().goToSignupLogin();
        getSoftAssert().assertTrue(getSignupLoginPage().getNewUserSignUpText().isDisplayed(),
                "New User Signup! not visible.");

        getSignupLoginPage().enterSignupName(getFaker().name().username());
        getSignupLoginPage().enterSignupEmail(email);
        getSignupLoginPage().signup();
        getSoftAssert().assertTrue(getSignupLoginPage().getEmailAlreadyExist().isDisplayed());

        getSoftAssert().assertAll();
    }
}
