package swagTests.pages;

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
    public InventoryPage login(String userName, String password){
       $("#user-name").setValue(userName);
       $("#password").setValue(password);
       $("#login-button").click();
        return new InventoryPage();
    }
}
