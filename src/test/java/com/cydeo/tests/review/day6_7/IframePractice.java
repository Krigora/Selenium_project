package com.cydeo.tests.review.day6_7;

import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IframePractice {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1. Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void iframe_test(){
        // TC : Iframe practice
        // 1. Users are already login and on the homepage of CRM app (You can use CRM_Utilities class)
        driver.get("https://login1.nextbasecrm.com/");

        CRM_Utilities.login_crm(driver);

        // 2. Users click the MESSAGE tab
        driver.findElement(By.xpath("//span[.='Message']")).click();

        // 3. Users write test message
//        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));

        driver.findElement(By.tagName("body")).sendKeys("Hello");

        // 4. Users click the SEND button
        driver.switchTo().defaultContent();// it takes us to MAIN HTML
        //    driver.switchTo().parentFrame();// it will also work because our iframe is not nested!
        // if it was nested iframe, this one was going to take us parent iframe
        driver.findElement(By.id("blog-submit-button-save")).click();

        // 5. Verify the message is displayed on the feed
        WebElement message = driver.findElement(By.cssSelector(".feed-post-text-block-inner-inner"));

        Assert.assertEquals(message.getText(),"Hello");

        driver.quit();
    }
}
