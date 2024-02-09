import com.codeborne.selenide.logevents.SelenideLogger;
import data.RepositoryName;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    RepositoryName repositoryName = new RepositoryName();

    @Test
    void stepsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу ", () -> {
            open("https://github.com");
        });

        step("Поиск репозитория " + repositoryName.repoName, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(repositoryName.repoName).pressEnter();
        });

        step("Переход в репозиторий " + repositoryName.repoName, () -> {
            $(linkText(repositoryName.repoName)).click();
        });

        step("Переход во вкладку issue", () -> {
            $("#issues-tab").click();
        });

        step("Проверка наличия записи с названием: " + repositoryName.issuieName, () -> {
            $("#issue_1_link").shouldHave(text(repositoryName.issuieName));
        }) ;


    }
}
