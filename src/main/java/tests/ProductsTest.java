package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @BeforeClass
    public void beforeEachTest() {
        getIndexPage().open();
    }

    @Test(testName = "Test Case 8: Verify All Products and product detail page")
    public void verifyAllProductsAndProductDetailPage() {
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Automation Exercise"),
                "Home page not visible successfully.");
        getNavigationPage().openAllProducts();

        getSoftAssert().assertTrue(getAllProductsPage().getCategoryText().getText().equals("ALL PRODUCTS"));

        getSoftAssert().assertTrue(getDriver().getTitle().contains("All Products"),
                "All products page not visible successfully.");
        getSoftAssert().assertFalse(getAllProductsPage().getAllProducts().isEmpty(),
                "Product list is not visible.");

        getAllProductsPage().viewProductByIndex(0);
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Product Details"));
        getSoftAssert().assertTrue(getSingleProductPage().getProductDetails().isDisplayed());
        getSoftAssert().assertAll();
    }
}
