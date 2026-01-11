package swagTests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage {
    @Step("Добавляем товар '{0}' в корзину")
    public InventoryPage addToCart(String itemName) {
        $$(".inventory_item")
                .findBy(text(itemName))
                .find("button")
                .click();
        return this;
    }
    @Step("Проваливаемся в корзину")
    public CartPage goToCart(){
        $(".shopping_cart_link").click();
        return new CartPage();
    }
}
