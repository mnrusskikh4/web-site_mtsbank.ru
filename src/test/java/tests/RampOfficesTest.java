//package tests;
//
//import com.codeborne.selenide.CollectionCondition;
//import com.codeborne.selenide.Selenide;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
//import pages.RampOfficesPage;
//
//import java.util.List;
//
//public class RampOfficesTest extends BaseTest {
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
//    void testOfficeAndATMScenarioDesktop(String width, String height) {
//        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;
//
//        RampOfficesPage rampPage = new RampOfficesPage()
//                .openOfficesPage();
//
//        // Ожидание загрузки всех элементов страницы
//        Selenide.$$("[data-testid='flexbox']").shouldHave(CollectionCondition.sizeGreaterThan(0));
//
//        rampPage.clickListTab(false)
//                .clickArrowDown(false)
//                .clickCheckboxWorkingNow()
//                .clickCheckboxHasRamp();
//
//        List<String> allRampTexts = rampPage.getAllRampTextsFromAllPages();
//
//        rampPage.analyzeRampTexts(allRampTexts);
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
//    void testOfficeAndATMScenarioMobile(String width, String height) {
//        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;
//
//        RampOfficesPage rampPage = new RampOfficesPage()
//                .openOfficesPage();
//
//        // Ожидание загрузки всех элементов страницы
//        Selenide.$$("[data-testid='flexbox']").shouldHave(CollectionCondition.sizeGreaterThan(0));
//
//        rampPage.clickListTab(true)
//                .clickArrowDown(true)
//                .clickCheckboxWorkingNow()
//                .clickCheckboxHasRamp()
//                .clickAcceptButtonMobile();
//
//        List<String> allRampTexts = rampPage.getAllRampTextsFromAllPages();
//
//        rampPage.analyzeRampTexts(allRampTexts);
//    }
//}
