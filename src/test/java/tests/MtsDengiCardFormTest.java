package tests;

import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MtsDengiCardFormPage;
import utils.DataGenerator;

import static com.codeborne.selenide.Selenide.*;

public class MtsDengiCardFormTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("utils.ResolutionsProvider#desktopScreenResolutions")
    void testFormFilling(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        // 1. Открытие страницы и переход на нужный раздел
        MtsDengiCardFormPage page = new MtsDengiCardFormPage()
                .openHomePage()
                .clickYesButton()
                .hoverCardsLink()
                .clickCreditCardLink();

        // 2. Проверяем URL, что мы попали на нужную страницу
        webdriver().shouldHave(WebDriverConditions
                   .urlStartingWith("https://www.mtsbank.ru/factory/karti/credit-mts-dengi/"));

        // 3. Заполняем поля: телефон, дата рождения, email
        page.fillPhone(DataGenerator.generatePhoneNumber())
            .fillBirthDate(DataGenerator.generateBirthDate())
            .fillEmail(DataGenerator.generateEmail());

        // 4. Проверка автоподсказки
        String fullName = DataGenerator.generateFullName();
        page.fillFullName(fullName)
            .verifyAutocompleteSuggestion(fullName);

        // 5. Проверка при перестановке ФИО
        String rearrangedName = DataGenerator.rearrangeFullName(fullName);
        page.fillFullName(rearrangedName)
            .verifyAutocompleteSuggestion(fullName);
    }
}
