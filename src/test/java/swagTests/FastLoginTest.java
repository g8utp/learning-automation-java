package swagTests;

import org.junit.jupiter.api.Test;
import swagTests.Tests.BaseTest;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class FastLoginTest extends BaseTest {
    @Test
    public void loginWithCookie(){
        open("https://www.saucedemo.com/404");
        Cookie authCookie = new Cookie("session-username", "standard_user");
        WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
        open("/inventory.html");
        $(".inventory_list").shouldBe(visible);
    }
}
