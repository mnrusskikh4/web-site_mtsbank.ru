package tests;

import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.SelfEmployedGuidePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SelfEmployedGuideTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("utils.ResolutionsProvider#desktopScreenResolutions")
    void testSelfEmployedScenarioDesktop(String width, String height) {
        runTestScenario(width, height, false);
    }

    @ParameterizedTest
    @MethodSource("utils.ResolutionsProvider#mobileScreenResolutions")
    void testSelfEmployedScenarioMobile(String width, String height) {
        runTestScenario(width, height, true);
    }

    private void runTestScenario(String width, String height, boolean isMobile) {
        // Устанавливаем размер окна браузера
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        // Инициализируем объект страницы
        SelfEmployedGuidePage page = new SelfEmployedGuidePage()
                .openHomePage();

        // Навигация для мобильной или десктопной версии
        if (isMobile) {
            page.clickSelfEmployedLinkMobile();
        } else {
            page.hoverMoreMenu()
                .clickSelfEmployedLink();
        }

        // Проверяем URL
        webdriver().shouldHave(WebDriverConditions.urlContaining("https://www.mtsbank.ru/malomu-biznesu/samozanyatim/"));

        // Проверяем наличие бейджа
        page.checkBadgeIsVisible("Я не клиент банка");

        // Получаем значения текста до нажатия
        List<String> valuesBeforeClick = page.parseValues();

        // Кликаем по чекбоксу и получаем значения текста после нажатия
        List<String> valuesAfterClick = page.clickCheckItem()
                .parseValues();

        // Выводим содержание текстов
        System.out.println("Значения до нажатия на чекбокс: " + valuesBeforeClick);
        System.out.println("Значения после нажатия на чекбокс: " + valuesAfterClick);

        // Проверяем, что тексты изменились
        if (!valuesBeforeClick.equals(valuesAfterClick)) {
            System.out.println("Тексты успешно изменились после нажатия на чекбокс!");
        }
        assertNotEquals(valuesBeforeClick, valuesAfterClick, "Тексты не изменились после нажатия на чекбокс!");
    }
}
