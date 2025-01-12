package tests;

import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.MtsDengiCardFormPage;
import utils.DataGenerator;

import static com.codeborne.selenide.Selenide.*;

public class MtsDengiCardFormTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
    void testFormFillingDesktop(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        // Открытие страницы и выполнение тестового сценария для десктопа
        MtsDengiCardFormPage page = new MtsDengiCardFormPage()
                .openHomePage()
                .clickYesButton()
                .hoverCardsLink()
                .clickCreditCardLink();

        webdriver().shouldHave(WebDriverConditions.urlStartingWith("https://www.mtsbank.ru/factory/karti/credit-mts-dengi/"));

        page.fillPhone(DataGenerator.generatePhoneNumber())
                .fillBirthDate(DataGenerator.generateBirthDate())
                .fillEmail(DataGenerator.generateEmail());

        String fullName = DataGenerator.generateFullName();
        page.fillFullName(fullName)
                .verifyAutocompleteSuggestion(fullName);

        String rearrangedName = DataGenerator.rearrangeFullName(fullName);
        page.fillFullName(rearrangedName)
                .verifyAutocompleteSuggestion(fullName);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
    void testFormFillingMobile(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        // Открытие страницы и выполнение тестового сценария для мобильного устройства
        MtsDengiCardFormPage page = new MtsDengiCardFormPage()
                .openHomePage()
                .clickYesButton()
                .openMobileMenu()
                .clickMobileCardsLink()
                .clickMobileCreditCardLink();

        webdriver().shouldHave(WebDriverConditions.urlStartingWith("https://www.mtsbank.ru/factory/karti/credit-mts-dengi/"));

        page.fillPhone(DataGenerator.generatePhoneNumber())
                .fillBirthDate(DataGenerator.generateBirthDate())
                .fillEmail(DataGenerator.generateEmail());

        String fullName = DataGenerator.generateFullName();
        page.fillFullName(fullName)
                .verifyAutocompleteSuggestion(fullName);

        String rearrangedName = DataGenerator.rearrangeFullName(fullName);
        page.fillFullName(rearrangedName)
                .verifyAutocompleteSuggestion(fullName);
    }
}
