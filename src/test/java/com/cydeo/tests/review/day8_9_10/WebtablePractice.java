package com.cydeo.tests.review.day8_9_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebtablePractice {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1. Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void webtable_practice_test(){
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");

        // 3. Print table data as a single String, not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println("table1 = " + table1.getText());

        // 4. verify tconway@earthlink.net is anywhere in the table
        Assert.assertTrue(table1.getText().contains("tconway@earthlink.net"));

        // 5. print all column names in single line
        WebElement colNames = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("colNames.getText() = " + colNames.getText());

        // 6. print each column name in separate lines using a loop and findElements method


        // 7. verify Tim due money is $50.00


    }
}
