package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertions {
    //Create class:Assertions
    //Copy and paste the last code i sent
    WebDriver driver;
    @Before
    public void setUp(){
//@Before method is not a test method. It is just a set up method
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

    }

    @Test
    public void titleTest(){

        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        //Assert class is coming from JUnit
        //assertEquals(); takes two string and checks if they are equal
        //It will fail if the two string is not equal
        //We are comparing if two strings are equal
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    public void imageTest(){
        WebElement googleImage=driver.findElement(By.id("hplogo"));
        //user Assertion to check if googleImage is displayed
        //We are not comparing two string. We don't have epected and actual
        //We just want to check True or False contition
        Assert.assertTrue(googleImage.isDisplayed());
        //We are expecting True. So we are using assertTrue
        //This will pass if the googleImage.isDisplayed() is True. It will fail if the googleImage.isDisplayed() is False
        //Assert.assertFalse(googleImage.isDisplayed());
        //We are expecting a False Statement. If googleImage.isDisplayed() is false the this will PASS
        //If googleImage.isDisplayed() is true, then this will FAIL
    }

    @Test
    public void gmailLinkTest(){

        WebElement gmailElement=driver.findElement(By.linkText("Gmail"));
        //user assertion to assert if gmail element is diplayed or not. Remove if else statement
         Assert.assertTrue(gmailElement.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
