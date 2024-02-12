import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideWithListenerTest {

    TestData testData = new TestData();

    @Test
    void selenideWithListenerTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".search-input-container").click();
        $("#query-builder-test").setValue(testData.repoName).pressEnter();
        $(linkText(testData.repoName)).click();
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(text(testData.issuieName));

    }
}
