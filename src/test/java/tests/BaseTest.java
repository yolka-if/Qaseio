package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectsPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    LoginPage loginPage;
    ProjectsPage projectsPage;
    String login;
    String password;

    @BeforeMethod
    public void setup() {
        Configuration.baseUrl = System.getProperty("QASE_URL",
                PropertyReader.getProperty("qase.url"));

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));

        Configuration.browser = "chrome";
        //   Configuration.headless = true;
        Configuration.timeout = 10000;
        login = PropertyReader.getProperty("qase.login");
        password = PropertyReader.getProperty("qase.password");

        // Configuration.clickViaJs = true;
        // Configuration.assertionMode = AssertionMode.STRICT;
        // всегда кликать чере js
        Configuration.fastSetValue = true;
        //не закрывать браузер после теста
        // Configuration.holdBrowserOpen = true;
        //

        open();
        getWebDriver().manage().window().maximize();

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
