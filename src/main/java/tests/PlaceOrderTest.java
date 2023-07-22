package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseTest {

    @BeforeMethod
    public void beforeEachTest() {
        getIndexPage().open();
    }

    @Test(testName = "Test Case 14: Place Order: Register while Checkout")
    public void verifyPlaceOrderRegisterWhileCheckout() {
        getNavigationPage().openAllProducts();
        getAllProductsPage()
                .addProductToCart(1)
                .viewCart();

        getNavigationPage().openSignupLoginPage();
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

        getNavigationPage().openCart();

        getCartPage().proceedToCheckout();

        getCheckoutPage()
                .enterComment(getFaker().lorem().sentence())
                .placeOrder();

        getPaymentPage()
                .enterNameOnCart(getFaker().name().fullName())
                .enterCardNumber(getFaker().finance().creditCard())
                .enterCVC("123")
                .enterExpirationMonth("12")
                .enterExpirationYear("2030")
                .payAndConfirmOrder();


        getSoftAssert().assertTrue(getDriver().getCurrentUrl().contains("payment_done"));
        getSoftAssert().assertAll();

        getNavigationPage().deleteUser();
    }

    @Test(testName = "Test Case 15: Place Order: Register before Checkout")
    public void verifyPlaceOrderRegisterBeforeCheckout() {
        getNavigationPage().openSignupLoginPage();
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

        getNavigationPage().openAllProducts();
        getAllProductsPage()
                .addProductToCart(1)
                .viewCart();

        getCartPage().proceedToCheckout();

        getCheckoutPage()
                .enterComment(getFaker().lorem().sentence())
                .placeOrder();

        getPaymentPage()
                .enterNameOnCart(getFaker().name().fullName())
                .enterCardNumber(getFaker().finance().creditCard())
                .enterCVC("123")
                .enterExpirationMonth("12")
                .enterExpirationYear("2030")
                .payAndConfirmOrder();


        getSoftAssert().assertTrue(getDriver().getCurrentUrl().contains("payment_done"));
        getSoftAssert().assertAll();

        getNavigationPage().deleteUser();
    }

    @Test(testName = "Test Case 16: Place Order: Login before Checkout")
    public void verifyPlaceOrderLoginBeforeCheckout() {
        getIndexPage().goToSignupLogin();

        String username = getFaker().name().username();
        String password = getFaker().internet().password();
        String email = getFaker().internet().emailAddress();

        getSignupLoginPage().enterSignupName(username);
        getSignupLoginPage().enterSignupEmail(email);
        getSignupLoginPage().signup();

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

        getNavigationPage().openAllProducts();
        getAllProductsPage()
                .addProductToCart(1)
                .viewCart();

        getCartPage().proceedToCheckout();

        getCheckoutPage()
                .enterComment(getFaker().lorem().sentence())
                .placeOrder();

        getPaymentPage()
                .enterNameOnCart(getFaker().name().fullName())
                .enterCardNumber(getFaker().finance().creditCard())
                .enterCVC("123")
                .enterExpirationMonth("12")
                .enterExpirationYear("2030")
                .payAndConfirmOrder();


        getSoftAssert().assertTrue(getDriver().getCurrentUrl().contains("payment_done"));
        getSoftAssert().assertAll();

        getNavigationPage().deleteUser();
    }

    @Test(testName = "Test Case 17: Remove Products From Cart")
    public void verifyRemoveProductsFromCart() {
        getNavigationPage().openAllProducts();
        getAllProductsPage()
                .addProductToCart(1)
                .continueShopping()
                .addProductToCart(2)
                .viewCart();

        getCartPage().removeAllProducts();
        Assert.assertFalse(getCartPage().getEmptyCartField().isDisplayed());
    }
}
