package swagTests.Tests;


import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public abstract class BaseTest  {
    @BeforeAll
    @Step("Базовые настройки для теста")
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
//            Configuration.headless = false;
        Configuration.baseUrl = "https://www.saucedemo.com";
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(true)
//                .savePageSource(true));
// Проверяем: если мы на сервере CI (GitHub Actions), то включаем Headless
        String isCiServer = System.getenv("CI"); // Получаем переменную среды
        if (isCiServer != null) {
            Configuration.headless = true;

            // Важные настройки для стабильности Chrome в контейнерах (Linux)
            Configuration.browserCapabilities.setCapability("goog:chromeOptions",
                    java.util.Map.of("args", java.util.List.of(
                            "--no-sandbox",
                            "--disable-dev-shm-usage",
                            "--disable-gpu"
                    ))
            );
        }
    }

}

