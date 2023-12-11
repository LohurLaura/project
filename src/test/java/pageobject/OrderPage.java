package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Sleeper;

import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {
    public SelenideElement name = $x("//input[@data-name='username-input']");
    public SelenideElement phone = $x("//input[@data-name='phone-input']");
    public SelenideElement comment = $x("//input[@data-name='comment-input']");
    public SelenideElement orderButton = $x("//button[@data-name='createOrder-button']");
    public SelenideElement confirmationPopUp = $x("//*[data-name = 'orderSuccessfullyCreated-popup']");
    public SelenideElement statusButton = $x("//button[data-name = 'openStatusPopup-button']");
    public SelenideElement searchOrderInputField = $x("//input[data-name = 'searchOrder-input']");
    public SelenideElement trackingButton = $x("//button[data-name = 'searchOrder-submitButton']");
    public SelenideElement orderNotFound = $x("//*[data-name = 'orderNotFound-container']");
}
