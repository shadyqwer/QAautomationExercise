package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCasesTest extends BaseTest {
    @BeforeMethod
    public void beforeEachTest() {
        getIndexPage().open();
    }

    @Test
    public void verifyTestCasesPage() {
        getNavigationPage().openTestCases();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/test_cases"));
    }
}
