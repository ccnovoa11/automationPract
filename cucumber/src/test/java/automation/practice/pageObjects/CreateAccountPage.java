package automation.practice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

    //Personal Info

    By checkMale = By.id("id_gender1");
    By checkFemale = By.id("id_gender2");

    By firstNameLbl = By.id("customer_firstname");
    By lastNameLbl = By.id("customer_lastname");
    By passwordLbl = By.id("passwd");
    By selectDay = By.id("days");
    By selectMonth = By.id("months");
    By selectYear = By.id("years");

    //
    By addressFirstNameLbl = By.id("firstname");
    By addressLastNameLbl = By.id("lastname");
    By companyLbl = By.id("company");
    By address1Lbl = By.id("address1");
    By address2Lbl = By.id("address2");
    By cityLbl = By.id("city");
    By selectState = By.id("id_state");
    By zipPostalCode = By.id("postcode");
    By countrySelect = By.id("uniform-id_country");



    By registerButton = By.id("submitAccount");


    WebDriver driver;
    WebDriverWait wait;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void fillForm(){
        //Personal Info
        wait.until(ExpectedConditions.elementToBeClickable(checkMale)).click();
        driver.findElement(firstNameLbl).sendKeys("Ajelandro");
        driver.findElement(lastNameLbl).sendKeys("Manco");
        driver.findElement(passwordLbl).sendKeys("qwertyuiop");
        Select days = new Select(driver.findElement(selectDay));
        Select months = new Select(driver.findElement(selectMonth));
        Select years = new Select(driver.findElement(selectYear));
        days.selectByIndex(5);
        months.selectByIndex(11);
        years.selectByValue("1991");

        //Address
        driver.findElement(companyLbl).sendKeys("Vincent Company");
        driver.findElement(address1Lbl).sendKeys("Street 123 F men, ella no te ama");
        driver.findElement(address2Lbl).sendKeys("Building Luna - apartment 'Ur mom'");
        driver.findElement(cityLbl).sendKeys("Magnolia");
        new Select((driver.findElement(selectState))).selectByIndex(7);
        driver.findElement(zipPostalCode).sendKeys("sasasa");

        driver.findElement(registerButton).click();
    }
}
