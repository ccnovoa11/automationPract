package automation.practice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryCatalogPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    List <WebElement> products;

    By listItem = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li");
    By pageTitle = By.className("category-name");
    By continueShopping = By.cssSelector("span[title='Continue shopping']");
    By proceedToCheckout = By.cssSelector("a[title='Proceed to checkout']");

    public CategoryCatalogPage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
        wait = new WebDriverWait(driver, 10);
    }

    public void hasAddCard()  {
        if (products.size()==1){
            buyOneItem();
        } else{
            buyTwoItems();
        }
    }

    //
    //Utilities
    //

    public int countProducts(List products){
        return products.size();
    }

    //
    //Get products and confirm catalog page
    //

    public String getCategoryName(){
        String title = wait.until(ExpectedConditions.elementToBeClickable(pageTitle)).getText();
        return title;
    }

    public List getProducts(){
        products = driver.findElements(listItem);
        return products;
    }

    //
    //Actions
    //

    public void clickAddToCart(int number){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li["+number+"]/div/div[2]/div[2]/a[1]"))).click();
    }

    public void clickProceedToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
    }

    public void clickContinueShopping(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping)).click();
    }

    //
    //Flows
    //

    //One item
    public void buyOneItem(){
        actions.moveToElement(products.get(0)).build().perform();
        System.out.println(products.get(0).getText());
        clickAddToCart(1);
        clickProceedToCheckout();
    }

    //Two items
    public void buyTwoItems(){
        actions.moveToElement(products.get(0)).build().perform();
        System.out.println(products.get(0).getText());
        clickAddToCart(1);
        clickContinueShopping();
        actions.moveToElement(products.get(products.size()-1)).build().perform();
        System.out.println(products.get(products.size()-1).getText());
        clickAddToCart(products.size());
        clickProceedToCheckout();
    }
}