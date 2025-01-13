package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class MtsDengiCardFormPage {

    // Локаторы
    private final String yesButton = "//div[@data-testid='text' and @class='Wrapper-sc-716ec093-0 bueBOy ButtonText-sc-16137b7a-2 dSUYrE' and text()='Да, верно']";
    private final String cardsLink = "a[data-testid='link'][href='/chastnim-licam/karti/']";
    private final String creditCardMtsDengiLink = "a[data-testid='link'][href*='credit-mts-dengi']";

    // Мобильные локаторы
    private final String mobileMenuButton = "button[data-testid='mobile-menu-button']";
    private final String mobileCardsLink = "a[data-testid='mobile-link'][href='/chastnim-licam/karti/']";
    private final String mobileCreditCardMtsDengiLink = "a[data-testid='mobile-link'][href*='credit-mts-dengi']";

    private final String phoneInput = "input[placeholder='+7 000 000-00-00']";
    private final String birthDateInput = "input[placeholder='дд.мм.гггг']";
    private final String emailInput = "input[placeholder='mail@example.ru']";
    private final String fullNameTextarea = "textarea[name='clientFio']";
    private final String suggestionList = "ul[role='listbox']";
    private final String suggestionItem = "ul[role='listbox'] li";

    public MtsDengiCardFormPage openHomePage() {
        open("https://www.mtsbank.ru/");
        return this;
    }

    public MtsDengiCardFormPage clickYesButton() {
        $x(yesButton).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    public MtsDengiCardFormPage hoverCardsLink() {
        $(cardsLink).shouldBe(Condition.visible).hover();
        return this;
    }

    public MtsDengiCardFormPage clickCreditCardLink() {
        $(creditCardMtsDengiLink).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    // Мобильные методы
    public MtsDengiCardFormPage openCardFormPage() {
        open("https://www.mtsbank.ru/factory/karti/credit-mts-dengi/");
        return this;
    }

    public MtsDengiCardFormPage openMobileMenu() {
        $(mobileMenuButton).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    public MtsDengiCardFormPage clickMobileCardsLink() {
        $(mobileCardsLink).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    public MtsDengiCardFormPage clickMobileCreditCardLink() {
        $(mobileCreditCardMtsDengiLink).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    public MtsDengiCardFormPage fillPhone(String phone) {
        $(phoneInput).shouldBe(Condition.visible, Condition.enabled).setValue(phone);
        return this;
    }

    public MtsDengiCardFormPage fillBirthDate(String birthDate) {
        $(birthDateInput).shouldBe(Condition.visible, Condition.enabled).setValue(birthDate);
        return this;
    }

    public MtsDengiCardFormPage fillEmail(String email) {
        $(emailInput).shouldBe(Condition.visible, Condition.enabled).setValue(email);
        return this;
    }

    public MtsDengiCardFormPage fillFullName(String fullName) {
        $(fullNameTextarea).shouldBe(Condition.visible).setValue(fullName);
        return this;
    }

    public MtsDengiCardFormPage verifyAutocompleteSuggestion(String expectedText) {
        $(suggestionList).shouldBe(Condition.visible);
        $(suggestionItem).shouldHave(Condition.text(expectedText));
        return this;
    }
}
