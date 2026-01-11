package swagTests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    @Step("Открываем сайт")
    public LoginPage openPage() {
        open("/");
        return this;
    }

    @Step("Авторизируемся как пользователь: {0}")
    public InventoryPage login(String userName, String password) {
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        return new InventoryPage();
    }

    @Step("Пробуем войти с ошибкой под пользователем {0}")
    public LoginPage tryLogin(String userName, String password) {
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        return this;
    }

    @Step("Проверяем наличие ошибки с текстом: {0}")
    public LoginPage checkErrorMessage(String excpectedText) {
        $("h3[data-test='error']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(excpectedText));
        return this;
    }
}

