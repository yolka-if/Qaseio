package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    public void isOpened(){
        $("#createButton").shouldBe(Condition.visible);
    }

    public void createProject(String projectName, String description, String code){
        $("#createButton").click();
        $("#inputTitle").setValue(projectName);
        $("#inputCode").setValue(code);
        $("#inputDescription").setValue(description);
        $(byXpath("//label[contains(text(), 'Public')]")).click();
        $(".btn.btn-primary").click();
    }

    public void isProjectExist(String projectName){
        open("https://app.qase.io/projects");
        $(byXpath(String.format("//tbody//a[contains(text(), '%s')]", projectName))).shouldBe(Condition.visible);
    }

    public void deleteProject(String projectName) {
        open("https://app.qase.io/projects");
        $(byXpath(String.format("//a[text()='%s']", projectName))).click();
        $(byXpath("//span[text()='Settings']")).click();
        $(byXpath("//*[contains(text(), 'Delete project')]")).click();
        $(byXpath("//*[contains(text(), 'Delete project')]")).click();
    }

    public void projectNotExist(String projectName) {
        $(byXpath(String.format("//a[text()='%s']", projectName))).shouldNotBe(Condition.visible);
    }

    public void renameProject(String newName) {
        $(byXpath("//span[text()='Settings']")).click();
        $("#inputTitle").setValue(newName);
        $("#update").click();
    }
}
