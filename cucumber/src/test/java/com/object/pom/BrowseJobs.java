package com.object.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowseJobs {

    WebDriver driver;

    By mumbai = By.className("mum");
    By delhi = By.className("del");
    By bangalore = By.className("ban");
    By hyderabad = By.className("hyd");
    By chennai = By.className("chen");


    public BrowseJobs(WebDriver driver) {
        this.driver = driver;
    }

    public void click(String place) {
        switch (place) {
            case "Mumbai":
                driver.findElement(mumbai).click();
                break;
            case "Delhi":
                driver.findElement(delhi).click();
                break;
            case "Bangalore":
                driver.findElement(bangalore).click();
                break;
            case "Hyderabad-secunderabad":
                driver.findElement(hyderabad).click();
                break;
            case "Chennai":
                driver.findElement(chennai).click();
                break;
            default:
                break;
        }
    }
}
