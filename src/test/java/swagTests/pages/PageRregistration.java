package swagTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageRregistration {

    private WebDriver driver;
    private WebDriverWait wait;
    private By fieldNameLocator = By.xpath("//input[@placeholder='Username']");
    private By fieldPasswordLocator = By.xpath("//input[@placeholder='Password']");
    private By fieldButtonLoginLocator = By.xpath("//input[@type='submit']");


    public PageRregistration(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public PageRregistration enterLK() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }
    public PageRregistration setNameReg(String nameReg) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldNameLocator));
        element.click();
        element.clear();
        element.sendKeys(nameReg);
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, nameReg));
        return this;
    }
    public PageRregistration setPassword(String passwordReg) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldPasswordLocator));
        element.click();
        element.clear();
        element.sendKeys(passwordReg);
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, passwordReg));
        return this;
    }
    public MainPage clickButtonLogin() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fieldButtonLoginLocator));
        element.click();
        return new MainPage(driver);
    }
}