package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumAutomationTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://192.168.56.104:9010/mvcapp/calculate");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddition() {
        driver.findElement(By.id("num1")).sendKeys("12");
        driver.findElement(By.id("num2")).sendKeys("3");
        driver.findElement(By.id("operation")).sendKeys("add");
        driver.findElement(By.id("submit-btn")).click();
        String result = driver.findElement(By.id("result")).getText();

        assertEquals("15.0", result);
    }

    @Test
    public void testSubtraction() {
        driver.findElement(By.id("num1")).sendKeys("12");
        driver.findElement(By.id("num2")).sendKeys("3");
        driver.findElement(By.id("operation")).sendKeys("subtract");
        driver.findElement(By.id("submit-btn")).click();
        String result = driver.findElement(By.id("result")).getText();

        assertEquals("9.0", result);
    }

    @Test
    public void testMultiplication() {
        driver.findElement(By.id("num1")).sendKeys("12");
        driver.findElement(By.id("num2")).sendKeys("3");
        driver.findElement(By.id("operation")).sendKeys("multiply");
        driver.findElement(By.id("submit-btn")).click();
        String result = driver.findElement(By.id("result")).getText();

        assertEquals("36.0", result);
    }

    @Test
    public void testDivision() {
        driver.findElement(By.id("num1")).sendKeys("12");
        driver.findElement(By.id("num2")).sendKeys("3");
        driver.findElement(By.id("operation")).sendKeys("division");
        driver.findElement(By.id("submit-btn")).click();
        String result = driver.findElement(By.id("result")).getText();

        assertEquals("4.0", result);
    }

    @Test
    public void testDivision_DivideByZero() {
        driver.findElement(By.id("num1")).sendKeys("12");
        driver.findElement(By.id("num2")).sendKeys("0");
        driver.findElement(By.id("operation")).sendKeys("division");
        driver.findElement(By.id("submit-btn")).click();
        String result = driver.findElement(By.id("error")).getText();

        assertEquals("Cannot divide by zero", result);
    }

}