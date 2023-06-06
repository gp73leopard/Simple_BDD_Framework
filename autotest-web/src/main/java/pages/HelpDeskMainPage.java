package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "HelpDesk")
public class HelpDeskMainPage extends WebPage {

    @Name("создание нового тикета")
    private SelenideElement btnOpenTicketCreatePage = $x("//a[@href='/tickets/submit/']");

    @Name("LogIn")
    private SelenideElement btnLogIn = $x("//a[@href='/login/?next=/']");

}
