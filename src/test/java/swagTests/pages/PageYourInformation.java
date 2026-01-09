package swagTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageYourInformation {
    private WebDriver driver;
    private WebDriverWait wait;

    private By fieldFirstName = By.xpath("//input[@placeholder='First Name']");
    private By fieldLastName = By.xpath("//input[@data-test='lastName']");
    private By fieldPostalCode = By.xpath("//input[@name='postalCode']");

    public PageYourInformation entryFirstName() {
        WebElement firstName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        firstName.sendKeys("Tony");
        return null;
    }

    public PageYourInformation entryLastName() {
        WebElement lastName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
        lastName.sendKeys("Boy");
        return null;
    }

    public PageYourInformation entryPostalCode() {
        WebElement postalCode = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
        postalCode.sendKeys("632023");
        return null;
    }
}
