package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class MtsDengiCardFormPage {

    // Локаторы
    private final String yesButton = "//div[@data-testid='text' and @class='Wrapper-sc-716ec093-0 bueBOy ButtonText-sc-16137b7a-2 dSUYrE' and text()='Да, верно']";
    private final String cardsLink = "a[data-testid='link'][href='/chastnim-licam/karti/']";
    private final String creditCardMtsDengiLink = "a[data-testid='link'][href*='credit-mts-dengi']";
    private final String phoneInput = "input[placeholder='+7 000 000-00-00']";
    private final String birthDateInput = "input[placeholder='дд.мм.гггг']";
    private final String emailInput = "input[placeholder='mail@example.ru']";
    private final String fullNameTextarea = "textarea[name='clientFio']";
    private final String suggestionList = "ul[role='listbox']";
    private final String suggestionItem = "ul[role='listbox'] li";

    /**
     * Открывает главную страницу МТС Банка.
     */
    public MtsDengiCardFormPage openHomePage() {
        open("https://www.mtsbank.ru/");
        return this;
    }

    /**
     * Кликает на кнопку "Да, верно".
     */
    public MtsDengiCardFormPage clickYesButton() {
        $x(yesButton).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    /**
     * Наводит курсор на ссылку «Карты».
     */
    public MtsDengiCardFormPage hoverCardsLink() {
        $(cardsLink).shouldBe(Condition.visible).hover();
        return this;
    }

    /**
     * Кликает на ссылку «Кредитная карта МТС Деньги».
     */
    public MtsDengiCardFormPage clickCreditCardLink() {
        $(creditCardMtsDengiLink).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    /**
     * Заполняет поле телефона.
     */
    public MtsDengiCardFormPage fillPhone(String phone) {
        $(phoneInput).shouldBe(Condition.visible, Condition.enabled).setValue(phone);
        return this;
    }

    /**
     * Заполняет поле даты рождения.
     */
    public MtsDengiCardFormPage fillBirthDate(String birthDate) {
        $(birthDateInput).shouldBe(Condition.visible, Condition.enabled).setValue(birthDate);
        return this;
    }

    /**
     * Заполняет поле email.
     */
    public MtsDengiCardFormPage fillEmail(String email) {
        $(emailInput).shouldBe(Condition.visible, Condition.enabled).setValue(email);
        return this;
    }

    /**
     * Заполняет поле ФИО.
     */
    public MtsDengiCardFormPage fillFullName(String fullName) {
        $(fullNameTextarea).shouldBe(Condition.visible).setValue(fullName);
        return this;
    }

    /**
     * Проверяет, что автоподсказка содержит ожидаемый текст.
     */
    public MtsDengiCardFormPage verifyAutocompleteSuggestion(String expectedText) {
        $(suggestionList).shouldBe(Condition.visible);
        $(suggestionItem).shouldHave(Condition.text(expectedText));
        return this;
    }
}

