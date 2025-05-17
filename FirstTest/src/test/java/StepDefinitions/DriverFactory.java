package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    // Making driver and config properties public so they can be used in other classes
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    
    // Static block to load the CONFIG.properties file
    static {
        try {
            // Load CONFIG.properties file
            FileInputStream fis = new FileInputStream("src/test/resources/Properties/CONFIG.properties");
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Static block to load the OR.properties file
    static {
        try {
            // Load CONFIG.properties file
            FileInputStream fis = new FileInputStream("src/test/resources/Properties/OR.properties");
            OR.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            String chromeDriverPath = config.getProperty("chromedriver.path");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            System.out.println("======= Inside DriverFactory Launch Browser=======");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Method to navigate to URL
    public static void navigateToURL() {
        String url = config.getProperty("url");
        System.out.println("======= Inside DriverFactory Open URL =======");
        getDriver().get(url);
    }

    // Quit the driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
