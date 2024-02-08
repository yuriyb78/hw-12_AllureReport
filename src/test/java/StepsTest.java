import com.codeborne.selenide.logevents.SelenideLogger;
import data.RespositoryName;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    RespositoryName respositoryName = new RespositoryName();
    @Test
    void stepsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу ", () -> {
            open("https://github.com");
        });

        step("Поиск респозитория " + respositoryName.repoName, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(respositoryName.repoName).pressEnter();
        });

        step("Переход в респозиторий " + respositoryName.repoName, () -> {
            $(linkText(respositoryName.repoName)).click();
        });

        step("Переход во вкладку issue", () -> {
            $("#issues-tab").click();
        });

        step("Проверка наличия записи с названием: " + respositoryName.issuieName, () -> {
            $("#issue_1_link").shouldHave(text(respositoryName.issuieName));
        }) ;


    }
}
