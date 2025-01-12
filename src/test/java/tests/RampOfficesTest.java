package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.RampOfficesPage;

import java.util.List;

public class RampOfficesTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("utils.ResolutionsProvider#desktopScreenResolutions")
    void testOfficeAndATMScenarioDesktop(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        RampOfficesPage rampPage = new RampOfficesPage()
                .openOfficesPage()
                .clickListTab(false)
                .clickArrowDown(false)
                .clickCheckboxWorkingNow()
                .clickCheckboxHasRamp();

        Selenide.sleep(3000);

        List<String> allRampTexts = rampPage.getAllRampTextsFromAllPages();

        rampPage.analyzeRampTexts(allRampTexts);
    }

    @ParameterizedTest
    @MethodSource("utils.ResolutionsProvider#mobileScreenResolutions")
    void testOfficeAndATMScenarioMobile(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        RampOfficesPage rampPage = new RampOfficesPage()
                .openOfficesPage()
                .clickListTab(true)
                .clickArrowDown(true)
                .clickCheckboxWorkingNow()
                .clickCheckboxHasRamp()
                .clickAcceptButtonMobile();

        Selenide.sleep(3000);

        List<String> allRampTexts = rampPage.getAllRampTextsFromAllPages();

        rampPage.analyzeRampTexts(allRampTexts);
    }
}
