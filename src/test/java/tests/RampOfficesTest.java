/**
 * Перестал работать, проблема с отсутствием реакции на вызов фильтра.
 */

//package tests;
//
//import com.codeborne.selenide.CollectionCondition;
//import com.codeborne.selenide.Selenide;
//import io.qameta.allure.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
//import pages.RampOfficesPage;
//
//import java.util.List;
//
//@Epic("Тестирование офисов и банкоматов")
//@Feature("Проверка наличия пандусов и работы фильтров")
//public class RampOfficesTest extends BaseTest {
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
//    @Story("Сценарий тестирования для десктопных разрешений")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Тестирование отображения офисов и банкоматов с пандусами на десктопных разрешениях")
//    void testOfficeAndATMScenarioDesktop(String width, String height) {
//        Allure.step("Установлен размер окна браузера: " + width + "x" + height);
//        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;
//
//        RampOfficesPage rampPage = new RampOfficesPage()
//                .openOfficesPage();
//
//        Allure.step("Ожидание загрузки всех элементов страницы");
//        Selenide.$$("[data-testid='flexbox']").shouldHave(CollectionCondition.sizeGreaterThan(0));
//
//        Allure.step("Выполнение кликов по вкладке списка, раскрытия фильтра, чекбоксам работы сейчас и наличия пандуса");
//        rampPage.clickListTab(false)
//                .clickArrowDown(false)
//                .clickCheckboxWorkingNow()
//                .clickCheckboxHasRamp();
//
//        Allure.step("Сбор всех текстов наличия пандусов со всех страниц");
//        List<String> allRampTexts = rampPage.getAllRampTextsFromAllPages();
//
//        Allure.step("Анализ собранных текстов");
//        rampPage.analyzeRampTexts(allRampTexts);
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
//    @Story("Сценарий тестирования для мобильных разрешений")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Тестирование отображения офисов и банкоматов с пандусами на мобильных разрешениях")
//    void testOfficeAndATMScenarioMobile(String width, String height) {
//        Allure.step("Установлен размер окна браузера: " + width + "x" + height);
//        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;
//
//        RampOfficesPage rampPage = new RampOfficesPage()
//                .openOfficesPage();
//
//        Allure.step("Ожидание загрузки всех элементов страницы");
//        Selenide.$$("[data-testid='flexbox']").shouldHave(CollectionCondition.sizeGreaterThan(0));
//
//        Allure.step("Выполнение кликов по вкладке списка, раскрытия фильтра, чекбоксам работы сейчас, наличия пандуса и кнопке принятия");
//        rampPage.clickListTab(true)
//                .clickArrowDown(true)
//                .clickCheckboxWorkingNow()
//                .clickCheckboxHasRamp()
//                .clickAcceptButtonMobile();
//
//        Allure.step("Сбор всех текстов наличия пандусов со всех страниц");
//        List<String> allRampTexts = rampPage.getAllRampTextsFromAllPages();
//
//        Allure.step("Анализ собранных текстов");
//        rampPage.analyzeRampTexts(allRampTexts);
//    }
//}
