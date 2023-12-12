package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public SelenideElement login =  $x("//*[@data-name='username-input']");
    public SelenideElement password =  $x("//*[@data-name='password-input']");
    public SelenideElement signInButton = $x("//*[@data-name='signIn-button']");
    public SelenideElement errorIncorrectCredentials =  $x("//*[@data-name='authorizationError-popup']");
    //public SelenideElement orderPageVisible = $x("//*[@data-name='new order']");

    public OrderPage signInAndNavigateToOrder(){
        signInButton.click();
        return new OrderPage();
    }
}
