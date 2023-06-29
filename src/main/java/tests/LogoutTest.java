package tests;

import data.TestDataProviders;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test (testName = "Test Case 4: Logout User", dataProvider = "validUser", dataProviderClass = TestDataProviders.class)
    public void verifyUserCanLogout(String username, String email, String password) {
        getIndexPage().open();
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

        getNavigationPage().logoutUser();
        getSoftAssert().assertTrue(getDriver().getCurrentUrl().contains("/login"));

        getSoftAssert().assertAll();
    }
}
