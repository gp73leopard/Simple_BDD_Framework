package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "страница тикета")
public class HelpDeskTicketPage extends WebPage {

    @Name("Open")
    private SelenideElement checkBoxOpen = $(By.id("st_open"));

    @Name("Closed")
    private SelenideElement checkBoxClosed = $(By.id("st_closed"));

    @Name("Resolved")
    private SelenideElement checkBoxResolved = $(By.id("st_resolved"));

    @Name("Reopened")
    private SelenideElement checkBoxReopened = $(By.id("st_reopened"));

    @Name("Duplicate")
    private SelenideElement checkBoxDuplicate = $(By.id("st_duplicate"));

    @Name("добавить файл")
    private SelenideElement attachFile = $(By.id("ShowFileUpload"));

    @Name("обзор")
    private SelenideElement browse =$x(("//label[@class='btn btn-primary btn-sm btn-file']"));
    @Name("добавленный файл")
    private SelenideElement addedFile =$(By.id("selectedfilename0"));

    @Name("обновить тикет")
    private SelenideElement btnUpdateTicket = $x(("//button[@class='btn btn-primary float-right']"));
}
