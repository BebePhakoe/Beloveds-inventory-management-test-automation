package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utils.BrowserFactory; // This must match your Factory folder name

public class BaseTest {

    // We make this 'public' so your Login and Inventory pages can see it
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // We call the 'getDriver' method from your Factory
        // Make sure the word 'chrome' is in lowercase!
        driver = BrowserFactory.getDriver("chrome");

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // This closes the browser after the test is done
        if (driver != null) {
            driver.quit();
        }
    }
}