package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class inventoryPage {
        WebDriver driver; // This is the "placeholder" for the remote control

        // This is the "Handover" (Constructor)
        public inventoryPage(WebDriver driver) {
            this.driver = driver;
        }

    public void selectPhone() {
        WebElement dropdown = driver.findElement(By.id("deviceType"));

        // 1. Click to open
        dropdown.click();

        // 2. Add a tiny pause so the menu has time to exist
        try { Thread.sleep(1000); } catch (Exception ignored) {}

        // 3. Click the Phone option using the exact text we found
        driver.findElement(By.xpath("//option[text()='Phone']")).click();
    }
    }
