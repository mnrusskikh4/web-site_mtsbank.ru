package tests;

import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.MtsDengiCardFormPage;
import utils.DataGenerator;

import static com.codeborne.selenide.Selenide.*;

@Epic("Тестирование формы оформления карты МТС Деньги")
@Feature("Оформление карты на десктопе и мобильных устройствах")
public class MtsDengiCardFormTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
    @Story("Тестирование формы на десктопных разрешениях")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнения всех полей формы на десктопе и работы автозамены ФИО")
    void testFormFillingDesktop(String width, String height) {
        Allure.step("Установлен размер окна браузера: " + width + "x" + height);
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        Allure.step("Открыть главную страницу и выполнить тестовый сценарий для десктопа");
        MtsDengiCardFormPage page = new MtsDengiCardFormPage()
                .openHomePage()
                .clickYesButton()
                .hoverCardsLink()
                .clickCreditCardLink();

        Allure.step("Проверить, что текущий URL начинается с URL страницы карты");
        webdriver().shouldHave(WebDriverConditions.urlStartingWith("https://www.mtsbank.ru/factory/karti/credit-mts-dengi/"));

        Allure.step("Заполнить телефон, дату рождения и email");
        page.fillPhone(DataGenerator.generatePhoneNumber())
                .fillBirthDate(DataGenerator.generateBirthDate())
                .fillEmail(DataGenerator.generateEmail());

        Allure.step("Проверить автозаполнение ФИО");
        String fullName = DataGenerator.generateFullName();
        page.fillFullName(fullName)
                .verifyAutocompleteSuggestion(fullName);

        Allure.step("Проверить автозамену после перестановки ФИО");
        String rearrangedName = DataGenerator.rearrangeFullName(fullName);
        page.fillFullName(rearrangedName)
                .verifyAutocompleteSuggestion(fullName);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
    @Story("Тестирование формы на мобильных разрешениях")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнения всех полей формы на мобильных устройствах и работы автозамены ФИО")
    void testFormFillingMobile(String width, String height) {
        Allure.step("Установлен размер окна браузера: " + width + "x" + height);
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        Allure.step("Открыть страницу оформления карты и выполнить тестовый сценарий для мобильного устройства");
        MtsDengiCardFormPage page = new MtsDengiCardFormPage()
                .openCardFormPage();

        Allure.step("Проверить, что текущий URL начинается с URL страницы карты");
        webdriver().shouldHave(WebDriverConditions.urlStartingWith("https://www.mtsbank.ru/factory/karti/credit-mts-dengi/"));

        Allure.step("Заполнить телефон, дату рождения и email");
        page.fillPhone(DataGenerator.generatePhoneNumber())
                .fillBirthDate(DataGenerator.generateBirthDate())
                .fillEmail(DataGenerator.generateEmail());

        Allure.step("Проверить автозаполнение ФИО");
        String fullName = DataGenerator.generateFullName();
        page.fillFullName(fullName)
                .verifyAutocompleteSuggestion(fullName);

        Allure.step("Проверить автозамену после перестановки ФИО");
        String rearrangedName = DataGenerator.rearrangeFullName(fullName);
        page.fillFullName(rearrangedName)
                .verifyAutocompleteSuggestion(fullName);
    }
}