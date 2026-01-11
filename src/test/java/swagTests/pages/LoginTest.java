package swagTests.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import swagTests.Tests.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    @Step("Негативный сценарий теста")
    public void lockedUserTest(){
        new LoginPage()
                .openPage()
                .tryLogin("locked_out_user", "secret_sauce")
                .checkErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }
}
