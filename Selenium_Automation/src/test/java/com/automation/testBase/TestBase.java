package com.automation.testBase;




import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public  static WebDriver driver;


    public void selectBrowser(String browser) {
        WebDriver driver = null;

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().driverVersion("124.0.6367.62").setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }

    }
}