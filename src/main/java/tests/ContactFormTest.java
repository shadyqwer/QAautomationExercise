package tests;

import data.TestDataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactFormTest extends BaseTest {

    @BeforeMethod
    public void beforeEachTest() {
        getIndexPage().open();
    }

    @Test(testName = "Test Case 6: Contact Us Form")
    public void verifyContactUsForm() {
        getNavigationPage().getContactUsButton().click();

        getSoftAssert().assertTrue(getContactUsPage().getInTouchVisible(), "GET IN TOUCH not visible");

        getContactUsPage().enterName(getFaker().name().fullName())
                .enterEmail(getFaker().internet().emailAddress())
                .enterSubject(getFaker().lorem().sentence())
                .enterMessage(getFaker().lorem().paragraph())
                .addFile(TestDataProviders.sampleFile())
                .pressSubmit()
                .acceptAlert();

        getSoftAssert().assertTrue(getContactUsPage().verifyMessageSuccess(), "Success message not visible");

        getNavigationPage().getHomeButton().click();
        getSoftAssert().assertTrue(getDriver().getCurrentUrl().equals(getBasePage().homeUrl()),
                "ERROR: Not landed on home page.");
        getSoftAssert().assertAll();
    }
}
