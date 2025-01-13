package tests;

import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.SelfEmployedGuidePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Epic("Тестирование руководства для самозанятых")
@Feature("Функциональность страницы для самозанятых")
public class SelfEmployedGuideTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
    @Story("Сценарий для самозанятых на десктопных разрешениях")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка функциональности чекбокса и изменений текстов гайда" +
                 "на странице самозанятых для десктопов")
    void testSelfEmployedScenarioDesktop(String width, String height) {
        runTestScenario(width, height, false);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
    @Story("Сценарий для самозанятых на мобильных разрешениях")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка функциональности чекбокса и изменений текстов гайда" +
                 "на странице самозанятых для мобильных устройств")
    void testSelfEmployedScenarioMobile(String width, String height) {
        runTestScenario(width, height, true);
    }

    @Step("Выполнение тестового сценария для проверки руководства самозанятых")
    private void runTestScenario(String width, String height, boolean isMobile) {
        Allure.step("Установлен размер окна браузера: " + width + "x" + height);
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        Allure.step("Открыть страницу для самозанятых");
        SelfEmployedGuidePage page = new SelfEmployedGuidePage().openSelfEmployedPage();

        Allure.step("Проверить URL страницы для самозанятых");
        webdriver().shouldHave(WebDriverConditions.urlContaining("https://www.mtsbank.ru/malomu-biznesu/samozanyatim/"));

        Allure.step("Проверить наличие бейджа 'Я не клиент банка'");
        page.checkBadgeIsVisible();

        Allure.step("Получить значения текстов до нажатия на чекбокс");
        List<String> valuesBeforeClick = page.parseValues();

        Allure.step("Нажать на чекбокс и получить значения текстов после нажатия");
        List<String> valuesAfterClick = page.clickCheckItem().parseValues();

        Allure.step("Проверить, что значения текстов изменились");
        assertNotEquals(valuesBeforeClick, valuesAfterClick, "Тексты не изменились после нажатия на чекбокс!");
    }
}
