package tests;

import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.DepositCalculatorPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static pages.DepositCalculatorPage.DEPOSIT_PAGE_URL;

public class DepositCalculatorTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
    void testBusinessDepositsScenario(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        // 1. Открытие страницы и переход на нужный раздел
        DepositCalculatorPage depositPage = new DepositCalculatorPage()
                .openDepositPage();

        // 2. Проверяем URL, что мы попали на нужную страницу
        webdriver().shouldHave(WebDriverConditions.url(DEPOSIT_PAGE_URL));

        // 3. Установка граничных значений слайдера и проверка
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
                .openDepositPage();

        webdriver().shouldHave(WebDriverConditions.url(DEPOSIT_PAGE_URL));

        depositPage.setSliderValue(0, "50000").setSliderValue(1, "1");
        Assertions.assertEquals("1 день", depositPage.getDurationText(), "Неверный текст для 1 дня");

        depositPage.setSliderValue(0, "400000000").setSliderValue(1, "730");
        Assertions.assertEquals("730 дней", depositPage.getDurationText(), "Неверный текст для 730 дней");
    }
}
