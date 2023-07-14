package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @BeforeMethod
    public void beforeEachTest() {
        getIndexPage().open();
    }

    @Test(testName = "Test Case 12: Add Products in Cart")
    public void verifyProductCanBeAddedToCart() {
        getSoftAssert().assertTrue(getDriver().getTitle().contains("Automation Exercise"),
                "Home page not visible successfully.");

        getNavigationPage().openAllProducts();

        double totalPrice = 0;
        totalPrice += getAllProductsPage().getProductPrice(0);
        totalPrice += getAllProductsPage().getProductPrice(1);

        getAllProductsPage()
                .hoverOverProduct(0)
                .addProductToCart(0)
                .continueShopping()
                .hoverOverProduct(1)
                .addProductToCart(1)
                .viewCart();

        getSoftAssert().assertEquals(totalPrice, getCartPage().getCartTotal(), "Total price is wrong");
        getSoftAssert().assertEquals(2, getCartPage().productsQuantity(), "Quantity does not match");
        getSoftAssert().assertAll();
    }
}
