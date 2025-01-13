package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

//    @BeforeAll
//    static void globalSetup() {
//
//        WebDriverManager.chromedriver().setup();
//
//        Configuration.browser = "chrome";
//        Configuration.timeout = 10000;
//        Configuration.pageLoadStrategy = "normal";
//        Configuration.headless = false;
//        Configuration.browserCapabilities.setCapability("goog:chromeOptions", new HashMap<>() {{
//            put("args", Arrays.asList(
//                    "--no-sandbox",
//                    "--disable-extensions"
//            ));
//        }});
//    }

    @BeforeAll
    static void globalSetup() {
        WebDriverManager.chromedriver().setup();

        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = true;
        Configuration.browserCapabilities.setCapability("goog:chromeOptions", new HashMap<>() {{
            put("args", Arrays.asList(
                    "--no-sandbox",
                    "--disable-dev-shm-usage",
                    "--disable-extensions",
                    "--disable-popup-blocking",
                    "--disable-gpu",
                    "--remote-allow-origins=*"
            ));
        }});
    }

    @BeforeEach
    void setUp() {
        // 3. Открываем начальную страницу и очищаем браузерное состояние
        open("https://www.mtsbank.ru/");
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @AfterEach
    void tearDown() {
        // Закрываем веб-драйвер после каждого теста
        Selenide.closeWebDriver();
    }
}
