package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public void openPage(){
        open("/login");
    }
    @Step("Login")
    public void login(String login, String password){
        $("#inputEmail").setValue(login);
        $("#inputPassword").setValue(password);
        $("#btnLogin").click();
    }
}
