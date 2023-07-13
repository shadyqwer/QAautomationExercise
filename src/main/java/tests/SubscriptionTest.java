package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SubscriptionTest extends BaseTest {

    @BeforeClass
    public void beforeEachTest() {
        getIndexPage().open();
    }

    @Test(testName = "Test Case 10: Verify Subscription in home page")
    public void verifySubscriptionInHomePage() {
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Automation Exercise"),
                "Home page not visible successfully.");
        String email = getFaker().internet().emailAddress();
        getNavigationPage().scrollDownToFooter()
                .enterSubscriptionEmail(email)
                .subscribe();
        getSoftAssert().assertTrue(getNavigationPage().getSuccessSubscription().isDisplayed());
        getSoftAssert().assertAll();
    }

    @Test(testName = "Test Case 11: Verify Subscription in Cart page")
    public void verifySubscriptionInCartPage() {
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Automation Exercise"),
                "Home page not visible successfully.");
        getNavigationPage().openCart();

        String email = getFaker().internet().emailAddress();
        getNavigationPage().scrollDownToFooter()
                .enterSubscriptionEmail(email)
                .subscribe();
        getSoftAssert().assertTrue(getNavigationPage().getSuccessSubscription().isDisplayed());
        getSoftAssert().assertAll();
    }
}
