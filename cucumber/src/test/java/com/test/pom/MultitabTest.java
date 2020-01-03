package com.test.pom;

import com.object.pom.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MultitabTest {

    private WebDriver driver;

    HomePage home;
    BrowseJobs jobs;
    JobsInPlace jobsPlace;


    String places[] = {"Mumbai","Delhi","Bangalore","Hyderabad-secunderabad","Chennai"};
    Set<String> windows;
    ArrayList<String> ids;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com/");
    }

    @Test
    public void test() {
        Random rm = new Random();
        String place = places[rm.nextInt(5)];
        updateWindows();
        closeWindows();

        driver.switchTo().window(ids.get(0));
        home = new HomePage(driver);
        home.clickOnJobs();

        updateWindows();

        driver.switchTo().window(ids.get(1));
        jobs = new BrowseJobs(driver);
        jobs.click(place);

        updateWindows();
        driver.switchTo().window(ids.get(2));
        jobsPlace = new JobsInPlace(driver, place);

        assertEquals(place, jobsPlace.getPlace());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    public void updateWindows() {
        windows = driver.getWindowHandles();
        ids = new ArrayList<String>(windows);
    }

    public void closeWindows() {
        for (String string : windows) {
            driver.switchTo().window(string);
            System.out.println(driver.getTitle());
            if (driver.getTitle().equalsIgnoreCase("LnT")
                    || driver.getTitle().equals("Cognizant")
                    || driver.getTitle().equals("Larsen & Toubro Infotech Limited")
                    || driver.getTitle().equalsIgnoreCase("Tech Mahindra")
                    || driver.getTitle().equalsIgnoreCase("Xoriant")) {
                driver.close();
            }
        }

        updateWindows();
    }
}
