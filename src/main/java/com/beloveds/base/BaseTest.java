package com.beloveds.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Base class for all test cases containing common setup and teardown logic
 */
public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected Properties properties;

    /**
     * Initialize WebDriver and load properties
     */
    protected void setUp() throws IOException {
        loadProperties();
        initializeDriver();
    }

    /**
     * Load configuration properties
     */
    private void loadProperties() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    /**
     * Initialize the WebDriver based on configuration
     */
    private void initializeDriver() {
        String browser = properties.getProperty("browser", "chrome").toLowerCase();
        boolean headless = Boolean.parseBoolean(properties.getProperty("headless", "false"));

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        logger.info("WebDriver initialized for browser: " + browser);
    }

    /**
     * Close WebDriver instance
     */
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed");
        }
    }

    /**
     * Navigate to application URL
     */
    protected void navigateToApp() {
        String appUrl = properties.getProperty("app.url");
        driver.navigate().to(appUrl);
        logger.info("Navigated to: " + appUrl);
    }
}

