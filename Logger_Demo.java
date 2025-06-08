package com.example.demo.Demos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logger_Demo {

    Logger logger = Logger.getLogger(Logger_Demo.class);
    WebDriver driver = null;
    ExtentReports extent=null;
    ExtentTest message;
    
    By username1=By.id("username");
    By password1=By.id("password");
    By button=By.className("radius");
    @BeforeTest
    public void setUp() {
        try {
            if (driver == null) {
            	extent=ExtentDemo.getExtent(); 
            	message=extent.createTest("Login test-user");
                WebDriverManager.chromedriver().setup();
                logger.info("Web browser is lanuched");
                message.pass("Web browser is downloading and configuring");
                driver = new ChromeDriver();
                
               
               
                logger.info("Driver is created");
                message.pass("driver is created");
            } else {
                logger.error("Driver is null");
                message.fail("driver is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "abc")
    public void testData(String username, String password) {
        System.out.println("Username: " + username + ", Password: " + password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(username1).sendKeys(username);
        driver.findElement(password1).sendKeys(password);
        driver.findElement(button).click();
        
    }

    @DataProvider(name = "abc")
    public Object[][] provider() {
        try {
            DataProvider1 ob = new DataProvider1();
            return ob.testData("C:\\Users\\me\\OneDrive\\Desktop\\logical question\\Log4jDemo\\Excel\\abx.xlsx", "Sheet1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Object[0][0]; // Return empty array in case of failure
    }
    
    @AfterTest
    public void teersDown() {
    	driver.close();
    }
}
