package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "вход в систему")
public class HelpDeskLoginPage extends WebPage {

    @Name("имя пользователя")
    private SelenideElement usernameField = $(By.id("username"));

    @Name("пароль")
    private SelenideElement passwordField = $(By.id("password"));

    @Name("кнопка подтверждения логина")
    private SelenideElement btnConfirmLogIn = $x(("//input[@class='btn btn-lg btn-primary btn-block']"));
}
