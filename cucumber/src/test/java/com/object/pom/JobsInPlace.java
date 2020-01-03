package com.object.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobsInPlace {
    WebDriver driver;
    String place;

    By placeName = By.className("scnd");

    public JobsInPlace(WebDriver driver, String place) {
        this.place = place;
        this.driver = driver;
    }

    public String getPlace() {
        return driver.findElement(placeName).getText();
    }
}
