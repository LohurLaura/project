package org.tallinnlearning.laura;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class StepTest {

    @Test
    public void insertingIncorrectCredentialsAndCheckingTheErrorMessageTest() {
        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name=\"username-input\"]").setValue("WhateverName");
        $x("//input[@data-name=\"password-input\"]").setValue("ThePassword5");
        $x("//button[@data-name=\"signIn-button\"]").click();

        $x("//div[@data-name=\"authorizationError-popup\"]").shouldBe(Condition.exist, Condition.visible);
    }
}
