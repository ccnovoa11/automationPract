package com.object.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By jobs = By.className("mTxt");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnJobs() {
        driver.findElement(jobs).click();
    }
}