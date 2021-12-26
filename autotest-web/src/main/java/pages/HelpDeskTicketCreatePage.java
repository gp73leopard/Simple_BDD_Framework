package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "создание тикета")
public class HelpDeskTicketCreatePage extends WebPage {

    @Name("очередь")
    private SelenideElement queueTicket = $(By.id("id_queue"));

    @Name("наименование тикета")
    private SelenideElement summaryOfTheProblem = $(By.id("id_title"));

    @Name("приоритет")
    private SelenideElement priorityTicket = $(By.id("id_priority"));

    @Name("почта")
    private SelenideElement eMailAddress = $(By.id("id_submitter_email"));

    @Name("кнопка создания нового тикета")
    private SelenideElement btnCreateTicket = $x("//button[@class='btn btn-primary btn-lg btn-block']");

}
