package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utilities.BrowserFactory; // This must match your Factory folder name

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


        }