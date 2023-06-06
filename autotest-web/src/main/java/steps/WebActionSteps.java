package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.utils.Sleep;
import ru.lanit.at.web.pagecontext.PageManager;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class WebActionSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebActionSteps.class);

    public WebActionSteps(PageManager manager) {
        this.pageManager = manager;
    }

    /**
     * нажимает на элемент по тексту
     *
     * @param text текст элемента
     */
    @Когда("кликнуть на элемент по тексту {string}")
    public void clickElementWithText(String text) {
        $(Selectors.byText(text))
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент по тексту '{}'", text);
    }

    @Если("кликнуть на элемент {string}")
    public void clickOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент '{}'", elementName);
    }


    /**
     * Перевод с одного статуса в другой
     * Негативная проверка в соответсвии с документацией https://docs.google.com/document/d/13qUAkmFGj3jV3hEnqMlAxitKblA_BgSTKprwEW-Yg88/edit#heading=h.hq3q6bj15b2w
     * @params text... текст элемента
     */
    @Если("{string} c {string} на {string}")
    public void clickOnElement1(String btn, String checkBox1, String checkBox2) {

        try {

            SelenideElement element1 = pageManager
                    .getCurrentPage()
                    .getElement(checkBox1);
            SelenideElement element2 = pageManager
                    .getCurrentPage()
                    .getElement(checkBox2);
            SelenideElement button = pageManager
                    .getCurrentPage()
                    .getElement(btn);

            if (checkBox1.equals("Closed") && checkBox2.equals("Open") || checkBox1.equals("Closed") &&  checkBox2.equals("Duplicate")
                   || checkBox1.equals("Closed") && checkBox2.equals("Resolved") || checkBox1.equals("Open") && checkBox2.equals("Reopened")
                    || checkBox1.equals("Resolved") && checkBox2.equals("Open") || checkBox1.equals("Resolved") && checkBox2.equals("Duplicate")
                    || checkBox1.equals("Duplicate") && checkBox2.equals("Open") || checkBox1.equals("Duplicate") && checkBox2.equals("Closed")
                    || checkBox1.equals("Duplicate") && checkBox2.equals("Resolved") || checkBox1.equals("Reopened") && checkBox2.equals("Open")) {

                throw new IllegalArgumentException("Переход из статуса в статус невозможен!");
            } else {
                element1
                        .shouldBe(Condition.visible)
                        .click();
                button
                        .shouldBe(Condition.visible)
                        .click();
                LOGGER.info("клик на элемент '{}'", btn);
            }
        } catch (IllegalArgumentException ex) {
            return;
        }
        throw new IllegalArgumentException("Позитивный исход");
    }

    /**
     * скролл до элемента
     *
     * @param elementName наименование элемента
     */


    @Когда("проскроллить страницу до элемента {string}")
    public void scrollToElement(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до элемента '{}'", elementName);
    }


    /**
     * Добавить txt файл в качестве вложения
     *
     *
     */

    @Когда("добавить файл в аттач")
    public void uploadFile(){
        $x("//input[@type='file']").uploadFile(new File("./autotest-web/src/test/resources/test.txt"));
    }

    /**
     * скролл до текста
     *
     * @param text текст
     */
    @Когда("проскроллить страницу до текста {string}")
    public void scrollToText(String text) {
        SelenideElement element = $(Selectors.byText(text));
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до текста '{}'", text);
    }

    @И("подождать {int} сек")
    public void waitSeconds(int timeout) {
        Sleep.pauseSec(timeout);
    }

    /**
     * Ввод значения в элемент
     *
     * @param field - наименование элемента
     * @param value - значение
     */
    @Когда("ввести в поле {string} значение {string}")
    public void fillTheField(String field, String value) {
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        fieldElement
                .shouldBe(Condition.visible)
                .setValue(value);
        LOGGER.info("в поле '{}' введено значение '{}'", field, value);
    }

    @Когда("выбрать из списка {string} опцию {string}")
    public void selectOption(String select, String value){
        SelenideElement selectElement = pageManager
                .getCurrentPage()
                .getElement(select);
        selectElement
                .shouldBe(Condition.visible)
                .selectOption(value);
        LOGGER.info("в списке '{}' выбрана опция'{}'", select, value);
    }


    /**
     * Очистка поля
     *
     * @param elementName наименование элемента
     */
    @Если("очистить поле {string}")
    public void clearFiled(String elementName) {
        pageManager
                .getCurrentPage()
                .getElement(elementName)
                .shouldBe(Condition.visible)
                .clear();
    }
}
