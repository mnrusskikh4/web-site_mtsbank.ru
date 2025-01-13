package tests;

import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.SelfEmployedGuidePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SelfEmployedGuideTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
    void testSelfEmployedScenarioDesktop(String width, String height) {
        runTestScenario(width, height, false);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
    void testSelfEmployedScenarioMobile(String width, String height) {
        runTestScenario(width, height, true);
    }

    private void runTestScenario(String width, String height, boolean isMobile) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        SelfEmployedGuidePage page = new SelfEmployedGuidePage().openSelfEmployedPage();

        webdriver().shouldHave(WebDriverConditions.urlContaining("https://www.mtsbank.ru/malomu-biznesu/samozanyatim/"));

        page.checkBadgeIsVisible();

        List<String> valuesBeforeClick = page.parseValues();

        List<String> valuesAfterClick = page.clickCheckItem().parseValues();

        System.out.println("Значения до нажатия на чекбокс: " + valuesBeforeClick);
        System.out.println("Значения после нажатия на чекбокс: " + valuesAfterClick);

        assertNotEquals(valuesBeforeClick, valuesAfterClick, "Тексты не изменились после нажатия на чекбокс!");
    }
}
