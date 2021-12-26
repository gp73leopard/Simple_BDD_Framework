package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "страница с тикетами")
public class HelpDeskAllTicketsPage extends WebPage {

    @Name("создание нового тикета")
    private SelenideElement btnOpenTicketCreatePage = $x("//a[@href='/tickets/submit/']");

    @Name("удаление фильтра")
    private SelenideElement deleteFiltr = $x("//li[@id='filterBoxStatus']//button[@class='filterBuilderRemove btn btn-danger btn-sm float-right']");

    @Name("добавить фильтр")
    private SelenideElement addFilter = $(By.id("filterBuilderSelect"));

    @Name("статус")
    private SelenideElement selectStatus = $(By.id("id_statuses"));

    @Name("кнопка применения фильтра")
    private SelenideElement btnApplyFilter = $x("//input[@class='btn btn-primary btn-sm']");

    @Name("ключевые слова")
    private SelenideElement keyWordsFilter = $(By.id("id_query"));

    @Name("очередь")
    private SelenideElement queueFilter = $(By.id("id_queues"));

    @Name("вкладка сохраненных запросов")
    private SelenideElement savedQueries = $x("//button[@class='btn btn-link collapsed btn-sm']/i[@class='fas fa-clipboard-check']");

    @Name("список сохраненных запросов")
    private SelenideElement savedSelectQueries = $(By.id("id_query_selector"));

    @Name("кнопка запуска запроса")
    private SelenideElement runQuery = $x("//input[@value='Run Query']");



}
