package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    String EMAIL_INPUT = "#name";
    String PASSWORD_INPUT = "#password";
    String LOGIN_BUTTON = "#button_primary";
    String DASHBOARD = "#navigation-dashboard";

    public static void openDashboardPage() {
        open(DASHBOARD_URL);
    }

    @Step("Login as email: '{email}' with password: '{password}'")
    public void login(String email, String password) {
        log.info("Type text: '{email}' into username input and text: '{password}' into password input");
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
    }

    public String getDashboardText() {
        return $(DASHBOARD).getText();
    }
}
