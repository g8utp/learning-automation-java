package swagTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import swagTests.Tests.BaseTest;
import swagTests.pages.CartPage;
import swagTests.pages.CheckoutPage;
import swagTests.pages.InventoryPage;
import swagTests.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SwagLabsTestSelenide extends BaseTest {

    @ParameterizedTest (name = "Покупка от лица {0} {1}")
    @CsvSource({
            "Tony, Leb, 123456",
            "Ivan, Petrov, 654321",
            "LongNameTest, VeryLongLastName, 000000"
    })
    @Step("Запускаем общий тест")
    public void checkoutFlow(String firstName, String lastName, String zipCode) {
        new LoginPage()
                .openPage()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .addToCart("Sauce Labs Bike Light")
                .goToCart()
                .checkItemText("Sauce Labs Backpack")
                .checkItemText("Sauce Labs Bike Light")
                .clickCheckout()
                .fillForm(firstName, lastName, zipCode)
                .clickContinue()
                .clickFinish()
                .checkOrderComplete();
    }
}
