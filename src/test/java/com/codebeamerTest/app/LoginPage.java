package com.codebeamerTest.app;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
    private SelenideElement loginButton = $(".login_button");
    private SelenideElement userName = $("#user");
    private SelenideElement passWord = $("#password");

    public void credentials(String username, String password) {
        userName.setValue(username);
        passWord.setValue(password);
        loginButton.click();
    }
}
