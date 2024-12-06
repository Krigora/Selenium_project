package com.cydeo.tests.review.day3_4_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationFormPage {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1. Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void registration_form_test(){
        // TC#2: Registration Form Page Testing

//      // 1. Open Chrome browser
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        Assert.assertEquals(driver.getTitle(),"Registration Form","Title verification is failed!");
    }

    @Test
    public void registration_form_filling_test(){
        // TC#3: Registration Form Page Filling Form Test

//        // 1. Open Chrome browser
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Enter First name: "John"
        driver.findElement(By.name("firstname")).sendKeys("John");

        // 4. Enter Last name: "Smith"
        driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("Smith");

        // 5. Enter Username: "johnsmith123"
        driver.findElement(By.cssSelector("input[placeholder='username']")).sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234"
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("John1234");

        // 8. Enter Phone number: "123-456-7890"
        driver.findElement(By.name("phone")).sendKeys("123-456-7890");

        // 9. Click to "Male" from Gender
        WebElement maleBtn = driver.findElement(By.cssSelector("input[value='male']"));
        maleBtn.click();
        Assert.assertTrue(maleBtn.isSelected(),"Male button did not selected!");

        // 10. Enter Date of birth "01/28/1990"
        driver.findElement(By.name("birthday")).sendKeys("01/28/1990");

        // 11. Select "Department of Engineering" from Department/Office dropdown
        Select selectDepartment = new Select(driver.findElement(By.name("department")));
        System.out.println("before doing selection: " + selectDepartment.getFirstSelectedOption().getText());

//        selectDepartment.selectByIndex(1);
//        selectDepartment.selectByValue("DE");
        selectDepartment.selectByVisibleText("Department of Engineering");
        System.out.println("after doing selection: " + selectDepartment.getFirstSelectedOption().getText());

        String expectedDepartmentOption = "Department of Engineering";
        String actualDepartmentOption = selectDepartment.getFirstSelectedOption().getText();

        Assert.assertEquals(actualDepartmentOption,expectedDepartmentOption);

        // 12. Select "SDET" from Job title dropdown
        Select selectJob = new Select(driver.findElement(By.name("job_title")));
        selectJob.selectByVisibleText("SDET");
        Assert.assertEquals(selectJob.getFirstSelectedOption().getText(),"SDET");

        // 13. Click to "Java" from languages
        WebElement javaBtn = driver.findElement(By.id("inlineCheckbox2"));
        javaBtn.click();
        Assert.assertTrue(javaBtn.isSelected());

        // 14. Click to "Sign up" button
        driver.findElement(By.id("wooden_spoon")).click();

        // 15. Verify text displayed on page
        //     Expected: "Well done!"
        WebElement msg = driver.findElement(By.xpath("//h4[.='Well done!']"));

        Assert.assertEquals(msg.getText(),"Well done!");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
