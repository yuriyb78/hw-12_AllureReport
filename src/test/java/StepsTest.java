import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    TestData testData = new TestData();

    @Test
    void stepsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу ", () -> {
            open("https://github.com");
        });

        step("Поиск репозитория " + testData.repoName, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(testData.repoName).pressEnter();
        });

        step("Переход в репозиторий " + testData.repoName, () -> {
            $(linkText(testData.repoName)).click();
        });

        step("Переход во вкладку issue", () -> {
            $("#issues-tab").click();
        });

        step("Проверка наличия записи с названием: " + testData.issuieName, () -> {
            $("#issue_1_link").shouldHave(text(testData.issuieName));
        }) ;


    }
}
