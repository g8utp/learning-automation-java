package swagTests.Tests;


import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
public abstract class BaseTest {
        @BeforeAll
        @Step("Базовые настройки для теста")
    public static void setUp(){
            Configuration.browser = "chrome";
            Configuration.browserSize = "1920x1080";
            Configuration.headless = false;
            Configuration.baseUrl = "https://www.saucedemo.com";
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                    .screenshots(true)
                    .savePageSource(true));
        }

}
