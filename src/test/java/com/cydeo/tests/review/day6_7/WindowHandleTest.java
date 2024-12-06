package com.cydeo.tests.review.day6_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WindowHandleTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1. Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void window_handle_test() throws InterruptedException {
        // TC : Windows handle practice
        //    1. Open browser
        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");

        String mainWindow = driver.getWindowHandle();
        System.out.println("mainWindow: "+ mainWindow);

        //    3. Click on New Tab button
        driver.findElement(By.id("tabButton")).click();

        //    4. Click on New Window button
        driver.findElement(By.id("windowButton")).click();

        //    5. Click on New Window Message button
        driver.findElement(By.id("messageWindowButton")).click();

        //    6. Print out each window title
        Set<String> allWindows = driver.getWindowHandles();

        for (String eachWindow : allWindows) {
            System.out.println("eachWindow = " + eachWindow);

            driver.switchTo().window(eachWindow);

            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        driver.quit();
    }
}
