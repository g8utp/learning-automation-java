package swagTests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    @Step("Заполняем личные данные для доставки")
    public CheckoutPage fillForm(String name, String last, String zip) {
        $("#first-name").setValue(name);
        $("#last-name").setValue(last);
        $("#postal-code").setValue(zip);
        return this;
    }
    @Step("Подтверждаем заполнение данных")
    public CheckoutPage clickContinue(){
        $("#continue").click();
        return new CheckoutPage();
    }
    @Step("Жмем кнопку финиш")
    public CheckoutPage clickFinish(){
        $("#finish").click();
        return new CheckoutPage();
    }
    @Step("Проверка, что все прошлу успешно")
    public CheckoutPage checkOrderComplete(){
        $(".complete-header").shouldHave(text("Thank you for your order!"));
        return this;
    }
}
