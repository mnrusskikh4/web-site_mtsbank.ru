package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SelfEmployedGuidePage {

    // Общие локаторы
    private final String badgeSpan = "//span[contains(@class, 'Wrapper-sc-1vwahr7-0') and contains(@class, 'efdXbw') and .//div[text()='Я не клиент банка']]";
    private final String checkItem = "//div[@type='checkbox' and contains(@class, 'CheckItem-sc-cb89gg-3')]";
    private final String parsedItems = "//div[contains(@class, 'InfoInner-sc-fzh47e-1') and contains(@class, 'ckmYHr')]//div[contains(@class, 'styled__SmartText-n9vm43-0')]";


    /**
     * Открывает страницу "Самозанятым".
     */
    public SelfEmployedGuidePage openSelfEmployedPage() {
        open("https://www.mtsbank.ru/malomu-biznesu/samozanyatim/");
        return this;
    }

    /**
     * Проверяет, что существует бейдж.
     */
    public SelfEmployedGuidePage checkBadgeIsVisible() {
        $x(badgeSpan).shouldBe(Condition.visible);
        return this;
    }

    /**
     * Кликает по чекбоксу.
     */
    public SelfEmployedGuidePage clickCheckItem() {
        Selenide.executeJavaScript("arguments[0].click();", $x(checkItem).shouldBe(Condition.visible));
        return this;
    }


    /**
     * Парсит текст из блоков.
     */
    public List<String> parseValues() {
        // Ждём, пока элементы появятся
        $$x(parsedItems).shouldHave(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(3));

        // Парсим текст видимых элементов
        return $$x(parsedItems)
                .filterBy(Condition.visible)
                .texts();
    }
}
