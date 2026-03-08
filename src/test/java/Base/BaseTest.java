package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utilities.BrowserFactory;

public class BaseTest {

    // Public so other test classes can use it
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Choose the browser here
        driver = BrowserFactory.getDriver("chrome");

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit(); // closes browser after each test
        }
    }
}