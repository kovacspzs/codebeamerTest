package com.codebeamerTest.app;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class CommonFunctions {
    private SelenideElement submitButton = $(By.cssSelector("input[type='submit']"));
    private SelenideElement yesButton = $(byXpath("//button[contains(text(),'Yes')]"));

    public void Submit() {
        submitButton.click();
    }

    public void Yes() {
        yesButton.click();
    }
}
