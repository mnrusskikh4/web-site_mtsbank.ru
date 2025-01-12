package pages;

import com.codeborne.selenide.WebDriverConditions;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TemporaryPopupsPage {

    // Локаторы для десктопной версии
    private final String creditMtsDengiPopUpLink = "a[href='/factory/karti/credit-mts-dengi/?utm_source=pop_up&utm_medium=site_mts_bank&utm_campaign=mts_dengi_credit_card&utm_content=pop_up_na_glavnoi']";
    private final String smallBusinessLink = "a[data-testid='link'][href='/malomu-biznesu/']";
    private final String bankDepositPopUpLink = "a[href='https://www.mtsbank.ru/malomu-biznesu/bankovski-depozit/pid/141648678476/?utm_source=site&utm_medium=popup&utm_campaign=dep4q2024']";
    private final String privatePersonsLink = "a[data-testid='link'][href='/']";

    // Локаторы для мобильной версии
    private final String mobileMenuButton = "button[data-testid='menu-hamburger']";
    private final String mobileSmallBusinessLink = "a[data-testid='link'][href='/malomu-biznesu/'][class*='mobile']";
    private final String mobileBankDepositPopUpLink = "a[href*='bankovski-depozit/pid/141648678476/'][class*='mobile']";

    /**
     * Открыть главную страницу МТС Банка.
     */
    public TemporaryPopupsPage openHomePage() {
        open("https://www.mtsbank.ru/");
        return this;
    }

    /**
     * Клик по popup-ссылке на кредитную карту МТС Деньги (десктоп).
     */
    public TemporaryPopupsPage clickCreditMtsDengiPopUp() {
        $(creditMtsDengiPopUpLink).shouldBe(visible, enabled).click();
        return this;
    }

    /**
     * Клик по popup-ссылке на кредитную карту МТС Деньги (мобильная версия).
     */
    public TemporaryPopupsPage clickCreditMtsDengiPopUpMobile() {
        $(mobileMenuButton).shouldBe(visible, enabled).click();
        $(creditMtsDengiPopUpLink).shouldBe(visible, enabled).click();
        return this;
    }

    /**
     * Проверить URL для кредитной карты.
     */
    public TemporaryPopupsPage verifyCreditMtsDengiUrl() {
        webdriver().shouldHave(WebDriverConditions.urlContaining("/factory/karti/credit-mts-dengi/"));
        return this;
    }

    /**
     * Клик по ссылке «Малый бизнес и ИП» (десктоп).
     */
    public TemporaryPopupsPage clickSmallBusiness() {
        $(smallBusinessLink).shouldBe(visible, enabled).click();
        return this;
    }

    /**
     * Клик по ссылке «Малый бизнес и ИП» (мобильная версия).
     */
    public TemporaryPopupsPage clickSmallBusinessMobile() {
        $(mobileMenuButton).shouldBe(visible, enabled).click();
        $(mobileSmallBusinessLink).shouldBe(visible, enabled).click();
        return this;
    }

    /**
     * Клик по popup «Банковский депозит» (десктоп).
     */
    public TemporaryPopupsPage clickBankDepositPopUp() {
        $(bankDepositPopUpLink).shouldBe(visible, enabled).click();
        return this;
    }

    /**
     * Клик по popup «Банковский депозит» (мобильная версия).
     */
    public TemporaryPopupsPage clickBankDepositPopUpMobile() {
        $(mobileMenuButton).shouldBe(visible, enabled).click();
        $(mobileBankDepositPopUpLink).shouldBe(visible, enabled).click();
        return this;
    }

    /**
     * Проверить URL для банковского депозита.
     */
    public TemporaryPopupsPage verifyBankDepositUrl() {
        webdriver().shouldHave(WebDriverConditions.urlContaining("/bankovski-depozit/pid/141648678476/"));
        return this;
    }

    /**
     * Клик по ссылке «Частным лицам».
     */
    public TemporaryPopupsPage clickPrivatePersons() {
        $(privatePersonsLink).shouldBe(visible, enabled).click();
        return this;
    }

    /**
     * Проверить, что popup-ссылка на кредитную карту МТС Деньги НЕ видна.
     */
    public TemporaryPopupsPage checkCreditMtsDengiPopUpNotVisible() {
        $(creditMtsDengiPopUpLink).shouldNotBe(visible);
        return this;
    }

    /**
     * Проверить, что popup-ссылка на «Банковский депозит» НЕ видна.
     */
    public TemporaryPopupsPage checkBankDepositPopUpNotVisible() {
        $(bankDepositPopUpLink).shouldNotBe(visible);
        return this;
    }
}
