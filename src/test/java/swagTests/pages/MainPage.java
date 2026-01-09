package swagTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By sauceLabsProductLocator = By.xpath("//a[@id='item_4_title_link']");
    private By addProductBasketBtnLocator = By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']");
    private By basketButtonLocator = By.xpath("//a[@class='shopping_cart_link']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public MainPage openMainPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
        driver.get("https://www.saucedemo.com/inventory.html");
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (TimeoutException e) {
            System.out.println("Alert не появился в течение 10 секунд (или не был предусмотрен)");
        }
        return this;
    }

    public void addProductToBasket() {
        WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(addProductBasketBtnLocator));

        String buttonText = addBtn.getText();

        if (buttonText.equalsIgnoreCase("Add to cart")) {
            addBtn.click();

            wait.until(ExpectedConditions.textToBePresentInElement(addBtn, "Remove"));
        }

        WebElement basketBtn = wait.until(ExpectedConditions.elementToBeClickable(basketButtonLocator));
        basketBtn.click();
    }
}