import com.codeborne.selenide.logevents.SelenideLogger;
import data.RepositoryName;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotetedStepsTest {

    WebSteps webSteps = new WebSteps();
    RepositoryName repositoryName = new RepositoryName();

    @Test
    void annotedStepsTest (){
        SelenideLogger.addListener("allure", new AllureSelenide());

        webSteps.openMainPage();
        webSteps.findRepository(repositoryName.repoName);
        webSteps.openReposytory(repositoryName.repoName);
        webSteps.openIssue();
        webSteps.checkIssueName(repositoryName.issuieName);


    }
}
