package swagTests.Tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import swagTests.pages.LoginPage;

public class CartTests extends BaseTest{
    @Test
    @Step("[UI-200] Удаление товара из корзины")
    public void deletingProductFromBasket(){
        new LoginPage()
                .openPage()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .goToCart()
                .checkItemText("Sauce Labs Backpack")
                .removeProduct()
                .checkCartIsEmpty();
    }
}
