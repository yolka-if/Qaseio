package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void openQase() {
        loginPage.openPage();

        loginPage.login(login, password);
        projectsPage.isOpened();
    }
}
