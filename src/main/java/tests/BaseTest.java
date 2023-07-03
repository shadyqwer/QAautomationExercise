package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;
    private Faker faker;
    private BasePage basePage;
    private IndexPage indexPage;
    private NavigationPage navigationPage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;
    private CreatedAccountPage createdAccountPage;
    private DeletedAccountPage deletedAccountPage;
    private ContactUsPage contactUsPage;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }

    public Faker getFaker() {
        return faker;
    }

    public BasePage getBasePage() {
        return basePage;
    }

    public IndexPage getIndexPage() {
        return indexPage;
    }

    public NavigationPage getNavigationPage() {
        return navigationPage;
    }

    public SignupLoginPage getSignupLoginPage() {
        return signupLoginPage;
    }

    public SignupPage getSignupPage() {
        return signupPage;
    }

    public CreatedAccountPage getCreatedAccountPage() {
        return createdAccountPage;
    }

    public DeletedAccountPage getDeletedAccountPage() {
        return deletedAccountPage;
    }

    public ContactUsPage getContactUsPage() {
        return contactUsPage;
    }

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        faker = new Faker();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        basePage = new BasePage(driver, wait);
        indexPage = new IndexPage(driver, wait);
        navigationPage = new NavigationPage(driver, wait);
        signupLoginPage = new SignupLoginPage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        createdAccountPage = new CreatedAccountPage(driver, wait);
        deletedAccountPage = new DeletedAccountPage(driver, wait);
        contactUsPage = new ContactUsPage(driver, wait);
    }

    @AfterClass
    public void cleanUp() {
        List<String> allOpenedTabs = new ArrayList<>(driver.getWindowHandles());
        for (String tab : allOpenedTabs) {
            driver.switchTo().window(tab);
            driver.close();
        }
    }
}
