package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpPage extends BasePage {
    private static final SelenideElement buttonTryTest = $(By.xpath("//*[@id='et_builder_outer_content']//*[@class='btn btn-medium btn-green'][@role = 'button']"));
    public static final String WEB_ADDRESS_INPUT = "#hostname";
    public static final String FIRST_NAME_INPUT = "#first_name";
    public static final String LAST_NAME_INPUT = "#last_name";
    public static final String YOUR_COUNTRY = ".addressCountry.form-control";
    public static final String WORK_EMAIL_INPUT = "#email";
    public static final String ORGANIZATION_INPUT = "#organization";
    public static final String EXPECTED_USERS = "#users";
    public static final String CHECKBOX_AGREE = "#tos";
    public static final String BUTTON_CREATE_TESTRAIL_TRAIL = ".btn.btn-success";
    public static final String VERIFY_TEXT = "#email-confirm";

    public static void openHomePage() {
        open(HOME_PAGE);
    }

    public BasePage enterValue(String address, String firstName, String lastName, String country, String number,
                               String workEmail, String organization, String someText) {
        buttonTryTest.scrollIntoView(SCROLL_INTO_CENTER_SCRIPT).click();
        $(WEB_ADDRESS_INPUT).sendKeys(address);
        $(FIRST_NAME_INPUT).sendKeys(firstName);
        $(LAST_NAME_INPUT).setValue(lastName);
        $(YOUR_COUNTRY).selectOptionByValue(country);
        $(WORK_EMAIL_INPUT).sendKeys(workEmail);
        $(ORGANIZATION_INPUT).sendKeys(organization);
        $(EXPECTED_USERS).selectOptionByValue(String.valueOf(number));
        $(CHECKBOX_AGREE).click();
        $(BUTTON_CREATE_TESTRAIL_TRAIL).click();
        $(VERIFY_TEXT).shouldHave(text(someText));
        return new BasePage();
    }
}
