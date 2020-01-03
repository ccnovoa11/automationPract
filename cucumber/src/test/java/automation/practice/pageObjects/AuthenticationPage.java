package automation.practice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {
    WebDriver driver;
    WebDriverWait wait;

    //Create account
    By createEmailInput = By.id("email_create");
    By createAccountButton = By.id("SubmitCreate");

    //Sign in
    By signInEmailInput = By.id("email");
    By signInPasswordInput = By.id("passwd");
    By signInButton =  By.id("SubmitLogin");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //
    //Sign up scenarios
    //
    public void createAccount(){
        wait.until(ExpectedConditions.presenceOfElementLocated(createEmailInput)).sendKeys("cyclo@rama.com");
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }

    //
    //Sign in scenarios
    //

    public void emailRequired(){
        wait.until(ExpectedConditions.presenceOfElementLocated(signInPasswordInput)).sendKeys("qwerty");
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();

        System.out.println(driver.findElement(By.xpath("//*[text()='An email address required.']")).getText());

    }

    public void invalidEmailAddress(){
        wait.until(ExpectedConditions.presenceOfElementLocated(signInEmailInput)).sendKeys("hello hello hello");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInPasswordInput)).sendKeys("qwerty");
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();

        System.out.println(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).getText());
    }

    public void invalidPassword(){
        wait.until(ExpectedConditions.presenceOfElementLocated(signInEmailInput)).sendKeys("a@a.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInPasswordInput)).sendKeys("1");
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();

        System.out.println(driver.findElement(By.xpath("//*[text()='Invalid password.']")).getText());
    }

    public void authenticationFailed(){
        wait.until(ExpectedConditions.presenceOfElementLocated(signInEmailInput)).sendKeys("hellohello@jaja.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInPasswordInput)).sendKeys("qwerty");
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();

        System.out.println(driver.findElement(By.xpath("//*[text()='Authentication failed.']")).getText());
    }

}
