package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;


public class ProjectTest extends BaseTest {
    Faker fakerName = new Faker();
    Faker fakerCode = new Faker();

    @Test
    public void createProject() {
        String projectName = fakerName.funnyName().name();
        String code = fakerCode.color().name();
        loginPage.openPage();
        loginPage.login(login, password);
        projectsPage.createProject(projectName, "Test", code);
        projectsPage.isProjectExist(projectName);
    }

    @Test
    public void deletePtoject() {
        String projectName = fakerName.funnyName().name();
        String code = fakerCode.color().name();
        loginPage.openPage();
        loginPage.login(login, password);
        projectsPage.createProject(projectName, "Test", code);
        projectsPage.deleteProject(projectName);
        projectsPage.projectNotExist(projectName);

    }

    @Test
    public void renameProject() {
        String projectName = fakerName.funnyName().name();
        String code = fakerCode.color().name();
        String newName = "Переименован";
        loginPage.openPage();
        loginPage.login(login, password);
        projectsPage.createProject(projectName, "Test", code);
        projectsPage.renameProject(newName);
        projectsPage.isProjectExist(newName);
    }
}
