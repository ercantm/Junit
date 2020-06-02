package com.techproed;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BeforeAndAfterMethods {
    WebDriver driver;
    @Before
    public void setUp(){
        //=we use @Before for repeated pre conditions,
        //Before method is used to setup the driver, or open the browser, or go to URL
        //We avoid repetitions using @Before and @After methods
        //What repeats in all 3 methods ath the beginaning
        //@Before will run before each @Test method
        //This @Before method will run 3 times before each @Test method
        //If your browser/internet/website is slow, then you may see some exeption
        //your test case may fail. To avoid this, we can put some wait in @Before method
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.google.com/");
        //We can put implicitly wait for slowers websites
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

    }

    @Test
    public void titleTest(){

        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }

    @Test
    public void imageTest(){
        //locating the image element. you canuse any locator(id, classname, tagname,...)
        WebElement googleImage=driver.findElement(By.id("hplogo"));
        //checking if the image displayed or not
        if (googleImage.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAILS");
        }

    }

    @Test
    public void gmailLinkTest(){

        //Locate the Gmail element
        WebElement gmailElement=driver.findElement(By.linkText("Gmail"));
        if (gmailElement.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }

    @After
    public void tearDown(){
        //@After annotation is usually used to close the browser
        //This method will run after each @Test Annotation
        //This method will run 3 times because there are 3 @Test annotations
        //report a
        driver.close();
    }
}
