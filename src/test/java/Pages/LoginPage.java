package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // The Constructor connects this page to the browser started in BaseTest
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By loginMenuBtn = By.xpath("//button[span[text()='Login']]");
    By emailField = By.id("login-email");
    By passwordField = By.id("login-password");
    By submitBtn = By.id("login-submit");

    // Action Method
    public void loginToSite(String email, String password) {
        driver.findElement(loginMenuBtn).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitBtn).click();
    }
}