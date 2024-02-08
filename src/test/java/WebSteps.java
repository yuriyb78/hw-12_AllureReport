import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage () {
        open("https://github.com");
    }
    @Step("Поиск репозитория {repo}" )
    public void findRepository (String repo) {
        $(".search-input-container").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }
    @Step("Переход в репозиторий {repo}")
    public void openReposytory (String repo) {
        $(linkText(repo)).click();
    }
    @Step("Переход во вкладку issue")
    public void openIssue () {
        $("#issues-tab").click();
    }

    @Step("Проверка наличия записи с названием: {issue}")
    public void checkIssueName (String issue) {
        $("#issue_1_link").shouldHave(text(issue));
    }

}
