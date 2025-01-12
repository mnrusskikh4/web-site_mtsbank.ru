package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.RampOfficesPage;

import java.util.List;

public class RampOfficesTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
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
    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
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
