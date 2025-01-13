package tests;

import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.DepositCalculatorPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static pages.DepositCalculatorPage.DEPOSIT_PAGE_URL;

@Epic("Тестирование депозитного калькулятора")
@Feature("Депозиты для бизнеса")
public class DepositCalculatorTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
    @Story("Тестирование сценария депозитного калькулятора для бизнеса на десктопных разрешениях")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка работы слайдера и соответствие значений срока на десктопных разрешениях")
    void testBusinessDepositsScenario(String width, String height) {
        Allure.step("Установлен размер окна браузера: " + width + "x" + height);
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        Allure.step("Открыть страницу депозитного калькулятора");
        DepositCalculatorPage depositPage = new DepositCalculatorPage()
                .openDepositPage();

        Allure.step("Проверить, что текущий URL совпадает с URL страницы депозитного калькулятора");
        webdriver().shouldHave(WebDriverConditions.url(DEPOSIT_PAGE_URL));

        Allure.step("Установить значения слайдера: 50000 и 1, проверить текст продолжительности");
        depositPage.setSliderValue(0, "50000").setSliderValue(1, "1");
        Assertions.assertEquals("1 день", depositPage.getDurationText(), "Неверный текст для 1 дня");

        Allure.step("Установить значения слайдера: 400000000 и 730, проверить текст продолжительности");
        depositPage.setSliderValue(0, "400000000").setSliderValue(1, "730");
        Assertions.assertEquals("730 дней", depositPage.getDurationText(), "Неверный текст для 730 дней");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
    @Story("Тестирование сценария депозитного калькулятора для бизнеса на мобильных разрешениях")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка работы слайдера и соответствие значений срока на мобильных разрешениях")
    void testBusinessDepositsScenarioMobile(String width, String height) {
        Allure.step("Установлен размер окна браузера: " + width + "x" + height);
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        Allure.step("Открыть страницу депозитного калькулятора");
        DepositCalculatorPage depositPage = new DepositCalculatorPage()
                .openDepositPage();

        Allure.step("Проверить, что текущий URL совпадает с URL страницы депозитного калькулятора");
        webdriver().shouldHave(WebDriverConditions.url(DEPOSIT_PAGE_URL));

        Allure.step("Установить значения слайдера: 50000 и 1, проверить текст продолжительности");
        depositPage.setSliderValue(0, "50000").setSliderValue(1, "1");
        Assertions.assertEquals("1 день", depositPage.getDurationText(), "Неверный текст для 1 дня");

        Allure.step("Установить значения слайдера: 400000000 и 730, проверить текст продолжительности");
        depositPage.setSliderValue(0, "400000000").setSliderValue(1, "730");
        Assertions.assertEquals("730 дней", depositPage.getDurationText(), "Неверный текст для 730 дней");
    }
}
