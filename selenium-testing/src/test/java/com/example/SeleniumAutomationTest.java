package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAutomationTest {

    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikrantkatoch\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        String hostname = System.getProperty("hostname");
        int port = Integer.parseInt(System.getProperty("port"));
        String context = System.getProperty("context");
        String baseUrl = "http://" + hostname + ":" + port + context;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.setBinary("/usr/bin/google-chrome");
        driver = new ChromeDriver(options);
//        driver.get("http://localhost:8181/mvcapp/calculate");
        driver.get(baseUrl);
    }

    @AfterMethod
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

        Assert.assertEquals(result, "15.0");
    }

    @Test
    public void testSubtraction() {
        driver.findElement(By.id("num1")).sendKeys("12");
        driver.findElement(By.id("num2")).sendKeys("3");
        driver.findElement(By.id("operation")).sendKeys("subtract");
        driver.findElement(By.id("submit-btn")).click();
        String result = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(result, "9.0");
    }

    @Test
    public void testMultiplication() {
        driver.findElement(By.id("num1")).sendKeys("12");
        driver.findElement(By.id("num2")).sendKeys("3");
        driver.findElement(By.id("operation")).sendKeys("multiply");
        driver.findElement(By.id("submit-btn")).click();
        String result = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(result, "36.0");
    }

    @Test
    public void testDivision() {
        driver.findElement(By.id("num1")).sendKeys("12");
        driver.findElement(By.id("num2")).sendKeys("3");
        driver.findElement(By.id("operation")).sendKeys("division");
        driver.findElement(By.id("submit-btn")).click();
        String result = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(result, "4.0");
    }

    @Test
    public void testDivision_DivideByZero() {
        driver.findElement(By.id("num1")).sendKeys("12");
        driver.findElement(By.id("num2")).sendKeys("0");
        driver.findElement(By.id("operation")).sendKeys("division");
        driver.findElement(By.id("submit-btn")).click();
        String result = driver.findElement(By.id("error")).getText();

        Assert.assertEquals(result, "Cannot divide by zero");
    }

}