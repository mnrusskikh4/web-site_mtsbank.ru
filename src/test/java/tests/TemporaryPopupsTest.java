package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.TemporaryPopupsPage;

public class TemporaryPopupsTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("utils.ResolutionsProvider#desktopScreenResolutions")
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
    @MethodSource("utils.ResolutionsProvider#mobileScreenResolutions")
    void testScenarioMobile(String width, String height) {
        com.codeborne.selenide.Configuration.browserSize = width + "x" + height;

        TemporaryPopupsPage popupsPage = new TemporaryPopupsPage()
                .openHomePage()
                .clickCreditMtsDengiPopUpMobile()
                .verifyCreditMtsDengiUrl()
                .clickSmallBusinessMobile()
                .clickBankDepositPopUpMobile()
                .verifyBankDepositUrl()
                .clickPrivatePersons()
                .checkCreditMtsDengiPopUpNotVisible()
                .clickSmallBusinessMobile()
                .checkBankDepositPopUpNotVisible();
    }
}
