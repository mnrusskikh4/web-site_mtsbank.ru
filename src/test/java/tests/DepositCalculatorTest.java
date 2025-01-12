package tests;

import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.DepositCalculatorPage;

import static com.codeborne.selenide.Selenide.webdriver;

public class DepositCalculatorTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
    void testBusinessDepositsScenario(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        // 1. Открытие страницы и переход на нужный раздел
        DepositCalculatorPage depositPage = new DepositCalculatorPage()
                .openHomePage()
                .clickBusinessButton()
                .clickSmallBusinessLink();

        // 2. Проверяем URL, что мы попали на нужную страницу
        webdriver().shouldHave(WebDriverConditions.url("https://www.mtsbank.ru/malomu-biznesu/"));

        // 3. Переход на нужный подраздел
        depositPage.hoverDepositLink()
                .clickOpenDepositOnline();

        // 4. Проверяем URL, что мы попали на нужный подраздел
        webdriver().shouldHave(WebDriverConditions.url("https://www.mtsbank.ru/malomu-biznesu/bankovski-depozit/"));

        // 5. Установка граничных значений слайдера и проверка
        depositPage.setSliderValue(0, "50000").setSliderValue(1, "1");
        Assertions.assertEquals("1 день", depositPage.getDurationText(), "Неверный текст для 1 дня");

        depositPage.setSliderValue(0, "400000000").setSliderValue(1, "730");
        Assertions.assertEquals("730 дней", depositPage.getDurationText(), "Неверный текст для 730 дней");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
    void testBusinessDepositsScenarioMobile(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        DepositCalculatorPage depositPage = new DepositCalculatorPage()
                .openHomePage()
                .clickMobileMenu()
                .clickBusinessButtonMobile()
                .clickSmallBusinessLink();

        webdriver().shouldHave(WebDriverConditions.url("https://www.mtsbank.ru/malomu-biznesu/"));

        depositPage.clickDepositMenuMobile()
                .clickOpenDepositOnline();

        webdriver().shouldHave(WebDriverConditions.url("https://www.mtsbank.ru/malomu-biznesu/bankovski-depozit/"));

        depositPage.setSliderValue(0, "50000").setSliderValue(1, "1");
        Assertions.assertEquals("1 день", depositPage.getDurationText(), "Неверный текст для 1 дня");

        depositPage.setSliderValue(0, "400000000").setSliderValue(1, "730");
        Assertions.assertEquals("730 дней", depositPage.getDurationText(), "Неверный текст для 730 дней");
    }
}
