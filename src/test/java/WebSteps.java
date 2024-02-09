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
    @Step("Поиск репозитория {repoNmae}" )
    public void findRepository (String repoNmae) {
        $(".search-input-container").click();
        $("#query-builder-test").setValue(repoNmae).pressEnter();
    }
    @Step("Переход в репозиторий {repoNmae}")
    public void openReposytory (String repoNmae) {
        $(linkText(repoNmae)).click();
    }
    @Step("Переход во вкладку issue")
    public void openIssue () {
        $("#issues-tab").click();
    }

    @Step("Проверка наличия записи с названием: {issueName}")
    public void checkIssueName (String issueName) {
        $("#issue_1_link").shouldHave(text(issueName));
    }

}
