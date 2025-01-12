package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class DepositCalculatorPage {

    // Общие локаторы
    private final String businessButton = "[data-testid='button'][tabindex='0'].Wrapper-sc-16137b7a-1";
    private final String smallBusinessLink = "a[data-testid='link'][href='/malomu-biznesu/']";
    private final String depositHoverLink = "a[data-testid='link'][href='/malomu-biznesu/bankovski-depozit/']";
    private final String openDepositOnline = "a[data-testid='link'][href='/malomu-biznesu/bankovski-depozit/'].LinkWrapper-sc-a7l7fm-0.dwarbb.sc-hHfuMS.kkNLiu";
    private final String durationTextSelector = "div.styled__SmartText-n9vm43-0.bKvEkp";

    // Локаторы для мобильной версии
    private final String mobileMenuButton = "//button[contains(@class, 'styled__MenuItem-sc-d8a6a351-2') and .//span[@data-testid='text' and text()='Бизнесу']]";
    private final String businessButtonMobile = "//div[@class='styled__SmartText-sc-bd556393-0' and @color='#000000' and text()='Малый бизнес']";
    private final String depositMenuMobile = "//div[@class='styled__SmartText-n9vm43-0 hElNop' and text()='Депозиты']";

    /**
     * Открывает главную страницу.
     */
    public DepositCalculatorPage openHomePage() {
        open("https://www.mtsbank.ru/");
        return this;
    }

    /**
     * Кликает на кнопку "Все для бизнеса".
     */
    public DepositCalculatorPage clickBusinessButton() {
        $(businessButton).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    /**
     * Кликает на ссылку "Малый бизнес и ИП".
     */
    public DepositCalculatorPage clickSmallBusinessLink() {
        $(smallBusinessLink).shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Наводит курсор на ссылку "Депозиты".
     */
    public DepositCalculatorPage hoverDepositLink() {
        $(depositHoverLink).shouldBe(Condition.visible).hover();
        return this;
    }

    /**
     * Кликает "Открыть депозит онлайн".
     */
    public DepositCalculatorPage clickOpenDepositOnline() {
        $(openDepositOnline).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    /**
     * Устанавливает значение слайдера.
     * @param sliderIndex - индекс слайдера (0 - сумма, 1 - срок)
     * @param value       - значение для ввода
     */
    public DepositCalculatorPage setSliderValue(int sliderIndex, String value) {
        SelenideElement slider = $$("[data-testid='input-slider']")
                .get(sliderIndex)
                .should(Condition.exist)
                .shouldBe(Condition.visible, Condition.enabled);

        slider.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        slider.setValue(value);
        Selenide.sleep(1000);

        return this;
    }

    public String getDurationText() {
        return $(durationTextSelector).shouldBe(Condition.visible).getText();
    }

    // Методы для мобильной версии
    /**
     * Открывает мобильное меню "Бизнесу".
     */
    public DepositCalculatorPage clickMobileMenu() {
        $x(mobileMenuButton).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    /**
     * Кликает "Малый бизнес".
     */
    public DepositCalculatorPage clickBusinessButtonMobile() {
        $x(businessButtonMobile).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    /**
     * Кликает "Депозиты".
     */
    public DepositCalculatorPage clickDepositMenuMobile() {
        $x(depositMenuMobile).shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }
}
