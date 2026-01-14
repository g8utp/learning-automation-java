package swagTests.Tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import swagTests.Tests.BaseTest;
import swagTests.api.models.UserData;
import swagTests.pages.CartPage;
import swagTests.pages.CheckoutPage;
import swagTests.pages.InventoryPage;
import swagTests.pages.LoginPage;
import swagTests.utils.UserDataFactory;

import java.sql.SQLOutput;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SwagLabsTestSelenide extends BaseTest {


    @Test
    @Step("Запускаем тест со случайными данными")
    public void checkoutFlow() {
        UserData user = UserDataFactory.getRandomUser();
        System.out.println("Test with user" + user.getFirstName() + user.getLastName());

        new LoginPage()
                .openPage()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .addToCart("Sauce Labs Bike Light")
                .goToCart()
                .checkItemText("Sauce Labs Backpack")
                .checkItemText("Sauce Labs Bike Light")
                .clickCheckout()
                .fillForm(user.getFirstName(), user.getLastName(), user.getZip())
                .clickContinue()
                .clickFinish()
                .checkOrderComplete();
    }
    @Test
    @Step("Тест сортировки товаров (High to Low)")
    public void sortingTest(){
        new LoginPage()
                .openPage()
                .login("standard_user", "secret_sauce")
                .sortHighToLow()
                .checkFirstItemPrice("$49.99")
                .checkLastItemPrice("$7.99");
    }

}