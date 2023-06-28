package tests;

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

        creatNewAccount(password);

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
}
