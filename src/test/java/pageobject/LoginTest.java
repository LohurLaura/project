package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("http://51.250.6.164:3000/signin");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void insertIncorrectCredentialsInLogin() {
        loginPage.login.sendKeys("login");
        loginPage.password.sendKeys("password");
        loginPage.signInButton.click();
        loginPage.errorIncorrectCredentials.shouldBe(visible);
    }

    @Test
    public void insertCorrectDataAndCheckOrderPageDisplay() {
        loginPage.login.sendKeys("lauraaqa");
        loginPage.password.sendKeys("p5Twdy789");
        loginPage.signInButton.click();
        orderPageVisible.shouldBe(Condition.exist, visible);
    }

    @Test
    public void insertLoginAndLeavePasswordEmptyThenSignInButtonDisabled() {
        loginPage.login.sendKeys("login");
        loginPage.signInButton.shouldBe(Condition.disabled);
    }

    @Test
    public void insertIncorrectDataAndCheckButtonDisabledAndThenReLoginSuccessfully() {
        loginPage.password.sendKeys("password");
        loginPage.signInButton.shouldBe(Condition.disabled);
        loginPage.login.sendKeys("lauraaqa");
        loginPage.password.sendKeys("p5Twdy789");
        loginPage.signInButton.click();
    }

    @Test
    public void insertAMinimumNumberOfTwoCharactersInLogin() {
        loginPage.login.sendKeys("la");
        loginPage.password.sendKeys("p5Twdy789");
        loginPage.signInButton.click();
    }
}
