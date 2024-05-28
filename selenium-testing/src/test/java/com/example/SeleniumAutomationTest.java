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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikrantkatoch\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://192.168.56.104:9010/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddition() {
        driver.findElement(By.id("a")).sendKeys("12");
        driver.findElement(By.id("b")).sendKeys("3");
        driver.findElement(By.id("btn-addition")).click();
        String result = driver.findElement(By.id("result")).getAttribute("value");

        assertEquals("15.000", result);
    }

    @Test
    public void testSubtraction() {
        driver.findElement(By.id("a")).sendKeys("12");
        driver.findElement(By.id("b")).sendKeys("3");
        driver.findElement(By.id("btn-subtraction")).click();
        String result = driver.findElement(By.id("result")).getAttribute("value");

        assertEquals("9.000", result);
    }

    @Test
    public void testMultiplication() {
        driver.findElement(By.id("a")).sendKeys("12");
        driver.findElement(By.id("b")).sendKeys("3");
        driver.findElement(By.id("btn-multiplication")).click();
        String result = driver.findElement(By.id("result")).getAttribute("value");

        assertEquals("36.000", result);
    }

    @Test
    public void testDivision() {
        driver.findElement(By.id("a")).sendKeys("12");
        driver.findElement(By.id("b")).sendKeys("3");
        driver.findElement(By.id("btn-division")).click();
        String result = driver.findElement(By.id("result")).getAttribute("value");

        assertEquals("4.000", result);
    }

    @Test
    public void testDivision_DivideByZero() {
        driver.findElement(By.id("a")).sendKeys("12");
        driver.findElement(By.id("b")).sendKeys("0");
        driver.findElement(By.id("btn-division")).click();
        String result = driver.findElement(By.id("result")).getAttribute("value");

        assertEquals("Undefined", result);
    }

}