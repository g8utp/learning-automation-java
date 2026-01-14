package swagTests.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selectedText;
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
    @Step("Сортировка от дорогого к дешевому")
    public InventoryPage sortHighToLow(){
    $(".product_sort_container").selectOptionByValue("hilo");
    return this;
    }
    @Step("Проверяем цену первого товара: {0}")
    public InventoryPage checkFirstItemPrice(String expectedPrice){
        $$(".inventory_item_price")
                .first()
                .shouldHave(text(expectedPrice));
        return this;
    }
    @Step("Проверяем цену последнего товара: {0}")
    public InventoryPage checkLastItemPrice(String expectedPrice){
        $$(".inventory_item_price")
                .last()
                .shouldHave(text(expectedPrice));
        return this;
    }

}
