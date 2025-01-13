/**
 * Перестал работать, проблема с отсутствием реакции на вызов фильтра.
 */


//package pages;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.Selenide;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import static com.codeborne.selenide.Selenide.*;
//
//public class RampOfficesPage {
//
//    // Локаторы для десктопной версии
//    private final String listTabDesktop = "//div[text()='Списком']";
//    private final String arrowDownDesktop = "//div[@data-testid='flexbox' and contains(@class, 'Inner-sc-1rfqasg-0') and contains(@class, 'bqTsRY')]";
//
//    // Локаторы для мобильной версии
//    private final String listTabMobile = "//div[contains(@class, 'TabText-sc-tyqhzb-3') and contains(text(), 'Списком')]";
//    private final String arrowDownMobile = "//div[@data-testid='flexbox' and contains(@class, 'Inner-sc-1rfqasg-0') and contains(@class, 'bqTsRY')]";
//    private final String acceptButtonMobile = "//div[@data-testid='text' and text()='Применить']";
//
//
//    // Общие локаторы
//    private final String workingNowCheck = "//div[@type='checkbox' and contains(@class, 'CheckItem-sc-cb89gg-3') and contains(@class, 'fJkfwj')]";
//    private final String rampCheck = "//div[@type='checkbox' and contains(@class, 'CheckItem-sc-cb89gg-3') and contains(@class, 'bBBzzn')]";
//    private final String rampTextSelector = "div[data-testid='text'][color='#000000'].Wrapper-sc-1vydk7-0.styled__TextWithIndent-sc-egp5sf-4.jtxciP";
//    private final String nextPageButton = "button.PaginationBtn-sc-13zz2b5-2:has(svg[data-testid='icon_baseX24/arrowRight'])";
//
//    /**
//     * Открывает страницу "Офисы и банкоматы" МТС Банка.
//     */
//    public RampOfficesPage openOfficesPage() {
//        open("https://www.mtsbank.ru/ofisi-i-bankomati/");
//        return this;
//    }
//
//    /**
//     * Открывает вкладку "Списком" (для десктопной или мобильной версии).
//     */
//    public RampOfficesPage clickListTab(boolean isMobile) {
//        String locator = isMobile ? listTabMobile : listTabDesktop;
//        $x(locator).shouldBe(Condition.visible, Condition.enabled).click();
//        return this;
//    }
//
//    /**
//     * Раскрывает список фильтров (для десктопной или мобильной версии).
//     */
//    public RampOfficesPage clickArrowDown(boolean isMobile) {
//        String locator = isMobile ? arrowDownMobile : arrowDownDesktop;
//
//        $x(locator).shouldBe(Condition.visible, Condition.enabled).click();
//
//        return this;
//    }
//
//    /**
//     * Снимает выбор чекбокса "Работает сейчас".
//     */
//    public RampOfficesPage clickCheckboxWorkingNow() {
//        Selenide.executeJavaScript("arguments[0].click();",
//                $x(workingNowCheck).shouldBe(Condition.visible, Condition.enabled));
//        return this;
//    }
//
//    /**
//     * Устанавливает выбор чекбокса "Есть пандус".
//     */
//    public RampOfficesPage clickCheckboxHasRamp() {
//        Selenide.executeJavaScript("arguments[0].click();",
//                $x(rampCheck).shouldBe(Condition.visible, Condition.enabled));
//        return this;
//    }
//
//    /**
//     * Кликает по кнопке "Применить" после установки чекбоксов (для мобильной версии).
//     */
//    public RampOfficesPage clickAcceptButtonMobile() {
//        $(acceptButtonMobile).shouldBe(Condition.visible, Condition.enabled).click();
//        return this;
//    }
//
//    /**
//     * Парсит с карточек результатов фильтрации "Оборудован пандусом"
//     * переходит по всем страницам.
//     */
//    public List<String> getAllRampTextsFromAllPages() {
//        List<String> allTexts = new ArrayList<>();
//        do {
//            List<String> currentPageTexts = $$(rampTextSelector)
//                    .filterBy(Condition.visible)
//                    .texts();
//            allTexts.addAll(currentPageTexts);
//
//            if ($(nextPageButton).exists() && $(nextPageButton).is(Condition.enabled)) {
//                $(nextPageButton).click();
//            } else {
//                break;
//            }
//        } while (true);
//
//        return allTexts;
//    }
//
//    /**
//     * Сортирует результаты фильтрации,
//     * выводит дополнительную информацию в консоль.
//     */
//    public void analyzeRampTexts(List<String> rampTexts) {
//        long countRampText = rampTexts.stream()
//                .filter(text -> text.trim().equals("Оборудован пандусом"))
//                .count();
//
//        Map<String, Long> differentTextCounts = rampTexts.stream()
//                .filter(text -> !text.trim().equals("Оборудован пандусом"))
//                .collect(Collectors.groupingBy(text -> text, Collectors.counting()));
//
//        System.out.println("Общее количество элементов с текстом 'Оборудован пандусом': " + countRampText);
//
//        if (!differentTextCounts.isEmpty()) {
//            System.out.println("Уникальные отличные элементы и их количество:");
//            differentTextCounts.forEach((text, count) ->
//                    System.out.println("'" + text + "'" + ": " + count));
//        } else {
//            System.out.println("Отличных элементов нет");
//        }
//    }
//}
