package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class OrderTest {
    OrderPage orderPage = new OrderPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("http://51.250.6.164:3000/signin");
        //Hardcoded jwt token is bad practice, but ok for now.
        Selenide.localStorage().setItem("jwt", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsYXVyYWFxYSIsImV4cCI6MTcwMTIxMzcxNSwiaWF0IjoxNzAxMTk1NzE1fQ.D4qEvzS5PfJLvuhPZ1dsuofJbWObVRFmcuBtO6Q2jwOlQ6PXdaIyJtZ1TezKdeHbgPXqkbQ6stRRXBU1JuJBzQ");
        Selenide.refresh();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void creatingAnOrder() {
        orderPage.name.sendKeys("CustomerName");
        orderPage.phone.sendKeys("55556666");
        orderPage.comment.sendKeys("Comment");
        orderPage.orderButton.click();
    }

    @Test
    public void creatingASuccessfulOrderAndCheckingTheConfirmationPopup(){
        orderPage.name.sendKeys("CustomerName");
        orderPage.phone.sendKeys("55556666");
        orderPage.comment.sendKeys("Comment");
        orderPage.orderButton.shouldBe(visible);
        orderPage.orderButton.click();
        orderPage.confirmationPopUp.shouldBe(Condition.exist, visible);
    }

    @Test
    public void creatingAnUnsuccessfulOrderAndOrderButtonIsDisabled(){
        orderPage.name.sendKeys("CustomerName");
        orderPage.orderButton.shouldBe(disabled);
    }

   @Test
   public void searchingOrderId123AndCheckingOrderNotFound(){
        orderPage.statusButton.click();
        orderPage.searchOrderInputField.sendKeys("123");
        orderPage.trackingButton.click();
        orderPage.orderNotFound.shouldBe(Condition.exist, visible);
    }
}
