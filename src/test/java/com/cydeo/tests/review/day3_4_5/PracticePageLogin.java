package com.cydeo.tests.review.day3_4_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracticePageLogin {
    public static void main(String[] args) throws InterruptedException {
        // 1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // this wil always give time to app for making visible of ELEMENTS
        // it will go whenever you use findElement/s method to check if app needs time for this element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //default is 0

        // This will freeze the code for giving time
        Thread.sleep(3000);

        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        // 4. Enter password: "SuperSecretPassword"
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        // WebElement loginBtnWclass= driver.findElement(By.className("btn btn-primary"));
        WebElement loginBtn = driver.findElement(By.cssSelector(".btn.btn-primary"));
        loginBtn.click();

        // 6. Verify text displayed on page contains
        //    Expected: "You logged into a secure area!"
        WebElement msg = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));

        Thread.sleep(2000);

        String expectedMsg = "You logged into a secure area!";
        String actualMsg = msg.getText();

        if(actualMsg.contains(expectedMsg)){
            System.out.println("Msg verification is passed!");
        }else{
            System.out.println("Msg verification is failed!");
        }

        driver.quit();



    }
}
