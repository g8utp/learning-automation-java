package swagTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SwagLabsTest {
    @Test
    public void testCheckoutFlow() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try{
            driver.get("https://www.saucedemo.com/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).
                    sendKeys("standard-user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));
            driver.findElement(By.id("checkout")).click();
            WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
            firstNameInput.sendKeys("Tony");
            driver.findElement(By.id("last-name")).sendKeys("Leb");
            driver.findElement(By.id("postal-code")).sendKeys("123456");
            driver.findElement(By.id("continue")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("finish"))).click();
            WebElement thankYouForYourOrder = driver.findElement(By.className("complete-header"));
            String actualText = thankYouForYourOrder.getText();
            String expectedText = "Thank you for your order!";
            Assertions.assertEquals(expectedText, actualText, "Текст не совпадает");
        } finally {
            driver.quit();
        }

    }
}
