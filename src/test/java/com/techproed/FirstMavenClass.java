package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMavenClass {
    public static void main(String[] args) {
        //We will not use System.setProperty("",""); in a maven project
        //Instead, we will use WebDriverManager->let us use the drivers
        //For chromedriver
        WebDriverManager.chromedriver().setup();//This is red.It means we are missing related dependency.
        //Where do we get the dependencies from?
        //Answer :  https://mvnrepository.com/

        WebDriver driver = new ChromeDriver();//->missing dependency
        //go to https://mvnrepository.com/ and search selenium java

        driver.get("https:/www.google.com");
        //How to generate fake data?
        //We need a dependency for it. It is called JavaFaker

        //creating seachbox element
        WebElement searchBox=driver.findElement(By.name("q"));
        //creating faker object
        Faker faker= new Faker();
        //sending that fake data to teh searchbox and hitting enter
        searchBox.sendKeys(faker.name().fullName()+Keys.ENTER);
        //Keys.Enter is same as clicking enter button
        //System.out.println(faker.name().title());



    }
}
