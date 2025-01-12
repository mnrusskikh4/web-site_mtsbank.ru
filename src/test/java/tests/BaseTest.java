package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    @BeforeEach
    void setUp() {
        // 1. Автоматическая настройка и скачивание драйвера Chrome
        WebDriverManager.chromedriver().setup();

        // 2. Параметры Selenide
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        // Configuration.headless = true; // - опционально
        open("https://www.mtsbank.ru/"); // - чтобы инициализировать драйвер перед п.3
        // 3. Очищаем историю, cookies, localStorage (чтобы тесты не мешали друг другу)
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @AfterEach
    void tearDown() {
        // Закрываем веб-драйвер после каждого теста
        Selenide.closeWebDriver();
    }
}

