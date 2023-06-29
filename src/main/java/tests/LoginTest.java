package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(testName = "Test Case 2: Login User with correct email and password")
    public void verifyLoginWithCorrectEmailAndPassword() {
        getIndexPage().open();
        getIndexPage().goToSignupLogin();

        String username = getFaker().name().username();
        String password = getFaker().internet().password();
        String email = getFaker().internet().emailAddress();

        getSignupLoginPage().enterSignupName(username);
        getSignupLoginPage().enterSignupEmail(email);
        getSignupLoginPage().signup();

        creatNewAccount(password);

        getCreatedAccountPage().getContinueButton().click();
        getNavigationPage().getLogoutButton().click();

        getNavigationPage().getHomeButton().click();
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Automation Exercise"),
                "Home page not visible successfully.");

        getNavigationPage().getSignupLoginButton().click();
        getSoftAssert().assertTrue(getSignupLoginPage().getLoginToYouAccountText().isDisplayed(),
                "Login to your account not visible.");

        getSignupLoginPage().enterLoginEmail(email);
        getSignupLoginPage().enterLoginPassword(password);
        getSignupLoginPage().login();
        getSoftAssert().assertTrue(getNavigationPage().loggedInUsername().contains(username),
                "Logged in as (username) not visible.");

        getNavigationPage().deleteUser();
        getSoftAssert().assertTrue(getDeletedAccountPage().successfullyDeleted(),
                "ACCOUNT DELETED! not visible.");

        getSoftAssert().assertAll();
    }

    @Test(testName = "Test Case 3: Login User with incorrect email and password")
    public void verifyLoginWithIncorrectEmailAndPassword() {
        getIndexPage().open();
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Automation Exercise"),
                "Home page not visible successfully.");

        getNavigationPage().getSignupLoginButton().click();
        getSoftAssert().assertTrue(getSignupLoginPage().getLoginToYouAccountText().isDisplayed(),
                "Login to your account not visible.");

        getSignupLoginPage().enterLoginEmail(getFaker().internet().emailAddress());
        getSignupLoginPage().enterLoginPassword(getFaker().internet().password());
        getSignupLoginPage().login();
        getSoftAssert().assertTrue(getSignupLoginPage().getIncorrectEmailPassword().isDisplayed(),
                "Your email or password is incorrect! not visible");

        getSoftAssert().assertAll();
    }
}
