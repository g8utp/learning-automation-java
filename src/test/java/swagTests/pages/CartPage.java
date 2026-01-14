package swagTests.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    @Step("Проверяем наличие товара в корзине")
    public CartPage checkItemText(String text) {
        $$(".inventory_item_name")
                .findBy(text(text))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("Подтверждаем покупку в корзине 'Чекаут'")
    public CheckoutPage clickCheckout() {
        $("#checkout").click();
        return new CheckoutPage();
    }

    @Step("Удаляем товар из корзины")
    public CartPage removeProduct() {
        $("#remove-sauce-labs-backpack")
                .click();
        return this;
    }
    @Step("Проверяем наличие товаров в корзине")
    public CartPage checkCartIsEmpty () {
        $$(".cart_item")
                .shouldHave(CollectionCondition.size(0));;
        return this;
    }
}
