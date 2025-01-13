package tests;

import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.TemporaryPopupsPage;

@Epic("Тестирование временных попапов")
@Feature("Попапы для различных категорий пользователей")
public class TemporaryPopupsTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
    @Story("Тестирование попапов на десктопных разрешениях")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка отображения и закрытия попапов для различных категорий пользователей на десктопных разрешениях")
    void testScenario(String width, String height) {
        Allure.step("Установлен размер окна браузера: " + width + "x" + height);
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        TemporaryPopupsPage popupsPage = new TemporaryPopupsPage();

        popupsPage.openHomePage()
                .clickCreditMtsDengiPopUp()
                .verifyCreditMtsDengiUrl()
                .clickSmallBusiness()
                .clickBankDepositPopUp()
                .verifyBankDepositUrl()
                .clickPrivatePersons()
                .checkCreditMtsDengiPopUpNotVisible()
                .clickSmallBusiness()
                .checkBankDepositPopUpNotVisible();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/mobile_resolutions.csv", numLinesToSkip = 1)
    @Story("Тестирование попапов на мобильных разрешениях")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка отображения и закрытия попапов для различных категорий пользователей на мобильных разрешениях")
    void testScenarioMobile(String width, String height) {
        Allure.step("Установлен размер окна браузера: " + width + "x" + height);
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        TemporaryPopupsPage popupsPage = new TemporaryPopupsPage();

        popupsPage.openHomePage()
                .clickCreditMtsDengiPopUpMobile()
                .verifyCreditMtsDengiUrl()
                .openSmallBusinessPageMobile()
                .clickBankDepositPopUpMobile()
                .verifyBankDepositUrl()
                .clickPrivatePersons()
                .checkCreditMtsDengiPopUpNotVisible()
                .openSmallBusinessPageMobile()
                .checkBankDepositPopUpNotVisible();
    }
}
