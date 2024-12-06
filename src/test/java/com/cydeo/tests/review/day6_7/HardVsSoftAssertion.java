package com.cydeo.tests.review.day6_7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardVsSoftAssertion {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1. Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void hard_assertion_alert_test(){
        // TC : Alert practice
        // 1. Open browser
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

        Assert.assertEquals(driver.getTitle(),"Alerts","Title verification is failed!");

        // 3. Click to “Click for JS Prompt” button
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        // 4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();

        alert.sendKeys("hello");

        // 5. Click to OK button from the alert
        alert.accept();

        // 6. Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));

        String expectedText = "You entered: hello";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText,expectedText,"Text verification is failed!");

    }

    @Test
    public void soft_assertion_alert_test(){
        // TC : Alert practice
        // 1. Open browser
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getTitle(),"Alerts","Title verification is failed!");

        // 3. Click to “Click for JS Prompt” button
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        // 4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();

        alert.sendKeys("hello");

        // 5. Click to OK button from the alert
        alert.accept();

        // 6. Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));

        String expectedText = "You entered: hello";
        String actualText = resultText.getText();

        softAssert.assertEquals(actualText,expectedText,"Text verification is failed!");

        softAssert.assertAll();

    }
}
