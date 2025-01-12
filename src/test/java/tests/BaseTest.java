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

    @BeforeAll
    static void globalSetup() {
        // 1. Автоматическая настройка и скачивание драйвера Chrome
        WebDriverManager.chromedriver().setup();

        // 2. Параметры Selenide
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080"; // Разрешение по умолчанию
        Configuration.timeout = 10000; // Таймаут ожидания элементов
        Configuration.pageLoadStrategy = "eager"; // Быстрая загрузка страницы
        Configuration.headless = true; // Безголовый режим для CI/CD
        Configuration.browserCapabilities.setCapability("goog:chromeOptions", new HashMap<>() {{
            put("args", Arrays.asList(
                    "--no-sandbox",
                    "--disable-dev-shm-usage",
                    "--disable-extensions",
                    "--disable-gpu",
                    "--disable-popup-blocking",
                    "--disable-setuid-sandbox",
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
