package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class DepositCalculatorPage {

    public static final String DEPOSIT_PAGE_URL = "https://www.mtsbank.ru/malomu-biznesu/bankovski-depozit/";
    private final String durationTextSelector = "div.styled__SmartText-n9vm43-0.bKvEkp";

    /**
     * Открывает страницу с депозитным калькулятором.
     */
    public DepositCalculatorPage openDepositPage() {
        open(DEPOSIT_PAGE_URL);
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

}
