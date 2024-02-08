import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true; // Чтобы браузер не закрывался после выполенения теста
    }
}
