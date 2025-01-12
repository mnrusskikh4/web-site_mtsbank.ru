package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SelfEmployedGuidePage {

    // Локаторы для десктопной версии
    private final String moreMenuSelector = "div.sc-3856ac7f-2.zeFLi";
    private final String selfEmployedLink = "a[data-testid='link'][href='https://www.mtsbank.ru/malomu-biznesu/samozanyatim/']";

    // Локаторы для мобильной версии
    private final String selfEmployedLinkMobile = "//a[@href='/malomu-biznesu/samozanyatim/' and @target='_self']//div[@class='sc-8eed9e1a-4' and text()='Самозанятым']";

    // Общие локаторы
    private final String badgeSpan = "span[data-testid='badge']";
    private final String checkItem = "div.CheckItem-sc-cb89gg-3";
    private final String parsedItems = "//div[contains(@class, 'InfoInner-sc-fzh47e-1') and contains(@class, 'ckmYHr')]//div[contains(@class, 'styled__SmartText-n9vm43-0')]";
            ;

    /**
     * Открывает главную страницу МТС Банка.
     */
    public SelfEmployedGuidePage openHomePage() {
        open("https://www.mtsbank.ru/");
        return this;
    }

    /**
     * Наводит курсор на «Ещё» (для десктопной версии).
     */
    public SelfEmployedGuidePage hoverMoreMenu() {
        $(moreMenuSelector).shouldBe(Condition.visible).hover();
        return this;
    }

    /**
     * Кликает по ссылке «Самозанятым» (для десктопной версии).
     */
    public SelfEmployedGuidePage clickSelfEmployedLink() {
        $(selfEmployedLink).shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Кликает по ссылке «Самозанятым» (для мобильной версии).
     */
    public SelfEmployedGuidePage clickSelfEmployedLinkMobile() {
        $(selfEmployedLinkMobile).shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Проверяет, что существует бейдж.
     */
    public SelfEmployedGuidePage checkBadgeIsVisible(String badgeText) {
        $$(badgeSpan).find(Condition.text(badgeText))
                .shouldBe(Condition.visible);
        return this;
    }

    /**
     * Кликает по бейджу.
     */
    public SelfEmployedGuidePage clickBadge(String badgeText) {
        $$(badgeSpan).find(Condition.text(badgeText))
                .shouldBe(Condition.visible)
                .click();
        return this;
    }

    /**
     * Кликает по чекбоксу.
     */
    public SelfEmployedGuidePage clickCheckItem() {
        $(checkItem).shouldBe(Condition.visible).click();
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
