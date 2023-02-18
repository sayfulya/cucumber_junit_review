package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


    //create the private constructor to remove access to this object
    private Driver(){

    }
    //We make the WebDriver private because we want to close access from outside the class
    // we are making it static because we will be using it in a static method
    private static WebDriver driver;

    /*create reusable utility method with return the same driver instance once we call it.
     * If the instance doesn't exist, it will create first and then it will always return same instance*/
    public static WebDriver getDriver(){
        if(driver== null){

            //we will read our browserType from configuration.properties file.This way we can control which browser is opened from outside our code
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                  //  WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "edge":
                  //  WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                  //  WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                   // WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null) {
            driver.quit();
        }
        driver = null;
    }


}
