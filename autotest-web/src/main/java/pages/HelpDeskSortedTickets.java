package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "страница отсортированных тикетов")
public class HelpDeskSortedTickets extends WebPage {

    @Name("первый закрытый тикет")
    private SelenideElement closedTicket = $x("//div[@class='tickettitle']");

    @Name("вкладка сохранить запрос")
    private SelenideElement saveQuery = $x("//button[@class='btn btn-link collapsed btn-sm']");

    @Name("имя запроса")
    private SelenideElement nameQuery = $(By.id("id_title"));

    @Name("кнопка сохранить запрос")
    private SelenideElement btnSaveQuery = $x("//input[@value='Save Query']");

    @Name("прошарить запрос")
    private SelenideElement sharedQuery = $(By.id("id_shared"));

}
