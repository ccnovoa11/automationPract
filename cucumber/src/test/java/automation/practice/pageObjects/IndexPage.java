package automation.practice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    By womenOption = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a");
    By blousesOption = By.linkText("Blouses");
    By signInOption = By.linkText("Sign in");

    public IndexPage(WebDriver driver, Actions actions) {
        this.actions = actions;
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //
    //Click actions
    //

    public void clickOnSignIn(){
        wait.until(ExpectedConditions.elementToBeClickable(signInOption)).click();
    }

    public void clickOnBlousesHover(){
        actions.moveToElement(driver.findElement(womenOption)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(blousesOption)).click();
    }

    public void clickOnWomen(){
        driver.findElement(womenOption).click();
    }
}
