package automation.practice.test;

import automation.practice.pageObjects.AuthenticationPage;
import automation.practice.pageObjects.CategoryCatalogPage;
import automation.practice.pageObjects.CreateAccountPage;
import automation.practice.pageObjects.IndexPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SignInUpTest {

    private WebDriver driver;
    private Actions action;

    private IndexPage indexPage;
    private CategoryCatalogPage blousesCatalogPage;
    private CreateAccountPage createAccountPage;
    private AuthenticationPage authenticationPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        action = new Actions(driver);
    }

//    @Test
//    public void test() {
//        indexPage = new IndexPage(this.driver, this.action);
//        indexPage.clickOnWomen();
////        indexPage.clickOnBlousesHover();
//
//        blousesCatalogPage = new CategoryCatalogPage(this.driver, this.action);
//        blousesCatalogPage.getCategoryName();
//        System.out.println("Products count: "+ blousesCatalogPage.getProducts().size());
//        blousesCatalogPage.hasAddCard();
//    }

    @Test
    public void createAccount(){
        indexPage = new IndexPage(this.driver, this.action);
        indexPage.clickOnSignIn();

        authenticationPage = new AuthenticationPage(this.driver);
        authenticationPage.createAccount();

        createAccountPage = new CreateAccountPage(this.driver);
        createAccountPage.fillForm();
    }

//    @Test
//    public void invalidPasswordTest(){
//        indexPage = new IndexPage(this.driver, this.action);
//        indexPage.clickOnSignIn();
//
//        authenticationPage = new AuthenticationPage(this.driver);
//        authenticationPage.invalidPassword();
//    }
//
//    @Test
//    public void invalidEmailTest(){
//        indexPage = new IndexPage(this.driver, this.action);
//        indexPage.clickOnSignIn();
//
//        authenticationPage = new AuthenticationPage(this.driver);
//        authenticationPage.invalidEmailAddress();
//    }
//
//    @Test
//    public void authenticationFailedTest(){
//        indexPage = new IndexPage(this.driver, this.action);
//        indexPage.clickOnSignIn();
//
//        authenticationPage = new AuthenticationPage(this.driver);
//        authenticationPage.authenticationFailed();
//    }
//
//    @Test
//    public void emailRequiredTest(){
//        indexPage = new IndexPage(this.driver, this.action);
//        indexPage.clickOnSignIn();
//
//        authenticationPage = new AuthenticationPage(this.driver);
//        authenticationPage.emailRequired();
//    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}

