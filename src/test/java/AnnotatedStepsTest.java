import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    WebSteps webSteps = new WebSteps();
    TestData testData = new TestData();

    @Test
    void annotedStepsTest (){
        SelenideLogger.addListener("allure", new AllureSelenide());

        webSteps.openMainPage();
        webSteps.findRepository(testData.repoName);
        webSteps.openReposytory(testData.repoName);
        webSteps.openIssue();
        webSteps.checkIssueName(testData.issuieName);


    }
}
