package swagTests.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBasket {

    private WebDriver driver;

    private WebDriverWait wait;

    private By fieldCheckoutBtn = By.xpath("//div[@class='cart_footer']//button[2]");
    private By visibleProductInList = By.xpath("//div[@data-test='inventory-item']");

    public void checkItemText() {
        WebElement itemInCart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));
        String actualItemName = itemInCart.getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualItemName);
    }

    public void clickBtnCheckout(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fieldCheckoutBtn));
        element.click();
    }
}
