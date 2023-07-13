package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(testName = "Test Case 9: Search Product")
    public void verifySearchWorks() {
        getIndexPage().open();
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Automation Exercise"),
                "Home page not visible successfully.");

        getNavigationPage().openAllProducts();
        getSoftAssert().assertTrue(getAllProductsPage().getCategoryText().getText().equals("ALL PRODUCTS"));

        String searchText = "top";
        getAllProductsPage().enterSearchText(searchText)
                            .searchProducts();

        getSoftAssert().assertTrue(getAllProductsPage().checkSuccessfulSearch(searchText));
        getSoftAssert().assertAll();

    }
}
