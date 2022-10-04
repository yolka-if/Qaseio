package tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class ProjectTest extends BaseTest {
    Faker fakerName = new Faker();
    Faker fakerCode = new Faker();
    String projectName = fakerName.funnyName().name();
    String code = fakerCode.color().name();

    @Test
    public void createProject() {
        loginPage.openPage();
        loginPage.login(login, password);
        projectsPage.createProject(projectName, "Test", code);
        projectsPage.isProjectExist(projectName);
        projectsPage.isProjectExist(projectName);
    }

    @Test
    public void deletePtoject() {
        loginPage.openPage();
        loginPage.login(login, password);
        projectsPage.createProject(projectName, "Test", code);
        projectsPage.deleteProject(projectName);
        $(byXpath(String.format("//a[text()='%s']", projectName))).shouldNotBe(Condition.visible);
    }

    @Test
    public void renameProject() {
        loginPage.openPage();
        loginPage.login(login, password);
        projectsPage.createProject(projectName, "Test", code);
        projectsPage.renameProject();
        projectsPage.isProjectExist("Переименован");
    }
}
