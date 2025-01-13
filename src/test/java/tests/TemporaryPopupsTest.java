package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.TemporaryPopupsPage;

public class TemporaryPopupsTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/desktop_resolutions.csv", numLinesToSkip = 1)
    void testScenario(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        TemporaryPopupsPage popupsPage = new TemporaryPopupsPage()
                .openHomePage()
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
    void testScenarioMobile(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        TemporaryPopupsPage popupsPage = new TemporaryPopupsPage()
                .openHomePage()
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
